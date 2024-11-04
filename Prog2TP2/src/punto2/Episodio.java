package punto2;

import java.util.Scanner;

public class Episodio {
	
	private String titulo;
	private String descripcion;
	private boolean episodioVisto;
	private double calificacion;
	
	
	
	
	public Episodio(String titulo, String descripcion, boolean episodioVisto, double calificacion) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.episodioVisto = episodioVisto;
		this.calificacion = calificacion;
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




	public boolean getEpisodioVisto() {
		return episodioVisto;
	}




	public void setEpisodioVisto(boolean episodioVisto) {
		this.episodioVisto = episodioVisto;
	}




	public double getCalificacion() {
		return calificacion;
	}




	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}




		//a)
		public void ingresarCalificacionEpisodio(Scanner entrada) {
			double aux;
			
			System.out.println("Ingrese la calificacion del episodio");
			aux = entrada.nextDouble();
			
			if(aux >= 1 && aux <= 5) {
				calificacion = aux;
			}else {
				System.out.println("La calificacion ingresada no es valida(va desde 1 a 5)");
			}
		}
}
