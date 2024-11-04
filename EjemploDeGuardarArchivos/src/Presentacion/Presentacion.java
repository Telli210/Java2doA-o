package Presentacion;

import LogicaNegocio.Lote;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Datos.AccesoDatos;

public class Presentacion {

    public static void main(String[] args) {
        String filePath = "DatosGuardados.txt";
        Scanner entrada = new Scanner(System.in);
        AccesoDatos datos = new AccesoDatos(filePath);  // Capa de acceso a datos
        int opcion;
        ArrayList<Lote> listaLotes = new ArrayList<>();
        do {
        	opcion = menu(entrada);
        	
            switch (opcion) {
                case 1:
                	
                	//1. Agrega un producto al lote
                	
                    System.out.println("Ingrese el nombre del producto:");
                    String nombre = entrada.nextLine();

                    System.out.println("Ingrese la cantidad del producto:");
                    int cantidad = entrada.nextInt();
                    entrada.nextLine();//Consume el salto de linea

                    //Crea el lote y le agrega los datos ingresados
                    Lote lote = new Lote(nombre, cantidad);
                    

                    try {
                        listaLotes = datos.cargarDatos();  //Intenta cargar los datos actuales
                    } catch (IOException | ClassNotFoundException e) {//En caso de que salte alguna de las dos excepciones muestra el siguiente msj
                        System.out.println("No se pudo cargar el archivo o está vacío.");
                    }

                    //Añade el nuevo stock a la lista y guardar
                    listaLotes.add(lote);
                    try {
                        datos.guardarDatos(listaLotes);  //Guarda el array en el archivo
                        System.out.println("Datos guardados con éxito.");
                    } catch (IOException e) {//En caso de que salte la IOException muestra el siguiente msj
                        System.out.println("Error al guardar los datos: " + e.getMessage());
                    }
                    break;

                case 2:
                    //2. Modificar los datos de un producto
                    try {
                        listaLotes = datos.cargarDatos(); //Lee los datos desde el archivo
                        if (listaLotes.isEmpty()) {	//Verifica si esta vacio
                            System.out.println("No hay datos guardados.");
                        } else {
                            System.out.println("Datos recuperados: " + listaLotes.toString());
                        }
                    } catch (IOException | ClassNotFoundException e) {//En caso de que salte alguna de las dos excepciones muestra el siguiente msj
                        System.out.println("Error al recuperar los datos: " + e.getMessage());
                    }
                    //Aca iria el codigo que modifica los datos del producto
                    //
                    //
                    //Luego lo vuelve a guardar en el archivo
                    try {
                        datos.guardarDatos(listaLotes);  //Guarda el array en el archivo
                        System.out.println("Datos guardados con éxito.");
                    } catch (IOException e) {//En caso de que salte la IOException muestra el siguiente msj
                        System.out.println("Error al guardar los datos: " + e.getMessage());
                    }
                    break;
                case 3:
                    //3. Eliminar un producto del lote
                	//Aca recupera el array desde el archivo y lo guarda en listaLotes
                    try {
                        listaLotes = datos.cargarDatos(); //Lee los datos desde el archivo
                        if (listaLotes.isEmpty()) {	//Verifica si esta vacio
                            System.out.println("No hay datos guardados.");
                        } else {
                            System.out.println("Datos recuperados: " + listaLotes.toString());
                        }
                    } catch (IOException | ClassNotFoundException e) {//En caso de que salte alguna de las dos excepciones muestra el siguiente msj
                        System.out.println("Error al recuperar los datos: " + e.getMessage());
                    }
                    //Aca iria el codigo para eliminar el producto del lote seleccionado
                    
                    
                    //Guardamos los datos en el archivo
                    try {
                        datos.guardarDatos(listaLotes);  // Guardar el objeto en un archivo
                        System.out.println("Datos guardados con éxito.");
                    } catch (IOException e) {//En caso de que salte la IOException muestra el siguiente msj
                        System.out.println("Error al guardar los datos: " + e.getMessage());
                    }
                    break;
                    
                case 11:
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 3);

        entrada.close();
    }
    
    public static int menu(Scanner entrada) {
    	 int opcion;
    	 System.out.println("Elija una opción:");
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
         opcion = entrada.nextInt();
         entrada.nextLine(); //Consume el salto de linea
    	return opcion;
    }
}
