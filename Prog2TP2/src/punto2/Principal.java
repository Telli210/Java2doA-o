package punto2;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
        Serie serie = new Serie();
        
        System.out.println("Ingrese el título de la serie:");
        serie.setTitulo(entrada.nextLine());

        System.out.println("Ingrese la descripción de la serie:");
        serie.setDescripcion(entrada.nextLine());

        System.out.println("Ingrese el creador de la serie:");
        serie.setCreador(entrada.nextLine());

        System.out.println("Ingrese el género de la serie:");
        serie.setGenero(entrada.nextLine());

        
        ArrayList<ArrayList<Episodio>> temporadas = new ArrayList<>();
        //Ingresa la cantidad de temporadas
        System.out.println("¿Cuántas temporadas tiene la serie?");
        int numTemporadas = entrada.nextInt();
        entrada.nextLine();

        for (int i = 0; i < numTemporadas; i++) {
            ArrayList<Episodio> temporada = new ArrayList<>();
            System.out.println("Temporada " + (i + 1));

            // Ingresa la cantidad de episodios por temporada
            System.out.println("¿Cuántos episodios tiene la temporada " + (i + 1) + "?");
            int numEpisodios = entrada.nextInt();
            entrada.nextLine();

            for (int j = 0; j < numEpisodios; j++) {
                System.out.println("Ingrese el título del episodio " + (j + 1) + ":");
                String titulo = entrada.nextLine();

                System.out.println("Ingrese la descripción del episodio " + (j + 1) + ":");
                String descripcion = entrada.nextLine();
                
                System.out.println("Vio el episodio" + (j + 1) + "?:");
                boolean episodioVisto = entrada.nextLine().equals("Si")?true:false;
                
                System.out.println("Ingrese la calificacion del episodio" + (j + 1) + ":");
                double calificacion = entrada.nextDouble();
                entrada.nextLine();
                
                Episodio episodio = new Episodio(titulo, descripcion, episodioVisto, calificacion);
                temporada.add(episodio);
            }

            // Agrega la temporada a la lista de temporadas
            temporadas.add(temporada);
        }

        // Asigna la lista de temporadas a la serie
        serie.setTemporadas(temporadas);
        
        //A continuacion se prueban los metodos de las consignas
        
        //a)
        System.out.println("Para calificar un episodio ingrese la temporada correspondiente ("+numTemporadas+" Temporadas)");
        int tempElegida = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Ahora ingrese el nro del cap que calificara ("+temporadas.get(tempElegida-1).size());
        int episodioElegido = entrada.nextInt();
        temporadas.get(tempElegida - 1).get(episodioElegido - 1).ingresarCalificacionEpisodio(entrada);
        
        //b)
        serie.episodiosVistosTemporada(entrada);
        
        //c)
        
        serie.episodiosVistosTotal();
        
        //d)
        
        serie.promedioCalificacionesTemporada(entrada);
        
        //e)
        
        serie.promedioCalificacionesTotal();
        
        //f)
        
        serie.serieCompletamenteVista();
        
        entrada.close();
	}

}
