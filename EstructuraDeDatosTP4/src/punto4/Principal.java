package punto4;

import java.util.Random;
import java.util.Scanner;

import punto3.Helper;
import punto6.Visitante;

public class Principal {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Queue<Visitante> colaGeneral = new Queue<Visitante>(); 
		Queue<Visitante> colaCalesita = new Queue<Visitante>();
		Queue<Visitante> colaMontañaRusa = new Queue<Visitante>();
		int contMenores = 0;
		int contVisitantes = 0;
		
		Random numeroRandom = new Random();
		int numVisitantes = numeroRandom.nextInt(colaGeneral.size()) + 1;
		
		//Llena de datos la Queue general
		for(int i = 0;i < numVisitantes;i++) {
			colaGeneral.add(llenarDatosVisitantes(entrada));
		}
		
		//Distribuye a los visitantes entre la queue para la Calesita y la montaña rusa segun la edad
		while(!colaGeneral.isEmpty()) {
			
			Queue<Visitante> colaGeneralAuxiliar = llenarGruposCinco(colaGeneral);
			switch (elegirQueue(colaGeneral)){
				case 1 -> colaMontañaRusa.add(colaMontañaRusa.remove());
				case 2 -> colaCalesita.add(colaCalesita.remove());
				case 3 -> System.out.println("Por su edad no ingresa en ninguna categoria");
			}
		}
		
		contVisitantes = colaMontañaRusa.size() + colaCalesita.size();
		contMenores += contarMenores(colaMontañaRusa);
		
		
		ingresoAJuegos(colaMontañaRusa);
		ingresoAJuegos(colaCalesita);
		
		System.out.println("La cantidad de visitantes que tuvo el parque fue: "+ contVisitantes);
		System.out.println("La cantidad de visitantes menores de edad que tuvo el parque fue: "+ contMenores);
	}
	

	private static Visitante llenarDatosVisitantes(Scanner entrada) {

		int dniCliente = Helper.validarEntero(entrada, "Ingrese el DNI del cliente");
		String aynCliente = Helper.validarStringNoVacio(entrada, "Ingrese el apellido y nombre del cliente");
		int edadCliente = Helper.validarEntero(entrada, "Ingrese la edad del cliente");

		Visitante nuevoVisitante = new Visitante(dniCliente, aynCliente, edadCliente);
		return nuevoVisitante;
	}
	
	//La queue se modifica permanentemente dentro del modulo aunque no se la retorne como dato, cosa a tener en cuenta
	private static int elegirQueue(Queue<Visitante> colaGeneral){
		int queueDesignada;
		if(colaGeneral.peek().getEdadCliente() > 12) {
			return queueDesignada = 1;
		}else {if(colaGeneral.peek().getEdadCliente() < 12  || colaGeneral.peek().getEdadCliente() > 4) {
				return queueDesignada = 2;
			}
		}
		return queueDesignada = 3;
	}
	
	private static Queue<Visitante> llenarGruposCinco(Queue<Visitante> colaGeneral){
		Queue<Visitante> colaAuxiliar = new Queue<Visitante>();
		
		for(int i = 0;i < 5;i++) {
			if(colaGeneral.isEmpty()) {
				System.out.println("No se llego a completar 5 visitantes para completar la tanda");
			}else colaAuxiliar.add(colaGeneral.remove());
		}
		return colaAuxiliar;
	}
	
	//Hace el ingreso a los juegos
	private static void ingresoAJuegos(Queue<Visitante> colaJuego){
		
		while(colaJuego.isEmpty()) {
			colaJuego.remove().toString();
		}
	}
	
	//Cuenta la cantidad de Menores de edad
	private static int contarMenores(Queue<Visitante> colaJuego){
		Queue<Visitante> colaGeneralAuxiliar = colaJuego;//verificar si es necesario usar un auxiliar por si lo que pasa en el modulo afecta al main
		int contMenores = 0;
		while(colaJuego.isEmpty()) {
			
			if(colaJuego.remove().getEdadCliente() < 18)contMenores++;
		}
		return contMenores;
	}
}