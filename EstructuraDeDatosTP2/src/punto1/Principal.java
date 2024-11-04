package punto1;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		int dimension = Helper.validarEntero(entrada, "Ingrese la cantidad de empleados para sumar todos los sueldos: ");
		Empleado[] listaEmpleados= new Empleado[dimension];
		
		for(int i = 0;i < dimension;i++) {
			listaEmpleados[i] = llenarDatosEmpleado(entrada); 
		}
		
		calculoTotalSueldos(listaEmpleados);
	}
	
	
	public static Empleado llenarDatosEmpleado(Scanner entrada) {
		int cuil = Helper.validarEntero(entrada, "Ingrese el cuil del empleado");
		String ayN = Helper.validarStringNoVacio(entrada, "Ingrese el apellido y nombre del empleado");
		int fechaIngreso = Helper.validarEntero(entrada, "Ingrese la fecha en la que ingreso el empleado");
		double sueldo = Helper.validarDoubleNoNegativo(entrada, "Ingrese el sueldo del empleado");
		String departamento = Helper.validarStringNoVacio(entrada, "Ingrese el departamento del empleado");
		
		Empleado nuevoEmpleado = new Empleado(cuil, ayN, fechaIngreso, sueldo, departamento);
		return nuevoEmpleado;
	}
	
	public static void calculoTotalSueldos(Empleado[] listaEmpleados) {
		double sumador = 0;
		
		for(int i = 0;i < listaEmpleados.length;i++) {
			 sumador += listaEmpleados[i].getSueldo();
		}
		
		System.out.println();
		//Falta terminar
	}
}
