package punto1;

import java.util.Scanner;

public class Vehiculo {
	private	String marca;
	private	String modelo;
	private	String tipoMotor;
	
	public Vehiculo() {
		this.marca = "Desconocida";
		this.modelo = "Sin modelo";
		this.tipoMotor = "Desconocido";
		
	}

	public Vehiculo(String marca, String modelo, String tipoMotor) {
		
		this.marca = marca;
		this.modelo = modelo;
		this.tipoMotor = tipoMotor;
		
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipoMotor() {
		return tipoMotor;
	}

	public void setTipoMotor(String tipoMotor) {
		this.tipoMotor = tipoMotor;
	}
	
	//Metodos
	
	public void inicializarObjeto(Scanner entrada) {
		
		System.out.println("Ingrese la marca");
		marca = entrada.nextLine();
		System.out.println("Ingrese el modelo");
		modelo = entrada.nextLine();
		do {
			System.out.println("Ingrese el tipo de motor (diesel/naftero)");
			tipoMotor = entrada.nextLine().toLowerCase();
		}while(!tipoMotor.equalsIgnoreCase("diesel") && !tipoMotor.equalsIgnoreCase("nafta"));
		//Se usa el equalsIgnoreCase para evitar un error con las minusculas y mayusculas
		
	}
	
	//Muestra el vehiculo
	public String toString() {
		return "Vehiculo [marca:" + marca + ", modelo:" + modelo + ", tipoMotor:" + tipoMotor + "]";
	}

	public void mostrarMarcaDeterminada(String marcaDeterminada) {
		if(marca.equalsIgnoreCase(marcaDeterminada))System.out.println(toString());;
	}
	
	
	public int cantidadTipoNafta() {
		int cantidadTipoNafta = 0;
		if(tipoMotor.equals("nafta"))cantidadTipoNafta ++;
		
		return cantidadTipoNafta;
	}
	
	public int cantidadTipoDiesel() {
		int cantidadTipoDiesel = 0;
		if(tipoMotor.equals("diesel"))cantidadTipoDiesel ++;
		
		return cantidadTipoDiesel;
	}
	
	
}