package punto1;
import java.util.Scanner;

public class Inicio {

	public static void main(String[] args) {
		Persona unaPersona = new Persona(0, null);
		Scanner entrada = new Scanner(System.in);
		int fechaNacimiento;
		
		System.out.println("Ingrese la fecha de Nacimiento");
		unaPersona.setAñoDeNacimiento(fechaNacimiento = entrada.nextInt());
		System.out.println(unaPersona.mayorEdad());
		
	}

}
