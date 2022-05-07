package cajero.demo.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cajero.demo.app.entity.Usuario;
import cajero.demo.app.repository.UsuarioRepository;


@Service
public class UsuarioServiceImp  implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save( usuario );
	}

	@Override
	public Iterable<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> findById(Long id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		 usuarioRepository.deleteById(id);
		
	}

}
