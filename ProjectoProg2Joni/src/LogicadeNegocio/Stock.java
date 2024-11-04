package LogicadeNegocio;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private List<Lote> lotes; // Lista de lotes en el stock

    // Constructor
    public Stock() {
        this.lotes = new ArrayList<>(); // Inicialización de la lista de lotes
    }

    // Funcionalidades
    // a) Calcular margen de ganancia total por lote
    public double calcularMargenGananciaTotalPorLote(int numeroLote) {
        for (Lote lote : lotes) {
            if (lote.getNumeroLote() == numeroLote) {
                return lote.calcularMargenGananciaTotalLote();
            }
        }
        return -1; // Si no se encuentra el lote con el número especificado
    }

    // b) Calcular costo total de un lote
    public double calcularCostoTotalDeLote(int numeroLote) {
        for (Lote lote : lotes) {
            if (lote.getNumeroLote() == numeroLote) {
                return lote.calcularCostoTotalLote();
            }
        }
        return -1; // Si no se encuentra el lote con el número especificado
    }

    // a) Grabar un nuevo producto
    public void agregarLote(Lote lote) {
        this.lotes.add(lote);
    }

    // b) Modificar los datos de un producto determinado
    public void modificarProductoEnLote(int numeroLote, int codigoProducto, Producto productoModificado) {
        for (Lote lote : lotes) {
            if (lote.getNumeroLote() == numeroLote) {
                for (int i = 0; i < lote.getProductos().size(); i++) {
                    if (lote.getProductos().get(i).getCoddelProducto() == codigoProducto) {
                        lote.getProductos().set(i, productoModificado);
                        break;
                    }
                }
            }
        }
    }

    // d) Calcular costo total en stock
    public double calcularCostoTotalEnStock() {
        double costoTotal = 0;
        for (Lote lote : lotes) {
            for (Producto producto : lote.getProductos()) {
                costoTotal += producto.getCostoTratamiento();
            }
        }
        return costoTotal;
    }

    public Lote obtenerLotePorNumero(int numeroLote) {
    	for (Lote lote : lotes) {
    		if (lote.getNumeroLote() == numeroLote) {
    			return lote;
    		}
    	}
    	System.out.println("Lote no encontrado");
    	return null;
    }
}
