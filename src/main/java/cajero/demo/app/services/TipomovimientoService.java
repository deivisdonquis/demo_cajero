package cajero.demo.app.services;

import java.util.Optional;

import cajero.demo.app.entity.Tipomovimiento;


public interface TipomovimientoService {
	
	public Tipomovimiento save(Tipomovimiento usuario); 
	
	public Iterable<Tipomovimiento> findAll(); 	
	
	public Optional<Tipomovimiento> findById(Long id);  
	
	public void deleteById(Long id); 

}
