package Presentacion;
import LogicadeNegocio.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        Lote lote = new Lote(); 
        Stock stock = new Stock(); // Inicializar el stock
        // Crear un nuevo lote y agregarlo al stock
     // Crear algunos productos y agregarlos al lote
        ProductoRefrigerado productoRefrigerado0 = new ProductoRefrigerado(1, "Pollo Fresco", "2023-12-31", 001, 10.0,
                "Codigo123", "2023-11-08", 4.0, "Granja A");
        ProductoRefrigerado productoRefrigerado1 = new ProductoRefrigerado(1, "Pollo Fresco", "2023-12-31", 001, 10.0,
                "Codigo123", "2023-11-08", 4.0, "Granja A");
 
        
        ProductoCongelado productoCongelado = new ProductoCongelado(2, "Hamburguesas", "2023-12-31", 002, 15.0,
        		"2023-12-31","Codigo456", "Granja B", -5.0);
        ProductoCongelado productoCongelado1 = new ProductoCongelado(2, "Hamburguesas", "2023-12-31", 002, 15.0,
        		"2023-12-31","Codigo456", "Granja B", -5.0);
        CongeladoPorAire productoCongeladoPorAire = new CongeladoPorAire(3, "comida", "2023-12-31", 003, 20.0,
        		"2023-12-31","Codigo789", "Granja C", -10.0, 30.0, 20.0, 5.0, 10.0);

        // Agregar los productos al lote
        lote.agregarProducto(productoRefrigerado0);
        lote.agregarProducto(productoRefrigerado1);
        lote.agregarProducto(productoCongelado);
        lote.agregarProducto(productoCongelado1);
        lote.agregarProducto(productoCongeladoPorAire);


        try {
        	do {
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
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                // Manejar las diferentes opciones
                switch (opcion) {
                case 1:

                    // Agregar un producto al lote
                    System.out.println("Agregando un nuevo producto al lote...");

                    // Solicitar información del producto al usuario
                    System.out.print("Ingrese el código del producto: ");
                    int codigoProducto = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Ingrese la descripción del producto: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Ingrese la fecha de vencimiento del producto (formato: yyyy-MM-dd): ");
                    String fechaVencimiento = scanner.nextLine();
                    System.out.print("Ingrese el número de lote del producto: ");
                    int numeroLoteProducto = scanner.nextInt();
                    System.out.print("Ingrese el costo de tratamiento del producto: ");
                    double costoTratamiento = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar el buffer

                    // Aquí, dependiendo del tipo de producto, puedes pedir los atributos específicos del tipo de producto

                    System.out.println("¿Es un producto refrigerado? (S/N): ");
                    String esRefrigerado = scanner.nextLine();

                    if (esRefrigerado.equalsIgnoreCase("S")) {
                        System.out.print("Ingrese el código de supervisión alimentaria: ");
                        String codigoSupervision = scanner.nextLine();
                        System.out.print("Ingrese la fecha de envasado (formato: yyyy-MM-dd): ");
                        String fechaEnvasado = scanner.nextLine();
                        System.out.print("Ingrese la temperatura de mantenimiento recomendada: ");
                        double temperaturaRecomendada = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar el buffer
                        System.out.print("Ingrese la granja de origen: ");
                        String granjaOrigen = scanner.nextLine();
                        
                      /*  
                        public ProductoRefrigerado(int CoddelProducto, String Descripcion, String fechaVencimiento, int numeroLote,
                    			double costoTratamiento, String codigoSupervision, String fechaEnvasado, double temperaturaRecomendada,
                    			String granjaOrigen) {
*/
                        // Crear una instancia de ProductoRefrigerado y agregarla al lote
                        ProductoRefrigerado nuevoProducto = new ProductoRefrigerado(codigoProducto, descripcion, fechaVencimiento, numeroLoteProducto, costoTratamiento,
                                codigoSupervision, fechaEnvasado, temperaturaRecomendada, granjaOrigen);
                        lote.agregarProducto(nuevoProducto);
                    } else {
                        System.out.println("¿Es un producto congelado por aire, por agua o por nitrógeno? (A/W/N): ");
                        String tipoCongelado = scanner.nextLine();

                        if (tipoCongelado.equalsIgnoreCase("A")) {
                            // Agregar la lógica para pedir los atributos específicos del producto congelado por aire
                        } else if (tipoCongelado.equalsIgnoreCase("W")) {
                            // Agregar la lógica para pedir los atributos específicos del producto congelado por agua
                        } else if (tipoCongelado.equalsIgnoreCase("N")) {
                            // Agregar la lógica para pedir los atributos específicos del producto congelado por nitrógeno
                        } else {
                            System.out.println("Opción no válida. Volviendo al menú principal.");
                        }
                        System.out.println("Producto agregado al lote.");
                    }
                    break;
             
                case 2:
                	// Modificar los datos de un producto
                    System.out.println("Modificando los datos de un producto...");
                    System.out.print("Ingrese el código del producto que desea modificar: ");
                    int codigoProductoModificar = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer

                    // Buscar el producto en el lote
                    Producto productoModificar = lote.buscarProductoPorCodigo(codigoProductoModificar);

                    if (productoModificar != null) {
                        // Aquí puedes mostrar los detalles del producto y luego permitir al usuario modificar los atributos deseados
                    	 System.out.println("Detalles del producto a modificar: "+productoModificar);
                         productoModificar.modificar(productoModificar);
                       
                        // Mostrar los detalles del producto (implementar lógica según la estructura de tu clase Producto)

                        // Implementa la lógica para permitir al usuario modificar los atributos del producto
                    } else {
                        System.out.println("No se encontró un producto con el código especificado. Volviendo al menú principal.");
                    }
                    // Implementa la lógica para buscar y modificar un producto en el lote
                    break;
                    
                    
                case 3:
                	// Eliminar un producto del lote
                    System.out.println("Eliminando un producto del lote...");
                    
                    // Mostrar la lista de productos
                    lote.mostrarProductosEnLote();

                    System.out.print("Ingrese el código del producto que desea eliminar: ");
                    int codigoProductoEliminar = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer

                    // Eliminar el producto del lote
                    Producto productoEliminado = lote.eliminarProductoPorCodigo(codigoProductoEliminar);

                    if (productoEliminado != null) {
                        System.out.println("Producto eliminado con éxito del lote:");
                        System.out.println("Código del producto: " + productoEliminado.getCoddelProducto());
                        System.out.println("Descripción: " + productoEliminado.getDescripcio());
                        // Mostrar otros atributos del producto eliminado según la estructura de tu clase Producto
                    } else {
                        System.out.println("No se encontró un producto con el código especificado en el lote.");
                    }
                    break;
                    
                    
                    
                case 4:
                	 // Calcular el costo total en stock
                    System.out.println("Calculando el costo total en stock...");
                    double costoTotalStock = stock.calcularCostoTotalEnStock();
                    System.out.println("Costo total en stock: " + costoTotalStock);
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
                    break;
                    
                    
                case 7:
                	 // Calcular la cantidad de productos en el lote
                    System.out.println("Calculando la cantidad de productos en el lote...");
                    int cantidadProductosEnLote = lote.obtenerCantidadProductosEnLote();
                    System.out.println("Cantidad de productos en el lote: " + cantidadProductosEnLote);
                    break;
                	
                case 8:
                	lote.obtenerCantidadProductosPorTipoEnLote(stock);
                    break;
                    
                    
                    
                    
                case 9:
                	 // Verificar y eliminar productos vencidos en un lote
                    System.out.println("Verificando y eliminando productos vencidos en un lote...");
                    System.out.print("Ingrese el número de lote: ");
                    int numeroLoteVerificar = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer

                    // Verificar y eliminar productos vencidos en el lote
                    int productosEliminados = lote.verificarEliminarProductosVencidos(numeroLoteVerificar);
                    if (productosEliminados > 0) {
                        System.out.println("Se eliminaron " + productosEliminados + " productos vencidos del lote " + numeroLoteVerificar + ".");
                    } else {
                        System.out.println("No se encontró un lote con el número especificado en el stock, o no se encontraron productos vencidos en el lote.");
                    }
                    break;
                    
                    
                    
                    
                case 10:
                    // Mostrar la etiqueta del producto
                    lote.mostrarEtiquetaProducto(stock);
                    break;
                    
                    
                    
                    
                case 11:
                    // Salir del programa
                    System.out.println("Saliendo del programa...");
                    opcion=11;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
            }while(opcion!=11);
        	
        }catch(Exception e) {
        	System.out.println("Error en "+e.getCause());
        	
        }



        // Loop principal del programa
        
    }
}

