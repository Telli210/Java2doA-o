package punto4;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;//Es la clase que usamos para ver el tiempo que transcurre entre dos fechas


public class Alquiler {
    private String nombreCliente;
    private String dniCliente;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int posicionAmarre;
    private Barco barco;
    
    private final float valorFijo = 20000;//Constante valor fijo

    public Alquiler(String nombreCliente, String dniCliente, LocalDate fechaInicio, LocalDate fechaFin, int posicionAmarre, Barco barco) {
    	
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.posicionAmarre = posicionAmarre;
        this.barco = barco;
        
    }
    
    
    //Getters y Setters
    public String getNombreCliente() {
    	return nombreCliente;
    }
    	
    public void setNombreCliente(String nombreCliente) {
        	this.nombreCliente = nombreCliente;
    }

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getPosicionAmarre() {
		return posicionAmarre;
	}

	public void setPosicionAmarre(int posicionAmarre) {
		this.posicionAmarre = posicionAmarre;
	}

	public Barco getBarco() {
		return barco;
	}

	public void setBarco(Barco barco) {
		this.barco = barco;
	}

	//Aca es donde aplicamos el modulo between de la clase ChronoUnit pasa saber los dias que transcurren entre ambas fechas
    //Se utiliza el tipo de dato long, ya que para las fechas se manejan cantidades de datos grandes y es maas seguro usar un long antes que un int, por eso da error al usar el int.
	public float calcularAlquiler() {
        long diasOcupacionAmarre = ChronoUnit.DAYS.between(fechaInicio, fechaFin) + 1;//Se suma uno ya que el modulo between excluye el dia final.
        return diasOcupacionAmarre * barco.calcularModulo() * valorFijo;
    }
    
}