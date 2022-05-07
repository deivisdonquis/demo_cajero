package cajero.demo.app.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cajero.demo.app.dto.MovimientoDto;
import cajero.demo.app.dto.TransferenciaDto;
import cajero.demo.app.entity.Cuenta;
import cajero.demo.app.entity.Movimiento;
import cajero.demo.app.entity.Tipomovimiento;
import cajero.demo.app.repository.MovimientoRepository;

@Service
@Transactional
public class MovimientoServiceImp implements MovimientoService{

	@Autowired
	private MovimientoRepository movimientoRepository;
	
	@Autowired
	CuentaService cuentaService;
	
	@Autowired
	TipomovimientoService tipomovimientoService;
	
	@Override
	public Movimiento save(Movimiento movimiento) {
		return movimientoRepository.save(movimiento);
	}

	@Override
	public Iterable<Movimiento> findAll() {
		return movimientoRepository.findAll();
	}

	@Override
	public Optional<Movimiento> findById(Long id) {
		return movimientoRepository.findById(id);
	}

	@Override
	public List<Movimiento> findByCuentaId(Long id) {
		return movimientoRepository.findByCuentaId(id);
	}

	@Override
	public void deleteById(Long id) {
		movimientoRepository.deleteById(id);
	}

	@Override
	public void delete(Movimiento movimiento) {
		movimientoRepository.delete(movimiento);
	}

	@Override
	public boolean transferencia(TransferenciaDto transferenciaDto) 
	{
		if(transferenciaDto.getCuenta_orig() == transferenciaDto.getCuenta_dest()  )
			return false;
			
			Optional<Cuenta> cuenta_T1 = cuentaService.findById(transferenciaDto.getCuenta_orig());
			Optional<Cuenta> cuenta_T2 = cuentaService.findById(transferenciaDto.getCuenta_dest());
			
			if(cuenta_T1.isPresent() && cuenta_T2.isPresent() && transferenciaDto.getMonto() >0 )
			{  
				Integer i=3;
				Tipomovimiento tipomovi = tipomovimientoService.findById(i.longValue()).get();
				
				Cuenta cuenta1 = cuentaService.findById( transferenciaDto.getCuenta_orig() ).get();
				Cuenta cuenta2 = cuentaService.findById( transferenciaDto.getCuenta_dest() ).get();
				
				Integer Saldo = cuenta1.getSaldo();
				
				if(Saldo >= transferenciaDto.getMonto())
				{
					//creando el retiro
					Movimiento movimiento = new Movimiento();
					movimiento.setSaldo_ant(Saldo);
					movimiento.setIngreso(0);
					movimiento.setGasto(transferenciaDto.getMonto());
					movimiento.setCuenta(cuenta1);
					movimiento.setTipomovimiento(tipomovi);
					movimiento.setDescripcion("Transferencia hacia la cuenta: "+cuenta2.getNumero_cuenta() );
								
					Integer newSaldo = Saldo - transferenciaDto.getMonto();
					cuenta1.setSaldo(newSaldo);
					
					movimientoRepository.save(movimiento);
					cuentaService.save(cuenta1);
					
					//creando el deposito
					Saldo = cuenta2.getSaldo();
					movimiento = new Movimiento();
					movimiento.setSaldo_ant(Saldo);
					movimiento.setIngreso(transferenciaDto.getMonto());
					movimiento.setGasto(0);
					movimiento.setCuenta(cuenta2);
					movimiento.setTipomovimiento(tipomovi);
					movimiento.setDescripcion("Transferencia recibida desde la cuenta: "+cuenta1.getNumero_cuenta() );
								
					newSaldo = Saldo + transferenciaDto.getMonto();
					cuenta2.setSaldo(newSaldo);
					
					movimientoRepository.save(movimiento);
					cuentaService.save(cuenta2);
					
					return true;
				}
				else
					return false;
				
			}
			else
			return false;
			
	}

	@Override
	public boolean deposito(MovimientoDto movDto) {
		
		Optional<Cuenta> cuenta_T = cuentaService.findById(movDto.getCuenta());
		
		if(cuenta_T.isPresent())
		{  
			Integer i=1;
			Tipomovimiento tipomovi = tipomovimientoService.findById(i.longValue()).get();
			Cuenta cuenta = cuentaService.findById( movDto.getCuenta()).get();
			Integer Saldo = 0;
			
			if(cuenta.getSaldo()!=null)
				Saldo =cuenta.getSaldo();
			
			Movimiento movimiento = new Movimiento();
			movimiento.setTipomovimiento(tipomovi);
			movimiento.setCuenta(cuenta);
			movimiento.setSaldo_ant(Saldo);
			movimiento.setGasto(0);
			movimiento.setIngreso(movDto.getMonto());
			movimiento.setDescripcion("Deposito");
			movimientoRepository.save(movimiento);
						
			Integer newSaldo = Saldo + movDto.getMonto();
			cuenta.setSaldo(newSaldo);
			cuentaService.save(cuenta);
			
			return false;
			
		}
		else
		return true;
		
	}

	@Override
	public boolean retiro(MovimientoDto movDto) {
		
		Optional<Cuenta> cuenta_T = cuentaService.findById(movDto.getCuenta() );
		
		if(cuenta_T.isPresent())
		{  
			Integer i=2;
			Tipomovimiento tipomovi = tipomovimientoService.findById(i.longValue()).get();
			Cuenta cuenta = cuentaService.findById( movDto.getCuenta() ).get();
			Integer Saldo = cuenta.getSaldo();
			
			if(Saldo>=movDto.getMonto())
			{
				Movimiento movimiento = new Movimiento();
				movimiento.setTipomovimiento(tipomovi);
				movimiento.setCuenta(cuenta);
				movimiento.setSaldo_ant(Saldo);
				movimiento.setIngreso(0);
				movimiento.setGasto(movDto.getMonto());
				movimiento.setDescripcion("Retiro");
				movimientoRepository.save(movimiento);
							
				Integer newSaldo = Saldo - movDto.getMonto();
				cuenta.setSaldo(newSaldo);
				cuentaService.save(cuenta);
				
				return true;
			}
			else
				return false;
			
		}
		else
		return false;
	}

}
