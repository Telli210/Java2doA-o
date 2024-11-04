package punto3;
import java.util.Scanner;
public class punto3 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in); 
		String opcion;
		float saldo = 0;
		 /*Consultar si es necesatio usar el try y el catch para validar en este ejercicio*/
		do {
			opcion = menuOpcion();
			switch(opcion) {
				case "a":
					System.out.println("El saldo disponible es: $"+saldo+"");
					break;
				
				case "b":
					saldo = depositarDinero(saldo);
					break;
					
				case "c":
					saldo = retirarDinero(saldo);
					break;
				
				case "d":
					break;
					
				default:
					System.out.println("Error, por favor seleccione una opcion valida");
			
			}
			
		}while(!opcion.equals("d"));

	}
	
	public static String menuOpcion(){
		
		Scanner entrada = new Scanner(System.in);
		String opcion;
		
		System.out.println("a)Consultar el saldo");
		System.out.println("b)Depositar dinero");
		System.out.println("c)Retirar dinero");
		System.out.println("d)Salir");
		opcion = entrada.next();
		
		return opcion;
	}
	
	public static float depositarDinero(float saldo){
		Scanner entrada = new Scanner(System.in);

		System.out.println("Ingrese el monto a depositar");
		float montoDepositado = entrada.nextFloat();
		saldo += montoDepositado;
		System.out.println("Su saldo es de: $"+saldo);
		return saldo;
	}
	
	public static float retirarDinero(float saldo) {
		Scanner entrada = new Scanner (System.in);
		float montoRetirado;
		final float condicion = saldo;
		
		do {
			System.out.println("Ingrese el monto a retirar");
			montoRetirado = entrada.nextFloat();
			
			if(montoRetirado <= saldo) {
				saldo -= montoRetirado;
			}else {
				System.out.println("Error, el monto ingresado excede el saldo disponible");
				System.out.println("Debera ingresar un monto valido");
			}
		}while(montoRetirado > condicion);
		
		
		return saldo;
	}

}
