package punto1;

public class Empleado {
	private int cuil;
	private String AyN;
	private int fechaIngreso;
	private double sueldo;
	private String departamento;
	
	
	public Empleado() {
	
	}

	public Empleado(int cuil, String ayN, int fechaIngreso, double sueldo, String departamento) {
		this.cuil = cuil;
		this.AyN = ayN;
		this.fechaIngreso = fechaIngreso;
		this.sueldo = sueldo;
		this.departamento = departamento;
	}

	public double getSueldo() {
		return sueldo;
	}
	
	
	
}
