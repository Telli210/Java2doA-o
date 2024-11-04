import java.util.Scanner;
public class Punto2 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		float montoAcumuladoInversion = 0;
		float auxiliar = 0;
		
		System.out.println("Calculadora del monto acumulado de una inversión a lo largo de varios años con interés compuesto");
		System.out.println("Ingrese el capital inicial");
		float capitalInicial = entrada.nextFloat();
		System.out.println("Ingrese la tasa de interes anual");
		float tasaInteresAnual = entrada.nextFloat();
		System.out.println("Ingrese el numero de años");
		int numeroAños = entrada.nextInt();
		
		auxiliar = (1 + tasaInteresAnual/100);
		
		for(int i = 1;i <= numeroAños;i ++) {
			float potencia = obtenerPotencia(auxiliar, i);
			montoAcumuladoInversion = capitalInicial * potencia;
			System.out.println("Al final del año nro: "+i+", el monto acumulado es: "+montoAcumuladoInversion);
		}
		
		
	}
	
	public static float obtenerPotencia(float auxiliar, int cantAños) {
		float potencia = auxiliar;
		
		for(int i = 0;i < cantAños-1 ; i++) {/*Recordemos que una potencia elevada a uno es igual a si mismo, por eso no es necesario que si son 5 años se ejecute 5 veces, ya que la primera vez no tiene
		que multiplicarse*/
			potencia *= auxiliar;
		}
		
		return potencia;
	}

}
