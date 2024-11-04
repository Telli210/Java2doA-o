package punto6;

public class Visitante {
	private int dniCliente; 
	private String aynCliente;
	private int edadCliente;
	
	public Visitante() {
		
	}
	
	public Visitante(int dniCliente, String aynCliente, int edadCliente) {
		this.dniCliente = dniCliente;
		this.aynCliente = aynCliente;
		this.edadCliente = edadCliente;
	}
	
	public int getEdadCliente() {
		return edadCliente;
	}

	@Override
	public String toString() {
		return "Cliente [dniCliente=" + dniCliente + ", aynCliente=" + aynCliente + ", edadCliente=" + edadCliente
				+ "]";
	}
	
	
	
}
