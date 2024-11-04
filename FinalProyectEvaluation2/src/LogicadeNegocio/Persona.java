package LogicadeNegocio;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre; // Nombre de la persona
    private String DNI; // Documento Nacional de Identidad de la persona
    private int numeroLegajo; // Número de legajo de la persona

    // Constructor
    public Persona(String nombre, String DNI, int numeroLegajo) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.numeroLegajo = numeroLegajo;
    }

    // Métodos de acceso
    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public int getNumeroLegajo() {
        return numeroLegajo;
    }

    // Métodos de modificación
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setNumeroLegajo(int numeroLegajo) {
        this.numeroLegajo = numeroLegajo;
    }
}
