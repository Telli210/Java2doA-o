package punto2;

import java.util.ArrayList;
import java.util.Scanner;

public class Serie {

	private ArrayList<ArrayList<Episodio>> temporadas;
	private String titulo;
	private String descripcion;
	private String creador;
	private String genero;

	
	public ArrayList<ArrayList<Episodio>> getTemporadas() {
		return temporadas;
	}




	public void setTemporadas(ArrayList<ArrayList<Episodio>> temporadas) {
		this.temporadas = temporadas;
	}




	public String getTitulo() {
		return titulo;
	}




	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}




	public String getDescripcion() {
		return descripcion;
	}




	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	public String getCreador() {
		return creador;
	}




	public void setCreador(String creador) {
		this.creador = creador;
	}




	public String getGenero() {
		return genero;
	}




	public void setGenero(String genero) {
		this.genero = genero;
	}


	
	// b)Obtener el total episodios vistos de una temporada particular.
	public void episodiosVistosTemporada(Scanner entrada) {
		int contador = 0;
		System.out.println("Ingrese el nro de la temporada para obtener la cantidad de episodios vistos");
		int temporada = entrada.nextInt() - 1;
		for (int episodio = 0; episodio < temporadas.get(temporada).size(); episodio++) {

			if (temporadas.get(temporada).get(episodio).getEpisodioVisto()) {
				contador++;
			}
		}
		System.out.println("El total de episodios vistos en la temporada " + (temporada + 1) + " es: " + contador);
	}
	
	//c)Obtener el total de episodios vistos de una serie.
	public void episodiosVistosTotal() {
		int contador = 0;
		for (int temporada = 0; temporada < temporadas.size(); temporada++) {
			for (int episodio = 0; episodio < temporadas.get(temporada).size(); episodio++) {
				if (temporadas.get(temporada).get(episodio).getEpisodioVisto()) {
					contador++;
				}
			}
		}

		System.out.println("El total de episodios vistos es: " + contador);
	}
	
	//d)Obtener el promedio de las calificaciones dadas por el usuario para una temporada particular.  
	
	public void promedioCalificacionesTemporada(Scanner entrada) {
		double sumador = 0;
		double contadorCapitulosVistos = 0;
		System.out.println("Ingrese el nro de la temporada para obtener el promedio de las calificaciones:");
		int temporada = entrada.nextInt() - 1;
		for (int episodio = 0; episodio < temporadas.get(temporada).size(); episodio++) {
			if (temporadas.get(temporada).get(episodio).getEpisodioVisto()) {
				sumador += temporadas.get(temporada).get(episodio).getCalificacion();
				contadorCapitulosVistos ++;
			}
		}
		System.out.println("El promedio de calificaciones de los espisodios vistos de la temporada "+temporada+"es "+ sumador/contadorCapitulosVistos);
		
	}
	
	//e)btener el promedio de las calificaciones dadas por el usuario para una serie. 
	
	public void promedioCalificacionesTotal() {
		double sumador = 0;
		double contadorCapitulosVistos = 0;
		for (int temporada = 0; temporada < temporadas.size(); temporada++) {
			for (int episodio = 0; episodio < temporadas.get(temporada).size(); episodio++) {
				if (temporadas.get(temporada).get(episodio).getEpisodioVisto()) {
					sumador += temporadas.get(temporada).get(episodio).getCalificacion();
					contadorCapitulosVistos ++;
				}
			}
		}

		System.out.println("El promedio de calificaciones de todos los episodios vistos es: " + sumador/contadorCapitulosVistos);
	}
	
	//f)Determinar si el usuario ya vio todos los episodios de la serie.  
	
	public void serieCompletamenteVista() {
		
		boolean NoCompleto = false;
		for (int temporada = 0; temporada < temporadas.size(); temporada++) {
			for (int episodio = 0; episodio < temporadas.get(temporada).size(); episodio++) {
				if (!temporadas.get(temporada).get(episodio).getEpisodioVisto()) {
					NoCompleto = true;
					break;
				}
			}
			if(NoCompleto) break; ;
		}
		if(NoCompleto) {
			System.out.println("El usuario no se ha visto todos los episodios");
		}else {
			System.out.println("El usuario ya vio todos los episodios");;
		}
		
	}

}
