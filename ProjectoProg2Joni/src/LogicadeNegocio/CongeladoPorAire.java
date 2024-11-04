package LogicadeNegocio;

public class CongeladoPorAire extends ProductoCongelado {
    private double porcentajeNitrógeno; // Porcentaje de nitrógeno en el producto congelado por aire
    private double porcentajeOxigeno; // Porcentaje de oxígeno en el producto congelado por aire
    private double porcentajeDioxidoCarbono; // Porcentaje de dióxido de carbono en el producto congelado por aire
    private double porcentajeVaporAgua; // Porcentaje de vapor de agua en el producto congelado por aire

    // Constructor
    public CongeladoPorAire(int CoddelProducto, String Descripcion, String fechaVencimiento, int numeroLote,
			double costoTratamiento, String fechaEnvasado, String codigoSupervision, String granjaOrigen,
			double temperaturaRecomendada, double porcentajeNitrógeno, double porcentajeOxigeno,
			double porcentajeDioxidoCarbono, double porcentajeVaporAgua) {
		super(CoddelProducto, Descripcion, fechaVencimiento, numeroLote, costoTratamiento, fechaEnvasado,
				codigoSupervision, granjaOrigen, temperaturaRecomendada);
		this.porcentajeNitrógeno = porcentajeNitrógeno;
		this.porcentajeOxigeno = porcentajeOxigeno;
		this.porcentajeDioxidoCarbono = porcentajeDioxidoCarbono;
		this.porcentajeVaporAgua = porcentajeVaporAgua;
	}

    // Métodos de acceso
    public double getPorcentajeNitrógeno() {
        return porcentajeNitrógeno;
    }

    public double getPorcentajeOxigeno() {
        return porcentajeOxigeno;
    }

    public double getPorcentajeDioxidoCarbono() {
        return porcentajeDioxidoCarbono;
    }

    public double getPorcentajeVaporAgua() {
        return porcentajeVaporAgua;
    }

    // Métodos de modificación
    public void setPorcentajeNitrógeno(double porcentajeNitrógeno) {
        this.porcentajeNitrógeno = porcentajeNitrógeno;
    }

    public void setPorcentajeOxigeno(double porcentajeOxigeno) {
        this.porcentajeOxigeno = porcentajeOxigeno;
    }

    public void setPorcentajeDioxidoCarbono(double porcentajeDioxidoCarbono) {
        this.porcentajeDioxidoCarbono = porcentajeDioxidoCarbono;
    }

    public void setPorcentajeVaporAgua(double porcentajeVaporAgua) {
        this.porcentajeVaporAgua = porcentajeVaporAgua;
    }
}
