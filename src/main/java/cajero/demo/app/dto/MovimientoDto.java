package cajero.demo.app.dto;

import java.io.Serializable;

public class MovimientoDto implements Serializable  {

	
	private static final long serialVersionUID = 1L;
	
	private Long cuenta;
	private Integer monto;
	
	public MovimientoDto() {}
	
	public MovimientoDto(Long cuenta, Integer monto) {
		super();
		this.cuenta = cuenta;
		this.monto = monto;
	}
	
	public Long getCuenta() {
		return cuenta;
	}
	
	public void setCuenta(Long cuenta) {
		this.cuenta = cuenta;
	}
	
	public Integer getMonto() {
		return monto;
	}
	
	public void setMonto(Integer monto) {
		this.monto = monto;
	}

}
