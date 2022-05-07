package cajero.demo.app.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="cuenta")
public class Cuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//@ManyToOne
    //@JoinColumn(name = "usuario_id", nullable=false )   //nombre de la columna en esta tabla
    //private Usuario usuario; 							//nombre del objeto relacion
	
	@Column(length = 20)
	private String numero_cuenta;
	
	@Column(length = 50)
	private String descripcion;
	
	private Integer saldo;
	
	@OneToMany(mappedBy = "cuenta")
    private List<Movimiento> movimientos;
	
	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	public Cuenta() {}
	
	public Cuenta( String numero_cuenta, String descripcion, Integer saldo) {
		
		this.numero_cuenta = numero_cuenta;
		this.descripcion = descripcion;
		this.saldo = saldo;
	}
	
	public Cuenta(Long id,  String numero_cuenta, String descripcion, Integer saldo) {
		super();
		this.id = id;
		
		this.numero_cuenta = numero_cuenta;
		this.descripcion = descripcion;
		this.saldo = saldo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	//public Usuario getUsuario() {
	//	return usuario;
	//}

//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}

	public String getNumero_cuenta() {
		return numero_cuenta;
	}

	public void setNumero_cuenta(String numero_cuenta) {
		this.numero_cuenta = numero_cuenta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getSaldo() {
		return saldo;
	}

	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}
	
	
	
	

}
