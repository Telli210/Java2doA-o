package punto1;

import java.util.Scanner;

public class Inicio {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Vehiculo vehiculo1 = new Vehiculo();
		int contTipoDiesel = 0;
		int contTipoNafta = 0;
		String marcaDeterminada;
		
		vehiculo1.inicializarObjeto(entrada);
		System.out.println(vehiculo1.toString());
		contTipoDiesel += vehiculo1.cantidadTipoDiesel();
		contTipoNafta += vehiculo1.cantidadTipoNafta();
		
		
		Vehiculo vehiculo2 = new Vehiculo();
		vehiculo2.inicializarObjeto(entrada);
		System.out.println(vehiculo2.toString());
		contTipoDiesel += vehiculo2.cantidadTipoDiesel();
		contTipoNafta += vehiculo2.cantidadTipoNafta();
		
		
		Vehiculo vehiculo3 = new Vehiculo();
		vehiculo3.inicializarObjeto(entrada);
		System.out.println(vehiculo3.toString());
		contTipoDiesel += vehiculo3.cantidadTipoDiesel();
		contTipoNafta += vehiculo3.cantidadTipoNafta();
		
		System.out.println("Ingrese la determinada marca a mostrar");
		marcaDeterminada = entrada.nextLine();
		
		System.out.println("Los siguientes vehiculos coinciden con la marca ingresada: ");
		vehiculo1.mostrarMarcaDeterminada(marcaDeterminada);
		vehiculo2.mostrarMarcaDeterminada(marcaDeterminada);
		vehiculo3.mostrarMarcaDeterminada(marcaDeterminada);
		
		entrada.close();
	}

}
