package punto6;

import java.util.Scanner;

import punto3.Helper;

public class Principal {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Queue<Visitante> colaInicial = llenarDatosColaInicial(entrada);
		Queue<Visitante> colaCajas = new Queue<Visitante>();
		Queue<Visitante> colaCuentas = new Queue<Visitante>();

		while (!colaInicial.isEmpty()) {
			System.out.println(colaInicial.element().toString());
			System.out.println("Segun su tramite a realizar, que cola corresponde?");
			System.out.println("1-Cuentas/2-Cajas");
			int colaCorrespondiente = Helper.validarEnteroEnRango(entrada, "Rango", 1, 2);

			if (colaCorrespondiente == 1) {
				colaCuentas.add(colaInicial.remove());
			} else colaCajas.add(colaInicial.remove());
				
		}

		clientesAtendidosPorCola(colaCajas, colaCuentas);
		clientesMenorCuarentaAños(colaCajas);
	}

	private static Queue<Visitante> llenarDatosColaInicial(Scanner entrada) {

		Queue<Visitante> colaAuxiliar = new Queue<Visitante>();
		boolean continuar = true;
		while (!colaAuxiliar.isFull() || continuar) {

			colaAuxiliar.add(llenarDatosCliente(entrada));
			System.out.println("Desea ingresar datos de otro cliente?");
			System.out.println("1-Si/2-No");
			continuar = (Helper.validarEnteroEnRango(entrada, "", 1, 2) == 1) ? true : false;// Operador ternario

		}

		return colaAuxiliar;
	}

	// El usuario completa los datos del objeto Cliente
	private static Visitante llenarDatosCliente(Scanner entrada) {

		int dniCliente = Helper.validarEntero(entrada, "Ingrese el DNI del cliente");
		String aynCliente = Helper.validarStringNoVacio(entrada, "Ingrese el apellido y nombre del cliente");
		int edadCliente = Helper.validarEntero(entrada, "Ingrese la edad del cliente");

		Visitante nuevoCliente = new Visitante(dniCliente, aynCliente, edadCliente);
		return nuevoCliente;
	}

	// Muestra la cantidad de clientes atendidos en cada sector
	private static void clientesAtendidosPorCola(Queue<Visitante> colaCajas, Queue<Visitante> colaCuentas) {

		System.out.println("La cantidad de clientes atendidos en el sector cajas es: " + colaCajas.size());
		System.out.println("La cantidad de clientes atendidos en el sector cuentas es: " + colaCuentas.size());

	}
	
	//Muestra los clientes atendidos menores de 40 años en el sector cajas
	private static void clientesMenorCuarentaAños(Queue<Visitante> colaCajas) {
		
		System.out.println("A continuacion se muestran los clientes atendidos en el sector cajas menores de 40 años");
		while(!colaCajas.isEmpty()) {
			if(colaCajas.element().getEdadCliente() < 40) {
				System.out.println(colaCajas.element().toString());//Corregir
			}
			colaCajas.remove();
		}
		
	}

}
