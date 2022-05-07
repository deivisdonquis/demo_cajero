package cajero.demo.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cajero.demo.app.entity.Cuenta;
import cajero.demo.app.services.CuentaService;




@Controller
@RequestMapping("/cuenta")
public class CuentaController {
	
	@Autowired
	CuentaService cuentaService;
	
	@GetMapping
	public String index(Model modelo) 
	{
		modelo.addAttribute("cuenta", new Cuenta());
		modelo.addAttribute("cuentas",cuentaService.findAll() );
		
		return "cuentas";
		
	}
	
	@PostMapping("/CrearCuenta")
	public String CrearCuenta(Model modelo, Cuenta cuenta) 
	{
		
		cuentaService.save(cuenta);
		
		modelo.addAttribute("cuenta", new Cuenta());
		modelo.addAttribute("cuentas",cuentaService.findAll() );
		
		return "cuentas";
		
	}
	
	@GetMapping("/EditarCuenta/{id}")
	public String EditarCuenta(Model modelo, @PathVariable(name="id") Long id) 
	{
		Optional<Cuenta> cuenta_T = cuentaService.findById(id);
		
		if(cuenta_T.isPresent()) 
		{
			Cuenta cuenta = cuentaService.findById(id).get();
			modelo.addAttribute("cuenta", cuenta );
			modelo.addAttribute("cuentas",cuentaService.findAll() );
			return "cuentas";
		}
		else
		{
			modelo.addAttribute("cuenta", new Cuenta());
			modelo.addAttribute("cuentas",cuentaService.findAll() );
			return "cuentas";
		}
		
	}
	
	@GetMapping("/EliminarCuenta/{id}")
	public String EliminarCuenta(Model modelo, @PathVariable(name="id") Long id) 
	{
		Optional<Cuenta> cuenta_T = cuentaService.findById(id);
		
		if(cuenta_T.isPresent()) 
		{
			Cuenta cuenta = cuentaService.findById(id).get();
			cuentaService.delete(cuenta);
			
			modelo.addAttribute("cuenta", new Cuenta());
			modelo.addAttribute("cuentas",cuentaService.findAll() );
			return "cuentas";
		}
		else
		{
			modelo.addAttribute("cuenta", new Cuenta());
			modelo.addAttribute("cuentas",cuentaService.findAll() );
			return "cuentas";
		}
		
	}

}
