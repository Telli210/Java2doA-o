package punto2;

public class Electrodomestico {
	
	private int codigo;
	private String nombre;
	private	double precioBase;
	private	String color;
	private	double consumoElectrico;
	private	double peso;
	
	
	
	public Electrodomestico(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	//Getters y Setters
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getConsumoElectrico() {
		return consumoElectrico;
	}
	public void setConsumoElectrico(double consumoElectrico) {
		this.consumoElectrico = consumoElectrico;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	//Comprobar si es de bajo consumo
	
	public boolean esBajoConsumo() {
		return consumoElectrico < 45;
	}
	
	//Calcula el balance
	
	public double calculoBalance() {
		return precioBase / peso;
	}
	
	//Calcular si es alta gama 
	
	public double esAltaGama() {
		
	}
}
