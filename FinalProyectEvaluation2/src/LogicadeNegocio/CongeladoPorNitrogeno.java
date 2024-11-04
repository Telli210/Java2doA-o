package LogicadeNegocio;

import java.io.Serializable;

public class CongeladoPorNitrogeno extends ProductoCongelado implements Serializable {
	 private String metodoCongelacion; // Método utilizado para congelar el producto con nitrógeno
	 private double tiempoExposicionNitrógeno; // Tiempo de exposición al nitrógeno durante el proceso de congelación

	// Constructor
   public CongeladoPorNitrogeno(int CoddelProducto, String Descripcion, String fechaVencimiento, int numeroLote,
			double costoTratamiento, String fechaEnvasado, String codigoSupervision, String granjaOrigen,
			double temperaturaRecomendada, String metodoCongelacion, double tiempoExposicionNitrógeno) {
		super(CoddelProducto, Descripcion, fechaVencimiento, numeroLote, costoTratamiento, fechaEnvasado,
				codigoSupervision, granjaOrigen, temperaturaRecomendada);
		this.metodoCongelacion = metodoCongelacion;
		this.tiempoExposicionNitrógeno = tiempoExposicionNitrógeno;
	}

	// Métodos de acceso
	public String getMetodoCongelacion() {
		return metodoCongelacion;
	}

	public double getTiempoExposicionNitrógeno() {
		return tiempoExposicionNitrógeno;
	}

	// Métodos de modificación
	public void setMetodoCongelacion(String metodoCongelacion) {
		this.metodoCongelacion = metodoCongelacion;
	}

	public void setTiempoExposicionNitrógeno(double tiempoExposicionNitrógeno) {
		this.tiempoExposicionNitrógeno = tiempoExposicionNitrógeno;
	}
}

