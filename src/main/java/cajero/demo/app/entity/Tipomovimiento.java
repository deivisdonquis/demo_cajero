package cajero.demo.app.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tipomovimiento")
public class Tipomovimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 20)
	private String nombre;
	
	@OneToMany(mappedBy = "tipomovimiento")
    private List<Movimiento> movimientos;

	public Tipomovimiento() {}
	
	public Tipomovimiento(String nombre) {
		this.nombre = nombre;
	}
	
	public Tipomovimiento(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	
	
	
	
	
	
}
