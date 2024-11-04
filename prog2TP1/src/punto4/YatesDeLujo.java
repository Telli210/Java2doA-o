package punto4;

public class YatesDeLujo extends Barco{
	
	private float potenciaEnCV;
	private int numeroCamarotes;
	
	public YatesDeLujo(String matricula, float eslora, int anioFabricacion, float potenciaEnCV, int numeroCamarotes) {
		super(matricula, eslora, anioFabricacion);
		this.numeroCamarotes = numeroCamarotes;
		this.potenciaEnCV = potenciaEnCV;
	}
	//Getters y Setters
	public double getPotenciaEnCV() {
		return potenciaEnCV;
	}

	public void setPotenciaEnCV(float potenciaEnCV) {
		this.potenciaEnCV = potenciaEnCV;
	}

	public int getNumeroCamarotes() {
		return numeroCamarotes;
	}

	public void setNumeroCamarotes(int numeroCamarotes) {
		this.numeroCamarotes = numeroCamarotes;
	}
	//El Override se usa para indicar que el modulo esta sobreescribiendo uno ya definido en la superclase
	@Override
	public float calcularModulo() {
		return super.calcularModulo() + potenciaEnCV + numeroCamarotes;
	}

}
