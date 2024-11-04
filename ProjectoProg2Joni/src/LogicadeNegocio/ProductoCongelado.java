package LogicadeNegocio;


public class ProductoCongelado extends Producto {
	private String fechaEnvasado; // Fecha de envasado del producto refrigerado
	private String codigoSupervision; // Código de supervisión del producto congelado
    private String granjaOrigen; // Nombre de la granja de origen del producto congelado
    private double temperaturaRecomendada; // Temperatura recomendada para el producto congelado
    private double margenGanancia = 0.25; // Margen de ganancia del producto congelado

    // Constructor
    public ProductoCongelado(int CoddelProducto, String Descripcion, String fechaVencimiento, int numeroLote,
			double costoTratamiento, String fechaEnvasado, String codigoSupervision, String granjaOrigen,
			double temperaturaRecomendada) {
		super(CoddelProducto, Descripcion, fechaVencimiento, numeroLote, costoTratamiento);
		this.fechaEnvasado = fechaEnvasado;
		this.codigoSupervision = codigoSupervision;
		this.granjaOrigen = granjaOrigen;
		this.temperaturaRecomendada = temperaturaRecomendada;
	}

    // Getters y Setters

    // Métodos de acceso    
    public String getFechaEnvasado() {
		return fechaEnvasado;
	}

	public String getCodigoSupervision() {
        return codigoSupervision;
    }

    public String getGranjaOrigen() {
        return granjaOrigen;
    }

    public double getTemperaturaRecomendada() {
        return temperaturaRecomendada;
    }

    public double getMargenGanancia() {
        return margenGanancia;
    }

    // Métodos de modificación
    public void setFechaEnvasado(String fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}
    
    public void setCodigoSupervision(String codigoSupervision) {
        this.codigoSupervision = codigoSupervision;
    }

    public void setGranjaOrigen(String granjaOrigen) {
        this.granjaOrigen = granjaOrigen;
    }

    public void setTemperaturaRecomendada(double temperaturaRecomendada) {
        this.temperaturaRecomendada = temperaturaRecomendada;
    }

    // Método para calcular el precio de venta del producto congelado
    public double calcularPrecioVenta() {
        return getCostoTratamiento() * (1 + margenGanancia);
    }

	@Override
	public String toString() {
		return "ProductoCongelado [fechaEnvasado=" + fechaEnvasado + ", codigoSupervision=" + codigoSupervision
				+ ", granjaOrigen=" + granjaOrigen + ", temperaturaRecomendada=" + temperaturaRecomendada
				+ ", margenGanancia=" + margenGanancia + ", CoddelProducto=" + getCoddelProducto()
				+ ", Descripcion=" + getDescripcio() + ", FechaVencimiento=" + getFechaVencimiento()
				+ ", NumeroLote=" + getNumeroLote() + ", CostoTratamiento=" + getCostoTratamiento() + "]";
	}
    
    
}
