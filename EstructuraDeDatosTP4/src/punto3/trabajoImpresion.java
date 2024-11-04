package punto3;

public class trabajoImpresion {
	
	private int codTrabajo; 
	private String nomTrabajo;
	private int cantPagTrabajo;
	
	
	public trabajoImpresion() {
		
	}
	
	public trabajoImpresion(int codTrabajo, String nomTrabajo, int cantPagTrabajo) {
		this.codTrabajo = codTrabajo;
		this.nomTrabajo = nomTrabajo;
		this.cantPagTrabajo = cantPagTrabajo;
	}
	
	public int getCodTrabajo() {
		return codTrabajo;
	}
	public String getNomTrabajo() {
		return nomTrabajo;
	}
	public int getCantPagTrabajo() {
		return cantPagTrabajo;
	}
	
	
}
