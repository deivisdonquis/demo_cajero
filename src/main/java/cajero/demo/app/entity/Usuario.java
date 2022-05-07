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
@Table(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 20)
	private String login;
	
	@Column(length = 20)
	private String clave;
	
	@Column(length = 20)
	private String nombre;
	
	// objeto relacion que asocia esta tabla con cuenta atravez del id de esta con el objeto usuatio 
	//@OneToMany(mappedBy = "usuario")
    //private List<Cuenta> cuentas;

	
	public Usuario() {}
	
	public Usuario( String login, String clave, String nombre) {
		this.login = login;
		this.clave = clave;
		this.nombre = nombre;
	}
	
	public Usuario(Long id, String login, String clave, String nombre) {
		super();
		this.id = id;
		this.login = login;
		this.clave = clave;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}  
	
	
	
	

}
