import java.util.Scanner;
public class Punto1 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int contadorMayusculas = 0;
		int contadorMinusculas = 0;
		char letra = 'a';
	
		System.out.println("Ingrese una cadena de texto");
		String cadenaTexto = entrada.nextLine();
		System.out.println(cadenaTexto.toUpperCase());
		System.out.println(cadenaTexto.toLowerCase());
		
		for(int i = 0;i < cadenaTexto.length();i++) {
			if(Character.isUpperCase(cadenaTexto.charAt(i))) {
				contadorMayusculas += 1;
			}
			if(Character.isLowerCase(cadenaTexto.charAt(i))) {
				contadorMinusculas += 1;
			}
			
		}
		System.out.println("La cantidad de Mayusculas es: "+contadorMayusculas);
		System.out.println("La cantidad de Minusculas es: "+contadorMinusculas);

	}
}