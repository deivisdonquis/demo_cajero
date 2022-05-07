package cajero.demo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cajero.demo.app.dto.MovimientoDto;
import cajero.demo.app.dto.TransferenciaDto;
import cajero.demo.app.entity.Cuenta;

import cajero.demo.app.services.CuentaService;
import cajero.demo.app.services.MovimientoService;
import cajero.demo.app.services.TipomovimientoService;


@Controller
@RequestMapping("/movimiento")
public class MovimientoController {
	
	@Autowired
	CuentaService cuentaService;
	
	@Autowired
	TipomovimientoService tipomovimientoService;
	
	@Autowired
	MovimientoService movimientoService;
	
	
	
	@RequestMapping(value="", method = { RequestMethod.POST,RequestMethod.GET })
	public String movimientos(Model modelo, Cuenta cuenta) 
	{
		if(cuenta.getId()==null)
		{
			modelo.addAttribute("cuenta", new Cuenta());
			modelo.addAttribute("cuentas",cuentaService.findAll() );
		}
		else
		{
			modelo.addAttribute("cuenta", cuenta);
			modelo.addAttribute("cuentas",cuentaService.findAll() );
			modelo.addAttribute("movimientos",movimientoService.findByCuentaId(cuenta.getId()));
		
		}
		return "movimientos";
		
	}
	
	@RequestMapping(value="/consulta", method = { RequestMethod.POST,RequestMethod.GET })
	public String consulta(Model modelo, Cuenta cuenta) 
	{
		if(cuenta.getId()==null)
		{
			modelo.addAttribute("cuenta", new Cuenta());
			modelo.addAttribute("cuentas",cuentaService.findAll() );
		}
		else
		{
			Cuenta C = cuentaService.findById(cuenta.getId()).get();
			modelo.addAttribute("cuenta",new Cuenta());
			modelo.addAttribute("cuentas",cuentaService.findAll() );
			modelo.addAttribute("saldo",C.getSaldo() );
		}
		return "consulta";
		
	}
	
	@GetMapping("/deposito")
	public String Deposito(Model modelo, MovimientoDto movDto) 
	{
		modelo.addAttribute("movDto", new MovimientoDto());
		modelo.addAttribute("cuentas",cuentaService.findAll() );
		return "deposito";
	}
	
	@PostMapping("/CrearDeposito")
	public String CrearDeposito(Model modelo, MovimientoDto movDto) 
	{
		if(movimientoService.deposito(movDto))
			return "exito";
		else
			return "fallo";
	}

	
	@GetMapping("/retiro")
	public String Retiro(Model modelo, MovimientoDto movDto) 
	{
		modelo.addAttribute("movDto", new MovimientoDto());
		modelo.addAttribute("cuentas",cuentaService.findAll() );
		
		return "retiro";
		
	}

	@PostMapping("/CrearRetiro")
	public String CrearRetiro(Model modelo, MovimientoDto movDto) 
	{
		if(movimientoService.retiro(movDto))
			return "exito";
		else
			return "fallo";
	}
	
	@GetMapping("/transferencia")
	public String Transferencia(Model modelo, TransferenciaDto transferenciaDto) 
	{
		modelo.addAttribute("transferenciaDto", new TransferenciaDto());
		modelo.addAttribute("cuentas",cuentaService.findAll() );
		return "transferencia";
	}

	@PostMapping("/CrearTransferencia")
	public String CrearTransferencia(Model modelo, TransferenciaDto transferenciaDto) 
	{
		if(movimientoService.transferencia(transferenciaDto))
			return "exito";
		else
			return "fallo";
	}


	
}
