package LogicadeNegocio;

import java.io.Serializable;

public class ProductoRefrigerado extends Producto implements Serializable{
    private String codigoSupervision; // Código de supervisión del producto refrigerado
    private String fechaEnvasado; // Fecha de envasado del producto refrigerado
    private double temperaturaRecomendada; // Temperatura recomendada para el producto refrigerado
    private String granjaOrigen; // Nombre de la granja de origen del producto refrigerado
    private double margenGanancia = 0.15; // Margen de ganancia del producto refrigerado

    // Constructor
    public ProductoRefrigerado(int CoddelProducto, String Descripcion, String fechaVencimiento, int numeroLote,
			double costoTratamiento, String codigoSupervision, String fechaEnvasado, double temperaturaRecomendada,
			String granjaOrigen) {
		super(CoddelProducto, Descripcion, fechaVencimiento, numeroLote, costoTratamiento);
		this.codigoSupervision = codigoSupervision;
		this.fechaEnvasado = fechaEnvasado;
		this.temperaturaRecomendada = temperaturaRecomendada;
		this.granjaOrigen = granjaOrigen;
	}

    // Getters y Setters

    // Métodos de acceso
    public String getCodigoSupervision() {
        return codigoSupervision;
    }

    public String getFechaEnvasado() {
        return fechaEnvasado;
    }

    public double getTemperaturaRecomendada() {
        return temperaturaRecomendada;
    }

    public String getGranjaOrigen() {
        return granjaOrigen;
    }

    public double getMargenGanancia() {
        return margenGanancia;
    }

    // Métodos de modificación
    public void setCodigoSupervision(String codigoSupervision) {
        this.codigoSupervision = codigoSupervision;
    }

    public void setFechaEnvasado(String fechaEnvasado) {
        this.fechaEnvasado = fechaEnvasado;
    }

    public void setTemperaturaRecomendada(double temperaturaRecomendada) {
        this.temperaturaRecomendada = temperaturaRecomendada;
    }

    public void setGranjaOrigen(String granjaOrigen) {
        this.granjaOrigen = granjaOrigen;
    }

    public void setMargenGanancia(double margenGanancia) {
        this.margenGanancia = margenGanancia;
    }

    // Método para calcular el precio de venta del producto refrigerado
    public double calcularPrecioVenta() {
        return getCostoTratamiento() * (1 + margenGanancia);
    }
    
    @Override
	public String toString() {
		return "ProductoRefrigerado [codigoSupervision=" + codigoSupervision + ", fechaEnvasado=" + fechaEnvasado
				+ ", temperaturaRecomendada=" + temperaturaRecomendada + ", granjaOrigen=" + granjaOrigen
				+ ", margenGanancia=" + margenGanancia + ", CodigodelProducto=" + getCodigodelProducto()
				+ ", Descripcion=" + getDescripcion() + ", FechaVencimiento=" + getFechaVencimiento()
				+ ", NumeroLote=" + getNumeroLote() + ", CostoTratamiento=" + getCostoTratamiento() + "]";
	}
}