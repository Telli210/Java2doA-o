package punto2;

import java.util.ArrayList;
import java.util.Scanner;

public class AdministradorDeListas {
	private ArrayList<String> datos;
	private Scanner entrada;

	public AdministradorDeListas() {
		this.datos = new ArrayList<String>();
		this.entrada = new Scanner (System.in);
	}
	
	public AdministradorDeListas(ArrayList<String> datos) {
		this.datos = datos;
	}
	
	public void añadir(String nuevo) {
		datos.add(nuevo);
	}
	
	public void eliminar() {
		System.out.println("Desea eliminar un elemento por coincidencia o por posicion?");
		System.out.println("1-Por concidencia");
		System.out.println("2-Por posicion");
		int opcion = Helper.validarEnteroEnRango(entrada, null, 1, 2);
		
		switch(opcion) {
			case 1:
				String elementoAEliminar = Helper.validarStringNoVacio(entrada, "Ingrese el elemento a eliminar");
				datos.remove(elementoAEliminar);
				break;
			case 2:
				int indice = Helper.validarEnteroEnRango(entrada, "Ingrese el indice del elementoa  eliminar", 0, datos.size());
				datos.remove(indice);
				break;
		}
		datos.remove(0);
	}
	
	public void buscarElemento(String elemento) {
		for(int i = 0; i < datos.size();i++) {
			
		}
	}
}
