package cajero.demo.app.repository;


import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;


import cajero.demo.app.entity.Movimiento;


public interface MovimientoRepository extends JpaRepository<Movimiento, Long >{

	//@Query("select m from movimiento m where m.cuenta_id= :cuenta_id order by m.id")
    //List<Movimiento> GetMovimientosCuenta(@Param("cuenta_id") Long cuenta_id);
	
	List<Movimiento> findByCuentaId(Long id);
	
}
