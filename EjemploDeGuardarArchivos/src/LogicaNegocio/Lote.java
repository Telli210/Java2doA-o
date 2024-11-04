package LogicaNegocio;

import java.io.Serializable;

public class Lote implements Serializable {
    private String nombreProducto;
    private int cantidad;

    public Lote(String nombreProducto, int cantidad) {
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto: " + nombreProducto + ", Cantidad: " + cantidad;
    }
}

