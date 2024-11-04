package punto3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Evento {
	private String nombre;
	private String descripcion;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	
	//a)
	public Evento() {
		this.nombre = "Sin nombre";
		this.descripcion = "Sin descripcion";
		this.fechaInicio = LocalDate.now();
		this.fechaFin = LocalDate.now().plusDays(7);//plusDays es un metodo que pertenece a la clase LocalDate que suma dias al dato tipo LocalDate
	}

	//b)
	public Evento(String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin) {
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	//Metodos
	
	//c)
	public void validarFechas() {
		if(fechaInicio.isBefore(fechaFin)) {
			fechaInicio = LocalDate.now();
			fechaFin = LocalDate.now().plusDays(7);
		}
	}
	//d)
	@Override
	public String toString() {
		return "Evento [Nombre:" + nombre + ", Descripcion:" + descripcion + ", Fecha de Inicio:" + fechaInicio
				+ ", Fecha de fin:" + fechaFin + "]";
	}
	
	//e)
	public void duracionEvento() {
		System.out.println("La duracion del evento es de : "+ChronoUnit.DAYS.between(fechaInicio, fechaFin)+" dias");
	}
	
	//f)
	public void verificarEventoEnCurso() {
		if(eventoEnCurso()) {
			System.out.println("El evento esta en curso en la fecha actual");
		}
	}
	
	public boolean eventoEnCurso() {
		return (LocalDate.now().isAfter(fechaInicio) || LocalDate.now().equals(fechaInicio)) && (LocalDate.now().isBefore(fechaFin) || LocalDate.now().equals(fechaFin));
	}
	
	//g)
	public void diasRestantesInicioEvento() {
		if(LocalDate.now().isBefore(fechaInicio)) {
			System.out.println("La cantidad de dias restantes hasta el evento es: "+ChronoUnit.DAYS.between(LocalDate.now(), fechaInicio));
		}else{
			System.out.println("El evento esta en curso o ya finalizo");
		}
	}
	
	//h)
	public void diasTranscurridosInicioEvento() {
		if((LocalDate.now().isAfter(fechaInicio) || LocalDate.now().equals(fechaInicio)) && (LocalDate.now().isBefore(fechaFin) || LocalDate.now().equals(fechaFin))) {
			System.out.println("La cantidad de dias transcurridos desde el inicio del evento es: "+ ChronoUnit.DAYS.between(fechaInicio, LocalDate.now()));
		}else {
			System.out.println("El evento aun no ha empezado o ya a finalizado");
		}
	}
}
