package punto1;

public class Persona {
	private String nombre;
	private int añoDeNacimiento;
	private int dni;
	private String sexo;
	private double peso;
	private double altura;
	
	//Constructor 
	
	public Persona(int dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}
	
	
	//getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getAñoDeNacimiento() {
		return añoDeNacimiento;
	}
	public void setAñoDeNacimiento(int añoDeNacimiento) {
		this.añoDeNacimiento = añoDeNacimiento;
	}
	
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	//calculo del indice de masa corporal
	
	public double indiceMasaCorporal() {
		return peso/(altura*altura);
	}
	
	
	public boolean estaEnForma() {
		return (indiceMasaCorporal() >= 18 && indiceMasaCorporal() <= 25);
	}
	
	//Saber si es mayor de edad
	
	public boolean mayorEdad() {
		return ((2024 - añoDeNacimiento) >= 18);
	}
	
	//Saber si puede votar
	
	public boolean puedeVotar() {
		return ((2024 - añoDeNacimiento) >= 16); 
	}
	
	//Mostrar toda la informacion del objeto
	
	public String mostrarInfoObjeto() {
		return "Nombre: " + nombre + "\n" +
	           "Año de Nacimiento: " + añoDeNacimiento + "\n" +
	           "DNI: " + dni + "\n" +
	           "Sexo: " + sexo + "\n" +
	           "Peso: " + peso + " kg\n" +
	           "Altura: " + altura + " m\n" +
               "IMC: " + indiceMasaCorporal() + "\n" +
               "Está en forma: " + (estaEnForma() ? "Sí" : "No") + "\n" +
               "Mayor de edad: " + (mayorEdad() ? "Sí" : "No") + "\n" +
               "Puede votar: " + (puedeVotar() ? "Sí" : "No"); /*En la linea de esta en forma, es una forma
               simplificada de usar un if, la condicion de si es verdadero o no se divide por el ":", mientras
               que la condicion esta antes del ? */		               
	}
	
}
