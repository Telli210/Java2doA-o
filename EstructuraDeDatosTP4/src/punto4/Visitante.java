package punto4;

public class Visitante {
	private int idVisitante;
	private String aynVisitante;
	private int edad;
	
	public Visitante() {
		
	}
	
	public Visitante(int idVisitante, String aynVisitante, int edad) {
		
		this.idVisitante = idVisitante;
		this.aynVisitante = aynVisitante;
		this.edad = edad;
	}

	public int getEdad() {
		return edad;
	}

	@Override
	public String toString() {
		return "Visitante [idVisitante=" + idVisitante + ", aynVisitante=" + aynVisitante + ", edad=" + edad + "]";
	}
	
	
	
}
