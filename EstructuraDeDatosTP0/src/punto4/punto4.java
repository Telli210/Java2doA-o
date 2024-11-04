package punto4;
import java.util.Scanner;
import java.util.Random;

public class punto4 {

	public static void main(String[] args) {
		Random valorAlAzar = new Random();
		Scanner entrada = new Scanner(System.in);
		int numAleatorio = valorAlAzar.nextInt(101);
		int contIntentos = 0;
		int numElejido;
		System.out.println(numAleatorio);
		do {
			System.out.println("Elija un numero entre 0 y 100 para adivinar");
			numElejido = entrada.nextInt();
			contIntentos += 1;
			demasiadoAltoOBajo(numAleatorio, numElejido);
			
			
		}while(numElejido != numAleatorio);
		System.out.println("El numero de intentos es de: "+contIntentos);

	}
	
	public static void demasiadoAltoOBajo(int numAleatorio,int numElejido) {
		if((numAleatorio - numElejido) >= 10) {
			System.out.println("El intento fue demasiado Alto");
		}else {
			if((numAleatorio - numElejido) >= -10) {
				System.out.println("El intento fue demasiado Bajo");
			}
		}
	}
	
}
