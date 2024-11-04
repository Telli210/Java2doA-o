package punto2;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		ArticulosDeLibreria articulo = new ArticulosDeLibreria();
		int opcion;
		
		do {
			opcion = menu(entrada);
			switch(opcion) {
				case 1:{
					articulo.ingresoDatos(entrada);
					break;
				}
				case 2:{
					System.out.println("Ingrese la cantidad a depositar en el stock");
					articulo.depositarEnStock(entrada.nextInt());
					break;
				}
				case 3:{
					System.out.println("Ingrese la cantidad a retirar del stock");
					articulo.retirarStock(entrada.nextInt(), entrada);
					entrada.nextLine();//Se usa para limpiar el buffer despues de ingresar un nextInt o un nextDouble
					break;
				}
				case 4:{
					System.out.println(articulo.toString());
					break;
				}
			}
		}while(opcion != 5);
		entrada.close();
	}
	
	public static int menu(Scanner entrada) {
		System.out.println("1-Crear un articulo");
		System.out.println("2-Depositar una cantidad en el stock del articulo creado");
		System.out.println("3-Retirar una cantidad especifica del stock del articulo creado");
		System.out.println("4-Mostrar la informacion del producto creado");
		System.out.println("5-Salir");
		return entrada.nextInt();
	}

}
