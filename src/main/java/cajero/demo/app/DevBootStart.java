package cajero.demo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import cajero.demo.app.entity.Cuenta;
import cajero.demo.app.entity.Tipomovimiento;
import cajero.demo.app.entity.Usuario;
import cajero.demo.app.services.CuentaService;
import cajero.demo.app.services.TipomovimientoService;
import cajero.demo.app.services.UsuarioService;

@Component
public class DevBootStart implements ApplicationListener<ContextRefreshedEvent > {

	@Autowired
	TipomovimientoService S_tipomov;
	@Autowired
	UsuarioService S_usu;
	@Autowired
	CuentaService S_cuenta;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) 
	{
		S_tipomov.save(new Tipomovimiento("Deposito") );
		S_tipomov.save(new Tipomovimiento("Retiro") );
		S_tipomov.save(new Tipomovimiento("Transferencia") );
		
		S_usu.save(new Usuario( "us1","clave","Usuario 1" ) );
		S_usu.save(new Usuario( "us2","clave","Usuario 2" ) );
		S_usu.save(new Usuario( "us3","clave","Usuario 3" ) );
		
		S_cuenta.save(new Cuenta( "1230-1230-1230-1230", "Cuenta usuario 1",0));
		S_cuenta.save(new Cuenta( "1234-1234-1234-1234", "Cuenta usuario 2",0));
		S_cuenta.save(new Cuenta( "1235-1235-1235-1235", "Cuenta usuario 3",0));
				
	}

}
