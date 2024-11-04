package punto4;

public class EmbarcacionesDeportivas extends Barco{
	
	private float potenciaEnCV;
	
	public EmbarcacionesDeportivas(String matricula, float eslora, int anioFabricacion, float potenciaEnCV) {
		super(matricula, eslora, anioFabricacion);
		this.potenciaEnCV = potenciaEnCV;
	}
	
	
	//Getters y Setters
	public float getPotenciaEnCV() {
		return potenciaEnCV;
	}

	public void setPotenciaEnCV(float potenciaEnCV) {
		this.potenciaEnCV = potenciaEnCV;
	}
	
	//El Override se usa para indicar que el modulo esta sobreescribiendo uno ya definido en la superclase
	@Override
	public float calcularModulo() {
		return super.calcularModulo()+potenciaEnCV;
	}
	
	
}
