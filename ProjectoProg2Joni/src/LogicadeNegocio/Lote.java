package LogicadeNegocio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Lote {
    private int numeroLote;
    private Persona responsable;
    private String codigoUbicacion;
    private String fechaCreacion;
    private List<Producto> productos;

    // Constructor
    public Lote(int numeroLote, Persona responsable, String codigoUbicacion, String fechaCreacion) {
        this.numeroLote = numeroLote;
        this.responsable = responsable;
        this.codigoUbicacion = codigoUbicacion;
        this.fechaCreacion = fechaCreacion;
        this.productos = new ArrayList<>(); // Asegúrate de que la lista de productos se inicializa correctamente
    }
    
    public Lote() {
		
	}


	// Funcionalidades

    // a) Verificar y eliminar productos vencidos en un lote
    public int verificarEliminarProductosVencidos(int numeroLote) {
        int productosEliminados = 0;
        Iterator<Producto> iterator = productos.iterator();
        while (iterator.hasNext()) {
            Producto producto = iterator.next();
            if (producto.estaVencido()) {
                iterator.remove();
                productosEliminados++;
            }
        }
        return productosEliminados;
    }

    // j) Mostrar etiqueta del producto "Nombre del Producto, Nro de Lote y Fecha de Vencimiento"
    public void mostrarEtiquetaProducto(Stock stock) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Ingrese el número de lote: ");
    	int numeroLoteVerificar9 = scanner.nextInt();
    	Lote loteNumeroDos = stock.obtenerLotePorNumero(numeroLoteVerificar9);
    	
    	if(loteNumeroDos != null) {
    		for(Producto producto : loteNumeroDos.getProductos()) {
    			System.out.println("Nombre del Producto: " + producto.getDescripcio());
    			System.out.println("Nro de Lote: " + numeroLoteVerificar9);
    			System.out.println("Fecha de Vencimiento: " + producto.getFechaVencimiento());
    			System.out.println("-----------------------------------------");
    		}
    	}else {
    		System.out.println("No se encontró el lote número " + numeroLoteVerificar9 + " en el stock.");
    	}
    }

    //¿Esta bien reescrito esto de arribac?
    
    // c) Calcular margen de ganancia total por lote
    public double calcularMargenGananciaTotalLote() {
        double margenGananciaTotal = 0;
        for (Producto producto : productos) {
            margenGananciaTotal += producto.getCostoTratamiento() * producto.getMargenGanancia();
        }
        return margenGananciaTotal;
    }

    // d) Eliminar producto por código y devolver el producto eliminado
    public Producto eliminarProductoPorCodigo(int codigoProducto) {
        Iterator<Producto> iterator = productos.iterator();
        while (iterator.hasNext()) {
            Producto producto = iterator.next();
            if (producto.getCoddelProducto() == codigoProducto) {
                iterator.remove();
                return producto; // Devuelve el producto eliminado
            }
        }
        return null; // Si no se encuentra el producto con el código especificado
    }

    // e) Mostrar productos en el lote
    public void mostrarProductosEnLote() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el lote.");
        } else {
            System.out.println("Productos en el lote:");
            for (Producto producto : productos) {
                System.out.println("Código del producto: " + producto.getCoddelProducto());
                System.out.println("Descripción: " + producto.getDescripcio());
                // Puedes mostrar otros atributos del producto aquí
                System.out.println("-----------------------------------------");
            }
        }
    }

    // f) Buscar producto por código y devolverlo
    public Producto buscarProductoPorCodigo(int codigoProducto) {
        for (Producto producto : productos) {
            if (producto.getCoddelProducto() == codigoProducto) {
                return producto;
            }
        }
        return null; // Si no se encuentra el producto con el código especificado
    }

    // a) Grabar un nuevo producto en el lote
    public void agregarProducto(Producto producto) {
        if (this.productos == null) {
            this.productos = new ArrayList<>(); // Asegúrate de que la lista de productos se inicializa si es nula
        }
        this.productos.add(producto);
    }

//    public void agregarProducto(Producto stock) {
//    	
//    	
//    	// Agregar un producto al lote
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Ingrese el numero de lote: ");
//        int numeroLote = scanner.nextInt();
//   
//        Lote lote = stock.obtenerLotePorNumero(numeroLote);
//        if (lote == null) {
//            lote = new Lote(numeroLote, new Persona(null, null, 0), "Ubicacion001", "2023-11-09");
//            stock.agregarLote(lote); // Agregar el lote al stock
//        }
//        
//    	System.out.println("Agregando un nuevo producto al lote...");
//
//        // Solicitar información del producto al usuario
//        System.out.print("Ingrese el código del producto: ");
//        int codigoProducto = scanner.nextInt();
//        System.out.print("Ingrese la descripción del producto: ");
//        String descripcion = scanner.next();
//        System.out.print("Ingrese la fecha de vencimiento del producto (formato: yyyy-MM-dd): ");
//        String fechaVencimiento = scanner.next();
//        System.out.print("Ingrese el número de lote del producto: ");
//        String numeroLoteProducto = scanner.next();
//        System.out.print("Ingrese el costo de tratamiento del producto: ");
//        double costoTratamiento = scanner.nextDouble();
//
//        // Aquí, dependiendo del tipo de producto, puedes pedir los atributos específicos del tipo de producto
//
//        System.out.println("¿Es un producto refrigerado? (S/N): ");
//        String esRefrigerado = scanner.next();
//
//        if (esRefrigerado.equalsIgnoreCase("S")) {
//            System.out.print("Ingrese el código de supervisión alimentaria: ");
//            String codigoSupervision = scanner.next();
//            System.out.print("Ingrese la fecha de envasado (formato: yyyy-MM-dd): ");
//            String fechaEnvasado = scanner.next();
//            System.out.print("Ingrese la temperatura de mantenimiento recomendada: ");
//            double temperaturaRecomendada = scanner.nextDouble();
//            System.out.print("Ingrese la granja de origen: ");
//            String granjaOrigen = scanner.next();
//
//            // Crear una instancia de ProductoRefrigerado y agregarla al lote
//            ProductoRefrigerado productoRefrigerado  = new ProductoRefrigerado(codigoProducto, descripcion, fechaVencimiento, numeroLoteProducto, costoTratamiento,
//                    codigoSupervision, fechaEnvasado, temperaturaRecomendada, granjaOrigen);
//            lote.productos.add(productoRefrigerado);
//        } else {
//            System.out.println("¿Es un producto congelado por aire, por agua o por nitrógeno? (A/W/N): ");
//            String tipoCongelado = scanner.next();
//
//            if (tipoCongelado.equalsIgnoreCase("A")) {
//            	
//            	System.out.println("Fecha de envasado: ");
//        		String fechaEnvasado = scanner.next();
//        		System.out.println("Código del organismo de supervisión alimentaria: ");
//        		String codigoOrganismo = scanner.next();
//        		System.out.println("Granja de origen: ");
//        		String granjaOrigen = scanner.next();
//        		System.out.println("Temperatura de mantenimiento recomendada: ");
//        		double temperaturaRecomendada = scanner.nextDouble();
//        		System.out.println("Proporciona la siguiente información sobre la composición del aire con que fue congelado: ");
//        		System.out.println("Porcentaje de nitrógeno: ");
//        		double porcentajeNitrogeno = scanner.nextDouble();
//        		System.out.println("Porcentaje de oxígeno: ");
//        		double porcentajeOxigeno = scanner.nextDouble();
//        		System.out.println("Porcentaje de dióxido de carbono: ");
//        		double porcentajeDioxidoCarbono = scanner.nextDouble();
//        		System.out.println("Porcentaje de vapor de agua: ");
//        		double porcentajeVaporAgua = scanner.nextDouble();
//    	    	CongeladoPorAire congeladoPorAire = new CongeladoPorAire(codigoProducto, descripcion, fechaVencimiento, numeroLoteProducto, costoTratamiento, fechaEnvasado, codigoOrganismo, granjaOrigen, temperaturaRecomendada, porcentajeNitrogeno, porcentajeOxigeno, porcentajeDioxidoCarbono, porcentajeVaporAgua);
//    	    	lote.productos.add(congeladoPorAire);
//    	    	
//    	    	
//            } else if (tipoCongelado.equalsIgnoreCase("W")) {
//            	
//            	System.out.println("Fecha de envasado: ");
//        		String fechaEnvasado = scanner.next();
//        		System.out.println("Código del organismo de supervisión alimentaria: ");
//        		String codigoOrganismo = scanner.next();
//        		System.out.println("Granja de origen: ");
//        		String granjaOrigen = scanner.next();
//        		System.out.println("Temperatura de mantenimiento recomendada: ");
//        		double temperaturaRecomendada = scanner.nextDouble();
//        		System.out.println("Salinidad del agua: ");
//        		double  salinidad = scanner.nextDouble();
//    	    	CongeladoPorAgua congeladoPorAgua = new CongeladoPorAgua(codigoProducto, descripcion, fechaVencimiento, numeroLoteProducto, costoTratamiento, fechaEnvasado, codigoOrganismo, granjaOrigen, temperaturaRecomendada, salinidad);
//    	    	lote.productos.add(congeladoPorAgua);
//            
//            } else if (tipoCongelado.equalsIgnoreCase("N")) {
//            	
//            	System.out.println("Fecha de envasado: ");
//        		String fechaEnvasado = scanner.next();
//        		System.out.println("Código del organismo de supervisión alimentaria: ");
//        		String codigoOrganismo = scanner.next();
//        		System.out.println("Granja de origen: ");
//        		String granjaOrigen = scanner.next();
//        		System.out.println("Temperatura de mantenimiento recomendada: ");
//        		double temperaturaRecomendada = scanner.nextDouble();
//        		System.out.println("método de congelación: ");
//        		String metodoCongelacion = scanner.next();
//        		System.out.println("Tiempo de exposición al nitrógeno: ");
//        		double tiempoExposicion = scanner.nextDouble();
//    	    	CongeladoPorNitrogeno congeladoPorNitrogeno = new CongeladoPorNitrogeno(codigoProducto, descripcion, fechaVencimiento, numeroLoteProducto, costoTratamiento, fechaEnvasado, codigoOrganismo, granjaOrigen, temperaturaRecomendada, metodoCongelacion, tiempoExposicion);
//    	    	lote.productos.add(congeladoPorNitrogeno);
//    	    	
//            } else {
//                System.out.println("Opción no válida. Volviendo al menú principal.");
//            }
//            System.out.println("Producto agregado al lote.");
//        }
//   }

    // g) Calcular costo total de un lote
    public double calcularCostoTotalLote() {
        double costoTotal = 0;
        for (Producto producto : productos) {
            costoTotal += producto.getCostoTratamiento();
        }
        return costoTotal;
    }
    
    //G)
    public int obtenerCantidadProductosEnLote() {
        return productos.size(); // productos es una lista de productos en el lote
    }
   
    
    //h) Cantidad de productos de un determinado tipo en cada lote.
    public void obtenerCantidadProductosPorTipoEnLote(Stock stock) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Ingrese el numero de lote");
    	int numeroLote = scanner.nextInt();
    	
    	int contadorRefrigerados = 0;
    	int contadorCongelados = 0;
    	int contadorCongeladosPorAire = 0;
    	int contadorCongeladosPorAgua = 0;
    	int contadorCongeladosPorNitrogeno = 0;
    	
    	Lote loteNumeroDos = stock.obtenerLotePorNumero(numeroLote);
    	if (loteNumeroDos != null) {
    		List<Producto> productosLote = loteNumeroDos.getProductos(); 
    		//Iterar sobre los productos del lote
    		for (Producto producto : productosLote) {
    			if (producto instanceof ProductoRefrigerado) { //¿Esta bien escrito "ProductoRefrigerado"?
    				contadorRefrigerados++;
    			}
    			else if (producto instanceof CongeladoPorAire) {
    				contadorCongeladosPorAire++;
    			}
    			else if (producto instanceof CongeladoPorAgua) {
    				contadorCongeladosPorAgua++;
    			}
    			else if (producto instanceof CongeladoPorNitrogeno) {
    				contadorCongeladosPorNitrogeno++;
    		}
    	}
    	//Mostrar resultados por consola
    	System.out.println("Cantidad de productos refrigerados en el lote: " + contadorRefrigerados);
    	System.out.println("Cantidad de productos congelados en el lote: " + contadorCongelados);
    	System.out.println("Cantidad de productos congelados por aire en el lote: " + contadorCongeladosPorAire);
    	System.out.println("Cantidad de productos congelados por agua en el lote: " + contadorCongeladosPorAgua);
    	System.out.println("Cantidad de productos congelados por nitrógeno en el lote: " + contadorCongeladosPorNitrogeno);
    }
    	else {
    		System.out.println("No se encontró el lote número 2 en el stock.");
    	}
   }    	


    // ... otras funcionalidades ...

    // Getters y Setters
    public List<Producto> getProductos() {
        return productos;
    }

    public int getNumeroLote() {
        return numeroLote;
    }
}


