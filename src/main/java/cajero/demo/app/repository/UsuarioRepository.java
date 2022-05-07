package cajero.demo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cajero.demo.app.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long >{

}
