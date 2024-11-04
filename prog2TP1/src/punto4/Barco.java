package punto4;

public class Barco {
    private String matricula;
    private float eslora; 
    private int anioFabricacion;

    public Barco(String matricula, float eslora, int anioFabricacion) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.anioFabricacion = anioFabricacion;
    }
    
    //Getters y Setters
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public float getEslora() {
		return eslora;
	}

	public void setEslora(float eslora) {
		this.eslora = eslora;
	}

	public int getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(int anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}
	
	
	
	public float calcularModulo() {
        return eslora * 10;
    }
    
}
