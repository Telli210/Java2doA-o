package LogicadeNegocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



public class Lote implements Serializable{
    private int numeroLote;
    private String responsable;
    private String codigoUbicacion;
    private String fechaCreacion;
    private ArrayList<Producto> productos;

    public Lote() {
    	
	}

	// Constructor
    public Lote(int numeroLote, String responsable, String codigoUbicacion, String fechaCreacion) {
        this.numeroLote = numeroLote;
        this.responsable = responsable;
        this.codigoUbicacion = codigoUbicacion;
        this.fechaCreacion = fechaCreacion;
        this.productos = new ArrayList<>(); // Para inicializar la lista de productos
    }

    // Funcionalidades

    public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getCodigoUbicacion() {
		return codigoUbicacion;
	}

	public void setCodigoUbicacion(String codigoUbicacion) {
		this.codigoUbicacion = codigoUbicacion;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public void setNumeroLote(int numeroLote) {
		this.numeroLote = numeroLote;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	// a) Verificar y eliminar productos vencidos en un lote
	 public int verificarEliminarProductosVencidos(int numeroLote,Stock stock) {
	        int productosEliminados = 0;
	        
	        for (Lote lote : stock.getLotes()) {
				if (numeroLote==lote.getNumeroLote()) {
					Iterator<Producto> iterator = lote.getProductos().iterator();
					while (iterator.hasNext()) {
						Producto producto = iterator.next();
						if(producto.estaVencido()) {
							iterator.remove();
							productosEliminados++;
						}
					}
				}
			}
	        return productosEliminados;
	        
	        
	        
	    }
    // b) Mostrar etiqueta del producto "Nombre del Producto, Nro de Lote y Fecha de Vencimiento"
    public void mostrarEtiquetaProducto(Stock stock) {
        Scanner scanner = new Scanner(System.in);
        
    	System.out.print("Ingrese el número de lote: ");
        int numeroLoteVerificar9 = scanner.nextInt();
        Lote loteNumeroDos = stock.obtenerLotePorNumero(numeroLoteVerificar9);
        
        if (loteNumeroDos != null) {
            for (Producto producto : loteNumeroDos.getProductos()) { 
                System.out.println("Nombre del Producto: " + producto.getDescripcion());
                System.out.println("Nro de Lote: " + numeroLoteVerificar9); 
                System.out.println("Fecha de Vencimiento: " + producto.getFechaVencimiento());
                System.out.println("-----------------------------------------");
            }
        } else {
            System.out.println("No se encontró el lote número " + numeroLoteVerificar9 + " en el stock.");
        }
    }


    // c) Calcular margen de ganancia total por lote
    public double calcularMargenGananciaTotalLote() {
        double margenGananciaTotal = 0;
        for (Producto producto : productos) {
            margenGananciaTotal += producto.getCostoTratamiento() * producto.getMargenGanancia();
        }
        return margenGananciaTotal;
    }

    // d) Eliminar producto por código y devolver el producto eliminado
    public Producto eliminarProductoPorCodigo(int codigoProducto,int numLote,Stock stock) {
        for (Lote lote : stock.getLotes()) {
			if (numLote==lote.getNumeroLote()) {
				for (Producto producto : lote.getProductos()) {
					if (codigoProducto==producto.getCodigodelProducto()) {
						 lote.getProductos().remove(producto);
						//System.out.println("se ha eliminado:"+productos);
						return producto;
					}
				}
			}
		}
        return null; // Si no se encuentra el producto con el código especificado
    }
    // e) Mostrar productos en el lote
     public void mostrarProductosEnLote(int numLote,Stock stock) {
        for (Lote lote : stock.getLotes()) {
			if (numLote==lote.getNumeroLote()) {
				
        	for (Producto producto : lote.getProductos()) {
				if (lote.getProductos().isEmpty()) {
					System.out.println("No hay productos en el lote.");
				}else {
				System.out.println("codigo del producto:"+producto.getCodigodelProducto());
				System.out.println("descripcion:"+producto.getDescripcion());
				
			}
		}
    	
        }
    }}

    // f) Buscar producto por código y devolverlo
    public Producto buscarProductoPorCodigo(int codigoProducto,int numeroLote,Stock stock) {
        for (Lote lote : stock.getLotes()) {
			if (lote.getNumeroLote()== numeroLote) {
				for (Producto producto : lote.getProductos()) {
		            if (producto.getCodigodelProducto() == codigoProducto) {
		                return producto;
		            }
			}
		}
    	
        }
        return null; // Si no se encuentra el producto con el código especificado
    }

    
    
    // a) Grabar un nuevo producto en el lote - Fernando
    public void agregarProducto(Stock stock) {
    	stock.mostrarInformacionLotes();
    	
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Ingrese el numero de lote");
        int numeroLote = scanner.nextInt();
        Lote lote = stock.obtenerLotePorNumero(numeroLote);//Trae tu lote

        if (lote == null) {
            // Si el lote no existe, crear uno nuevo y agregarlo al stock
            lote = new Lote(numeroLote, "Pedro", "Ledesma", "2023-11-09");
            stock.agregarLote(lote);
        }
    	// Agregar productos a un lote de forma manual o predefinida
        System.out.println("Bienvenido desea agregar los productos manualmente?");
        String respuesta = scanner.next();
        
        if(respuesta.equalsIgnoreCase("si")) {	
        	// Solicitar información del producto al usuario
            System.out.print("Ingrese el código del producto: ");
            int codigoProducto = scanner.nextInt();
            System.out.print("Ingrese la descripción del producto: ");
            String descripcion = scanner.next();
            System.out.print("Ingrese la fecha de vencimiento del producto (formato: yyyy-MM-dd): ");
            String fechaVencimiento = scanner.next();
            System.out.print("Ingrese el número de lote del producto: ");
            int numeroLoteProducto = scanner.nextInt();
            System.out.print("Ingrese el costo de tratamiento del producto: ");
            double costoTratamiento = scanner.nextDouble();

            // Ya creado el producto se selecciona el tipo de producto

            System.out.println("¿Es un producto refrigerado? (S/N): ");
            String esRefrigerado = scanner.next();

            if (esRefrigerado.equalsIgnoreCase("S")) {
                System.out.print("Ingrese el código de supervisión alimentaria: ");
                String codigoSupervision = scanner.next();
                System.out.print("Ingrese la fecha de envasado (formato: yyyy-MM-dd): ");
                String fechaEnvasado = scanner.next();
                System.out.print("Ingrese la temperatura de mantenimiento recomendada: ");
                double temperaturaRecomendada = scanner.nextDouble();
                System.out.print("Ingrese la granja de origen: ");
                String granjaOrigen = scanner.next();

                // Se agrega el tipo de producto
                ProductoRefrigerado productoRefrigerado  = new ProductoRefrigerado(codigoProducto, descripcion, fechaVencimiento, numeroLoteProducto, costoTratamiento,
                        codigoSupervision, fechaEnvasado, temperaturaRecomendada, granjaOrigen);
                lote.productos.add(productoRefrigerado);
            } else {
                System.out.println("¿Es un producto congelado por aire, por agua o por nitrógeno? (A/W/N): ");
                String tipoCongelado = scanner.next();

                if (tipoCongelado.equalsIgnoreCase("A")) {
                	
                	System.out.println("Fecha de envasado: ");
            		String fechaEnvasado = scanner.next();
            		System.out.println("Código del organismo de supervisión alimentaria: ");
            		String codigoOrganismo = scanner.next();
            		System.out.println("Granja de origen: ");
            		String granjaOrigen = scanner.next();
            		System.out.println("Temperatura de mantenimiento recomendada: ");
            		double temperaturaRecomendada = scanner.nextDouble();
            		System.out.println("Proporciona la siguiente información sobre la composición del aire con que fue congelado: ");
            		System.out.println("Porcentaje de nitrógeno: ");
            		double porcentajeNitrogeno = scanner.nextDouble();
            		System.out.println("Porcentaje de oxígeno: ");
            		double porcentajeOxigeno = scanner.nextDouble();
            		System.out.println("Porcentaje de dióxido de carbono: ");
            		double porcentajeDioxidoCarbono = scanner.nextDouble();
            		System.out.println("Porcentaje de vapor de agua: ");
            		double porcentajeVaporAgua = scanner.nextDouble();
        	    	CongeladoPorAire congeladoPorAire = new CongeladoPorAire(codigoProducto, descripcion, fechaVencimiento, numeroLoteProducto, costoTratamiento, fechaEnvasado, codigoOrganismo, granjaOrigen, temperaturaRecomendada, porcentajeNitrogeno, porcentajeOxigeno, porcentajeDioxidoCarbono, porcentajeVaporAgua);
        	    	lote.productos.add(congeladoPorAire);
        	    	
        	    	
                } else if (tipoCongelado.equalsIgnoreCase("W")) {
                	
                	System.out.println("Fecha de envasado: ");
            		String fechaEnvasado = scanner.next();
            		System.out.println("Código del organismo de supervisión alimentaria: ");
            		String codigoOrganismo = scanner.next();
            		System.out.println("Granja de origen: ");
            		String granjaOrigen = scanner.next();
            		System.out.println("Temperatura de mantenimiento recomendada: ");
            		double temperaturaRecomendada = scanner.nextDouble();
            		System.out.println("Salinidad del agua: ");
            		double  salinidad = scanner.nextDouble();
        	    	CongeladoPorAgua congeladoPorAgua = new CongeladoPorAgua(codigoProducto, descripcion, fechaVencimiento, numeroLoteProducto, costoTratamiento, fechaEnvasado, codigoOrganismo, granjaOrigen, temperaturaRecomendada, salinidad);
        	    	lote.productos.add(congeladoPorAgua);
                
                } else if (tipoCongelado.equalsIgnoreCase("N")) {
                	
                	System.out.println("Fecha de envasado: ");
            		String fechaEnvasado = scanner.next();
            		System.out.println("Código del organismo de supervisión alimentaria: ");
            		String codigoOrganismo = scanner.next();
            		System.out.println("Granja de origen: ");
            		String granjaOrigen = scanner.next();
            		System.out.println("Temperatura de mantenimiento recomendada: ");
            		double temperaturaRecomendada = scanner.nextDouble();
            		System.out.println("método de congelación: ");
            		String metodoCongelacion = scanner.next();
            		System.out.println("Tiempo de exposición al nitrógeno: ");
            		double tiempoExposicion = scanner.nextDouble();
        	    	CongeladoPorNitrogeno congeladoPorNitrogeno = new CongeladoPorNitrogeno(codigoProducto, descripcion, fechaVencimiento, numeroLoteProducto, costoTratamiento, fechaEnvasado, codigoOrganismo, granjaOrigen, temperaturaRecomendada, metodoCongelacion, tiempoExposicion);
        	    	lote.productos.add(congeladoPorNitrogeno);
        	    	
                } else {
                    System.out.println("Opción no válida. Volviendo al menú principal.");
                }
                System.out.println("Producto agregado al lote.");
            }
        } else {
        	// Crear algunos productos y agregarlos al lote de forma automatica
        	ProductoRefrigerado productoRefrigerado1 = new ProductoRefrigerado(1, "Pollo Fresco", "2023-12-31", 002, 10.0,
                    "Codigo123", "2023-11-08", 4.0, "Granja A");
            ProductoRefrigerado productoRefrigerado2 = new ProductoRefrigerado(2, "Leche", "2023-12-31", 002, 5.0,
                    "Codigo456", "2023-11-08", 3.0, "Granja B");
            CongeladoPorAire productoCongeladoPorAire3 = new CongeladoPorAire(11, "Pizza", "2023-12-31", 002, 18.0, "1111-11-11",
                    "Codigo777", "Granja K", -12.0, 28.0, 22.0, 8.0, 15.0);
            CongeladoPorAire productoCongeladoPorAire4 = new CongeladoPorAire(12, "Empanadas", "2022-12-31", 002, 15.0, "1111-11-11",
                    "Codigo888", "Granja L", -10.0, 26.0, 20.0, 7.0, 12.0);
            CongeladoPorAgua productoCongeladoPorAgua3 = new CongeladoPorAgua(13, "Camarones", "2023-12-31", 002, 22.0, "1111-11-11",
                    "Codigo999", "Granja M", -18.0, 24.0);
            CongeladoPorAgua productoCongeladoPorAgua4 = new CongeladoPorAgua(14, "Pescado Blanco", "2023-12-31", 002, 20.0, "1111-11-11",
                    "Codigo1010", "Granja N", -15.0, 26.0);

            CongeladoPorNitrogeno productoCongeladoPorNitrogeno3 = new CongeladoPorNitrogeno(15, "Helado", "2023-12-31", 002, 25.0,"1111-11-11",
                    "Codigo1111", "Granja O", -20.0, "Método3", 35);
            CongeladoPorNitrogeno productoCongeladoPorNitrogeno4 = new CongeladoPorNitrogeno(16, "Yogur Helado", "2023-12-31", 002, 23.0,"1111-11-11",
                    "Codigo1212", "Granja P", -17.0, "Método4", 32);
            
         // Agregar los productos al lote
        	lote.productos.add(productoRefrigerado1);
        	lote.productos.add(productoRefrigerado2);
        	lote.productos.add(productoCongeladoPorAire3);
        	lote.productos.add(productoCongeladoPorAire4);
        	lote.productos.add(productoCongeladoPorAgua3);
        	lote.productos.add(productoCongeladoPorAgua4);
        	lote.productos.add(productoCongeladoPorNitrogeno3);
        	lote.productos.add(productoCongeladoPorNitrogeno4);
        	
        
            System.out.println("Productos creados y añadidos correctamente");
        }
    }

    // g) Calcular costo total de un lote
    public double calcularCostoTotalLote() {
        double costoTotal = 0;
        for (Producto producto : productos) {
            costoTotal += producto.getCostoTratamiento();
        }
        return costoTotal;
    }
    
    public void obtenerCantidadProductosPorTipoEnLote(Stock stock) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el numero de lote");
        int numeroLote = scanner.nextInt();

        Lote loteEncontrado = stock.obtenerLotePorNumero(numeroLote);

        int contadorRefrigerados = 0;
        int contadorCongeladosPorAire = 0;
        int contadorCongeladosPorAgua = 0;
        int contadorCongeladosPorNitrogeno = 0;

        if (loteEncontrado != null) {
        	List<Producto> productosEnLote = loteEncontrado.getProductos();
        	
            // Iterar sobre los productos del lote
            for (Producto producto : productosEnLote) {
                // Contar la cantidad de cada tipo de producto
                if (producto instanceof ProductoRefrigerado) {
                    contadorRefrigerados++; 
                } else if (producto instanceof CongeladoPorAire) {
                    contadorCongeladosPorAire++;
                } else if (producto instanceof CongeladoPorAgua) {
                    contadorCongeladosPorAgua++;
                } else if (producto instanceof CongeladoPorNitrogeno) {
                    contadorCongeladosPorNitrogeno++;
                }
            }

            // Mostrar resultados por consola
            System.out.println("Cantidad de productos refrigerados en el lote: " + contadorRefrigerados);
            System.out.println("Cantidad de productos congelados por aire en el lote: " + contadorCongeladosPorAire);
            System.out.println("Cantidad de productos congelados por agua en el lote: " + contadorCongeladosPorAgua);
            System.out.println("Cantidad de productos congelados por nitrógeno en el lote: " + contadorCongeladosPorNitrogeno);
        } else {
            System.out.println("No se encontró el lote en el stock.");
        }
    }
//7 g)Cantidad de productos en cada lote 
    public int obtenerCantidadProductosEnLote(Stock stock) {
    	int productosCantidad = 0;
    
    	for (Lote lote : stock.getLotes()) {
    			productosCantidad += lote.getProductos().size();
    		
			}
		
    return productosCantidad;
    }

    // Getters y Setters
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public int getNumeroLote() {
        return numeroLote;
    }
    
}
