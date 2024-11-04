package LogicadeNegocio;

public class CongeladoPorAgua extends ProductoCongelado {
    private double salinidadAgua; // Salinidad del agua para el producto congelado por agua

    // Constructor
    public CongeladoPorAgua(int CoddelProducto, String Descripcion, String fechaVencimiento, int numeroLote,
			double costoTratamiento, String fechaEnvasado, String codigoSupervision, String granjaOrigen,
			double temperaturaRecomendada, double salinidadAgua) {
		super(CoddelProducto, Descripcion, fechaVencimiento, numeroLote, costoTratamiento, fechaEnvasado,
				codigoSupervision, granjaOrigen, temperaturaRecomendada);
		this.salinidadAgua = salinidadAgua;
	}

    // Métodos de acceso
    public double getSalinidadAgua() {
        return salinidadAgua;
    }

    // Métodos de modificación
    public void setSalinidadAgua(double salinidadAgua) {
        this.salinidadAgua = salinidadAgua;
    }
}

