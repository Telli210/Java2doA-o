package Datos;

import java.io.*;
import java.util.ArrayList;
import LogicaNegocio.Lote;

public class AccesoDatos {
    private String filePath;

    public AccesoDatos(String filePath) {
        this.filePath = filePath;
    }

    //Metodo para guardar datos, lanza IOException
    public void guardarDatos(ArrayList<Lote> lotes) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(lotes);
        }
    }

    //Metodo para cargar datos, lanza IOException y ClassNotFoundException
    @SuppressWarnings("unchecked")
    public ArrayList<Lote> cargarDatos() throws IOException, ClassNotFoundException {
        ArrayList<Lote> lotes = new ArrayList<>();

        // Verificar si el archivo existe
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("El archivo no existe. Se creará uno nuevo.");
            return lotes; //Si no existe, devuelve una lista vacía
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            lotes = (ArrayList<Lote>) ois.readObject();
        } catch (EOFException e) {
            //El archivo está vacío o corrupto
            System.out.println("El archivo está vacío.");
        }

        return lotes;
    }
}
