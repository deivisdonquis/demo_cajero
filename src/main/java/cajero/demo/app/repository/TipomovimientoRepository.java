package cajero.demo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cajero.demo.app.entity.Tipomovimiento;

public interface TipomovimientoRepository extends JpaRepository<Tipomovimiento,Long >{

}
