package punto4;

public class Velero extends Barco{
	
	private int numeroMastiles;
	
	public Velero(String matricula, float eslora, int anioFabricacion, int numeroMastiles) {
		super(matricula, eslora, anioFabricacion);
		this.numeroMastiles = numeroMastiles;
	}
	
	
	//Getters y Setters
	public int getNumeroMastiles() {
		return numeroMastiles;
	}

	public void setNumeroMastiles(int numeroMastiles) {
		this.numeroMastiles = numeroMastiles;
	}
	
	//El Override se usa para indicar que el modulo esta sobreescribiendo uno ya definido en la superclase
	@Override
	public float calcularModulo() {
		return super.calcularModulo()+numeroMastiles;
	}
	

}
