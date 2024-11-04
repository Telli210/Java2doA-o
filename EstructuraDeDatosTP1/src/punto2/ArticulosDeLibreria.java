package punto2;

import java.util.Scanner;

public class ArticulosDeLibreria {
	
	//Atributos
	private int codigo;
	private String nombre;
	private double precio;
	private int cantidad;
	
	//Metodos
	public ArticulosDeLibreria() {
		this.precio = 0;
		this.cantidad = 0;
	}	
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	//Ingreso de datos
	
	public void ingresoDatos(Scanner entrada) {
		System.out.println("A continuacion ingrese los datos del producto");
		System.out.println("Ingrese el codigo");
		codigo = entrada.nextInt();
		entrada.nextLine();//Se usa para limpiar el buffer despues de ingresar un nextInt o un nextDouble
		System.out.println("Ingrese el nombre");
		nombre = entrada.nextLine();
		System.out.println("Ingrese el precio");
		precio = entrada.nextDouble();
		System.out.println("Ingrese la cantidad");
		cantidad = entrada.nextInt();
	}

	@Override
	public String toString() {
		return "ArticulosDeLibreria [codigo:" + codigo + ", nombre:" + nombre + ", precio:" + precio + ", cantidad:"
				+ cantidad + "]";
	}

	public void depositarEnStock(int cantidadADepositar) {
		cantidad += cantidadADepositar;
	}
	
	public void retirarStock(int cantidadARetirar, Scanner entrada) {
		while(cantidadARetirar > cantidad || cantidadARetirar < 0) {//	Asegurarse que no se ingrese una cantidad negativa y al mismo tiempo la cantidad a retirar no sobrepase el stock
			if(cantidadARetirar > cantidad) {
				System.out.println("La cantidad a retirar supera el stock");
				System.out.println("Por favor ingrese una cantidad valida");
			}else if(cantidadARetirar < 0){
				System.out.println("La cantidad a retirar es negativa");
				System.out.println("Por favor ingrese una cantidad valida");
			}
			cantidadARetirar = entrada.nextInt();
			}
		cantidad -= cantidadARetirar;
	}
	
}
