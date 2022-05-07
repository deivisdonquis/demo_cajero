package cajero.demo.app.dto;

import java.io.Serializable;


public class TransferenciaDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long cuenta_orig;
	private Long cuenta_dest;
	private Integer monto;
	
	public TransferenciaDto() {}
	
	public TransferenciaDto(Long cuenta_orig, Long cuenta_dest, Integer monto) {
		super();
		this.cuenta_orig = cuenta_orig;
		this.cuenta_dest = cuenta_dest;
		this.monto = monto;
	}
	
	public Long getCuenta_orig() {
		return cuenta_orig;
	}
	public void setCuenta_orig(Long cuenta_orig) {
		this.cuenta_orig = cuenta_orig;
	}
	public Long getCuenta_dest() {
		return cuenta_dest;
	}
	public void setCuenta_dest(Long cuenta_dest) {
		this.cuenta_dest = cuenta_dest;
	}
	public Integer getMonto() {
		return monto;
	}
	public void setMonto(Integer monto) {
		this.monto = monto;
	}
	
	

}
