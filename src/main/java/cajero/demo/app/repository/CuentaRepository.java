package cajero.demo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cajero.demo.app.entity.Cuenta;

@Repository
public interface CuentaRepository  extends JpaRepository<Cuenta,Long >{

}
