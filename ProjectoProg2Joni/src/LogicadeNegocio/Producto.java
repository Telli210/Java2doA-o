package LogicadeNegocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Producto {
    // Atributos
    private int CoddelProducto; // Código del producto
    private String Descripcio; // Descripción del producto
    private String fechaVencimiento; // Fecha de vencimiento del producto
    private int numeroLote; // Número de lote del producto
    private double costoTratamiento; // Costo de tratamiento del producto

    // Constructor
    public Producto(int CoddelProducto, String Descripcion, String fechaVencimiento, int numeroLote, double costoTratamiento) {
        this.CoddelProducto = CoddelProducto;
        this.Descripcio = Descripcion;
        this.fechaVencimiento = fechaVencimiento;
        this.numeroLote = numeroLote;
        this.costoTratamiento = costoTratamiento;
    }

    // Getters y Setters

    // Métodos de acceso o recuperación de valores
    public int getCoddelProducto() {
        return CoddelProducto;
    }

    public String getDescripcio() {
        return Descripcio;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public int getNumeroLote() {
        return numeroLote;
    }

    public double getCostoTratamiento() {
        return costoTratamiento;
    }

    // Métodos de modificación
    public void setCoddelProducto(int coddelProducto) {
        CoddelProducto = coddelProducto;
    }

    public void setDescripcio(String descripcio) {
        Descripcio = descripcio;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setNumeroLote(int numeroLote) {
        this.numeroLote = numeroLote;
    }

    public void setCostoTratamiento(double costoTratamiento) {
        this.costoTratamiento = costoTratamiento;
    }

    // Método para obtener el margen de ganancia (requiere implementación)
    public double getMargenGanancia() {
        return 0;
    }

    // Método para verificar si el producto está vencido
    public boolean estaVencido() {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaVencimientoProducto = LocalDate.parse(fechaVencimiento, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return fechaVencimientoProducto.isBefore(fechaActual);
    }
    
    public void modificar(Producto productoModificar) {
		String continuar = "si";
		Scanner scanner = new Scanner(System.in);
		do {
			
			System.out.println("que desea modificar");
			System.out.println("1.descripcion");
			System.out.println("2.codigo del producto");
			System.out.println("3.costo de tratamiento");
			System.out.println("4.fecha de vencimiento");
			System.out.println("5.fecha de envasado");
			System.out.println("6.salir");
			int opcion = scanner.nextInt();
			
			switch (opcion) {
			case 1:
				System.out.println("escriba la descripcion nueva");
				scanner.nextLine(); 
			
				String nueva = scanner.nextLine();
				productoModificar.setDescripcio(nueva);
				
				break;
			case 2:
				System.out.println("ecriba el codigo del producto nuevo :");
				int nuevo = scanner.nextInt();
				productoModificar.setCoddelProducto(nuevo);
				break;
			case 3:
				System.out.println("ecriba el nuevo costo de tratamiento :");
				double nuevo1 = scanner.nextDouble();
				productoModificar.setCostoTratamiento(nuevo1);
				break;
			case 4:
				System.out.println("escriba la nueva fecha de vencimiento :");
				String nuevo2 = scanner.nextLine();
				productoModificar.setFechaVencimiento(nuevo2);
				break;
			case 5:
				continuar = "no";
				break;

			default:
				System.out.println("opcion invalida");
				break;
			}
			
		} while (continuar.equalsIgnoreCase("si"));
		
		System.out.println("el producto se ha modificado");
		System.out.println("el producto nuevo es: "+productoModificar);
        
	}
    
}


