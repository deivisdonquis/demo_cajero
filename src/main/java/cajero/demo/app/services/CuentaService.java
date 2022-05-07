package cajero.demo.app.services;

import java.util.Optional;

import cajero.demo.app.entity.Cuenta;

public interface CuentaService {
	
	public Cuenta save(Cuenta cuenta); 
	
	public Iterable<Cuenta> findAll(); 	
	
	public Optional<Cuenta> findById(Long id);  
	
	public void deleteById(Long id); 
	
	public void delete(Cuenta cuenta); 

}
