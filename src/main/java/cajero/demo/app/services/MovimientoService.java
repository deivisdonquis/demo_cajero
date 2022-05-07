package cajero.demo.app.services;

import java.util.List;
import java.util.Optional;

import cajero.demo.app.dto.MovimientoDto;
import cajero.demo.app.dto.TransferenciaDto;
import cajero.demo.app.entity.Movimiento;

public interface MovimientoService {
	
	
	public Movimiento save(Movimiento movimiento); 
	
	public Iterable<Movimiento> findAll(); 	
	
	public Optional<Movimiento> findById(Long id);  
	
	List<Movimiento> findByCuentaId(Long id);
	
	public void deleteById(Long id); 
	
	public void delete(Movimiento movimiento); 
	
	public boolean transferencia(TransferenciaDto transferenciaDto); 
	
	public boolean deposito(MovimientoDto movDto);
	
	public boolean retiro(MovimientoDto movDto);

}
