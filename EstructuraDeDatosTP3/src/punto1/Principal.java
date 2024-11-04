package punto1;

import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		String [] arreglo = {"Ram", "Rom", "Byte", "Navegador Web", "Antivirus", "Cooler", "Cache", "Programa", "Software", "Hardware"};
		Pila pila = new Pila(5);
		Random indiceRandom = new Random();
		int cantPalabras = 5;
		
		for(int i = 0; i < 5;i++) {
			pila.push(arreglo[indiceRandom.nextInt(10)]);
		}
		System.out.println("A continuacion ingrese "+ cantPalabras +" palabras");
		while(cantPalabras == 0 ) {
			
		}
		pila.push(null);
		pila.pop();
		pila.mostrarStack();
	}

}
