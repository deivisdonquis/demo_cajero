package cajero.demo.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="movimiento")
public class Movimiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "cuenta_id", nullable=false )   //nombre de la columna en esta tabla
    private Cuenta cuenta; 							//nombre del objeto relacion
	
	@Transient
	private Long cuenta_id;
	
	@ManyToOne
    @JoinColumn(name = "tipomovimiento_id", nullable=false )   //nombre de la columna en esta tabla
    private Tipomovimiento tipomovimiento; 							//nombre del objeto relacion
	
	
	@Column(length = 100)
	private String descripcion;
	
	private Integer saldo_ant;
	
	private Integer ingreso;
	
	private Integer gasto;
	
	@Column(length = 10)
	private String fechamov;
	
	public Movimiento() {}
	
	public Movimiento(Long id, Cuenta cuenta, Tipomovimiento tipomovimiento, String descripcion, Integer saldo_ant,
			Integer ingreso, Integer gasto, String fechamov) {
		super();
		this.id = id;
		this.cuenta = cuenta;
		this.tipomovimiento = tipomovimiento;
		this.descripcion = descripcion;
		this.saldo_ant = saldo_ant;
		this.ingreso = ingreso;
		this.gasto = gasto;
		this.fechamov = fechamov;
	}
	

	public Long getCuenta_id() {
		return cuenta_id;
	}

	public void setCuenta_id(Long cuenta_id) {
		this.cuenta_id = cuenta_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Tipomovimiento getTipomovimiento() {
		return tipomovimiento;
	}

	public void setTipomovimiento(Tipomovimiento tipomovimiento) {
		this.tipomovimiento = tipomovimiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getSaldo_ant() {
		return saldo_ant;
	}

	public void setSaldo_ant(Integer saldo_ant) {
		this.saldo_ant = saldo_ant;
	}

	public Integer getIngreso() {
		return ingreso;
	}

	public void setIngreso(Integer ingreso) {
		this.ingreso = ingreso;
	}

	public Integer getGasto() {
		return gasto;
	}

	public void setGasto(Integer gasto) {
		this.gasto = gasto;
	}

	public String getFechamov() {
		return fechamov;
	}

	public void setFechamov(String fechamov) {
		this.fechamov = fechamov;
	}
	
	
	
	
	
	

}
