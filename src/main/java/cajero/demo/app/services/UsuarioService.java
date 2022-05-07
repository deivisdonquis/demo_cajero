package cajero.demo.app.services;

import java.util.Optional;

import cajero.demo.app.entity.Usuario;

public interface UsuarioService {
	
	public Usuario save(Usuario usuario); 
	
	public Iterable<Usuario> findAll(); 	
	
	public Optional<Usuario> findById(Long id);  
	
	public void deleteById(Long id); 
}
