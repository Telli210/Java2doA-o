package Presentacion;
import LogicadeNegocio.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

import Datos.GuardarDatos;


public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GuardarDatos datos= new GuardarDatos();
        Stock stock = new Stock();
        Lote lote = new Lote();
        
        try {
			stock = datos.recuperar();
		} catch (ClassNotFoundException e) {
			e.getMessage();
			e.printStackTrace();
		} catch (IOException e) {
			e.getMessage();
			e.printStackTrace();
		}
        
        String menu = "si";
        while(menu.equalsIgnoreCase("si")) {
        	
            // Mostrar opciones del menú
            System.out.println("1. Agregar un producto al lote");
            System.out.println("2. Modificar los datos de un producto");
            System.out.println("3. Eliminar un producto del lote");
            System.out.println("4. Calcular el costo total en stock");
            System.out.println("5. Calcular el costo total de un lote");
            System.out.println("6. Calcular el margen de ganancia total por lote");
            System.out.println("7. Calcular la cantidad de productos en el lote");
            System.out.println("8. Calcular la cantidad de productos de un tipo en el lote");
            System.out.println("9. Verificar y eliminar productos vencidos en un lote");
            System.out.println("10. Mostrar etiqueta de un producto");
            System.out.println("11. Salir");

            System.out.print("Ingrese el número de la opción que desea realizar: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            
            // Manejar las diferentes opciones
            switch (opcion) {
            case 1:
            	lote.agregarProducto(stock);
            	try {
					datos.grabar(stock);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
                break;
            case 2:
            	// Modificar los datos de un producto
            	System.out.println("Modificando los datos de un producto...");
                System.out.println("ingrese numero de lote:");
                int numDeLote= scanner.nextInt();
                System.out.print("Ingrese el código del producto que desea modificar: ");
                int codigoProductoModificar = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                // Buscar el producto en el lote
                Producto productoModificar = lote.buscarProductoPorCodigo(codigoProductoModificar, numDeLote, stock);

                if (productoModificar != null) {
                    // Aquí puedes mostrar los detalles del producto y luego permitir al usuario modificar los atributos deseados
                    System.out.println("Detalles del producto a modificar: "+productoModificar);
                    productoModificar.modificar(productoModificar);
                    // Mostrar los detalles del producto (implementar lógica según la estructura de tu clase Producto)

                    // Implementa la lógica para permitir al usuario modificar los atributos del producto
                } else {
                    System.out.println("No se encontró un producto con el código especificado o no se encontro el lote. Volviendo al menú principal.");
                }
                // Implementa la lógica para buscar y modificar un producto en el lote
                try {
        			datos.grabar(stock);
        		} 
        		 catch (IOException e) {
        			e.getMessage();
        			e.printStackTrace();
        		}
                break;
            	
            case 3:
            	// Eliminar un producto del lote
                System.out.println("Eliminando un producto del lote...");
                
                // Mostrar la lista de productos
                System.out.println("ingrese numero de lote:");
                int numLote = scanner.nextInt();
                lote.mostrarProductosEnLote(numLote,stock);

                System.out.print("Ingrese el código del producto que desea eliminar: ");
                int codigoProductoEliminar = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                // Eliminar el producto del lote
                Producto productoEliminado = lote.eliminarProductoPorCodigo(codigoProductoEliminar, numLote, stock);

                if (productoEliminado != null) {
                    System.out.println("Producto eliminado con éxito del lote:");
                    System.out.println("Código del producto: " + productoEliminado.getCodigodelProducto());
                    System.out.println("Descripción: " + productoEliminado.getDescripcion());
                    // Mostrar otros atributos del producto eliminado según la estructura de tu clase Producto
                } else {
                    System.out.println("No se encontró un producto con el código especificado en el lote.");
                }
                try {
        			datos.grabar(stock);
        		} 
        		 catch (IOException e) {
        			e.getMessage();
        			e.printStackTrace();
        		}
                break;
   
            case 4:
            	 //  costo total en stock
                System.out.println("Calculando el costo total en stock...");
                double costoTotalStock = stock.calcularCostoTotalEnStock();
                System.out.println("Costo total en stock: " + costoTotalStock);
                
                try {
        			datos.grabar(stock);
        		} 
        		 catch (IOException e) {
        			e.getMessage();
        			e.printStackTrace();
        		}
                break;
  
            case 5:
            	 // Calcular el costo total de un lote determinado
                System.out.println("Calculando el costo total de un lote determinado...");
                System.out.print("Ingrese el número de lote: ");
                int numeroLoteDeterminado = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                // Calcular el costo total del lote
                double costoTotalLote = stock.calcularCostoTotalDeLote(numeroLoteDeterminado);
                if (costoTotalLote != -1) {
                    System.out.println("Costo total del lote " + numeroLoteDeterminado + ": " + costoTotalLote);
                } else {
                    System.out.println("No se encontró un lote con el número especificado en el stock.");
                }
                try {
        			datos.grabar(stock);
        		} 
        		 catch (IOException e) {
        			e.getMessage();
        			e.printStackTrace();
        		}
                break;
 
            case 6:
            	// Calcular el margen de ganancia total por cada lote
                System.out.println("Calculando el margen de ganancia total por cada lote...");
                System.out.print("Ingrese el número de lote: ");
                int numeroLoteMargen = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                // Calcular el margen de ganancia total del lote
                double margenGananciaTotal = stock.calcularMargenGananciaTotalPorLote(numeroLoteMargen);
                if (margenGananciaTotal != -1) {
                    System.out.println("Margen de ganancia total del lote " + numeroLoteMargen + ": " + margenGananciaTotal);
                } else {
                    System.out.println("No se encontró un lote con el número especificado en el stock.");
                }
                try {
        			datos.grabar(stock);
        		} 
        		 catch (IOException e) {
        			e.getMessage();
        			e.printStackTrace();
        		}
                break;
    
                
            case 7:
           	 // Calcular la cantidad de productos en cada lote
               System.out.println("Calculando la cantidad de productos en cada lote...");
               int cantidadProductosEnLote = lote.obtenerCantidadProductosEnLote(stock);
               System.out.println("Cantidad de productos en el lote: " + cantidadProductosEnLote);
               try {
       			datos.grabar(stock);
       		} 
       		 catch (IOException e) {
       			e.getMessage();
       			e.printStackTrace();
       		}
               break;
               
            case 8:
            	 // Calcular la cantidad de productos por tipo en el lote
            	stock.mostrarInformacionLotes();
                lote.obtenerCantidadProductosPorTipoEnLote(stock);
                try {
        			datos.grabar(stock);
        		} 
        		 catch (IOException e) {
        			e.getMessage();
        			e.printStackTrace();
        		}
                break;
                
            case 9:
            	 // Verificar y eliminar productos vencidos en un lote
            	 System.out.println("Verificando y eliminando productos vencidos en un lote...");
                 System.out.print("Ingrese el número de lote: ");
                 int numeroLoteVerificar = scanner.nextInt();
                 scanner.nextLine(); // Limpiar el buffer

                 // Verificar y eliminar productos vencidos en el lote
                 int productosEliminados = lote.verificarEliminarProductosVencidos(numeroLoteVerificar,stock);
                 if (productosEliminados > 0) {
                     System.out.println("Se eliminaron " + productosEliminados + " productos vencidos del lote " + numeroLoteVerificar + ".");
                 } else {
                     System.out.println("No se encontró un lote con el número especificado en el stock, o no se encontraron productos vencidos en el lote.");
                 }
                 try {
         			datos.grabar(stock);
         		} 
         		 catch (IOException e) {
         			e.getMessage();
         			e.printStackTrace();
         		}
                 break;
            	
            	
                
            case 10:
                // Mostrar la etiqueta del producto
            	stock.mostrarInformacionLotes();
                lote.mostrarEtiquetaProducto(stock);
                try {
        			datos.grabar(stock);
        		} 
        		 catch (IOException e) {
        			e.getMessage();
        			e.printStackTrace();
        		}
                break;
                       
            case 11:
                // Salir del programa
            	menu = "no";
                System.out.println("Saliendo del programa...");
                scanner.close();
                
                break;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }
        }
    }
}