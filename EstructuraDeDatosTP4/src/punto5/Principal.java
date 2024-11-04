package punto5;

import java.util.Scanner;
import punto3.Helper;
import punto3.Queue;

public class Principal {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        // Llenar las dos colas con los datos ingresados por el usuario
        System.out.println("Rellenar primera cola");
        Queue<Integer> cola1 = llenarCola(entrada);
        
        System.out.println("Rellenar segunda cola");
        Queue<Integer> cola2 = llenarCola(entrada);
        
        System.out.println("Fin de llenado de colas");

        // Intercalar las dos colas
        Queue<Integer> colaIntercalada = intercalarColas(cola1, cola2);
        
        // Mostrar el contenido de ambas colas originales y de la cola intercalada
        mostrarColas(cola1, cola2, colaIntercalada);
    }
    
    // Método para mostrar las tres colas y calcular la suma de la cola intercalada
    private static void mostrarColas(Queue<Integer> cola1, Queue<Integer> cola2, Queue<Integer> colaIntercalada) {
        System.out.println("Primera cola:");
        while (!cola1.isEmpty()) {
            System.out.print("  " + cola1.remove());
        }
        System.out.println("\n");
        
        System.out.println("Segunda cola:");
        while (!cola2.isEmpty()) {
            System.out.print("  " + cola2.remove());
        }
        System.out.println("\n");
        
        System.out.println("Cola intercalada:");
        int suma = 0;
        while (!colaIntercalada.isEmpty()) {
            int elemento = colaIntercalada.remove();
            suma += elemento;
            System.out.print("  " + elemento);
        }
        System.out.println("\n");
        
        // Mostrar la suma total de los números en la cola intercalada
        System.out.println("Suma total de la cola intercalada: " + suma);
    }
    
    // Método que intercalará los elementos de dos colas y devolverá una nueva cola intercalada
    private static Queue<Integer> intercalarColas(Queue<Integer> cola1, Queue<Integer> cola2) {
        int dimension = cola1.size() + cola2.size(); // La dimensión de la nueva cola debe ser la suma de las dos colas originales
        Queue<Integer> colaIntercalada = new Queue<>(dimension); // Crear una cola con capacidad suficiente para todos los elementos
        
        // Colas auxiliares para mantener una copia de los elementos originales de cola1 y cola2
        Queue<Integer> colaAuxiliar1 = new Queue<>(cola1.size());
        Queue<Integer> colaAuxiliar2 = new Queue<>(cola2.size());

        // Intercalar los elementos de ambas colas
        while (!cola1.isEmpty() && !cola2.isEmpty()) {
            int elemento1 = cola1.remove();
            colaIntercalada.add(elemento1);
            colaAuxiliar1.add(elemento1); // Guardar una copia en la cola auxiliar
            
            int elemento2 = cola2.remove();
            colaIntercalada.add(elemento2);
            colaAuxiliar2.add(elemento2); // Guardar una copia en la cola auxiliar
        }

        // Si quedan elementos en cola1, se vuelven a agregar en su cola original desde la auxiliar
        while (!colaAuxiliar1.isEmpty()) {
            cola1.add(colaAuxiliar1.remove());
        }
        
        // Si quedan elementos en cola2, se vuelven a agregar en su cola original desde la auxiliar
        while (!colaAuxiliar2.isEmpty()) {
            cola2.add(colaAuxiliar2.remove());
        }

        return colaIntercalada; // Devolver la cola intercalada
    }
    
    // Método para llenar una cola con valores ingresados por el usuario
    private static Queue<Integer> llenarCola(Scanner entrada) {
        Queue<Integer> cola = new Queue<>(); // Crear una cola con la dimensión predeterminada
        
        // Se llenará la cola hasta que esté llena
        while (!cola.isFull()) {
            int numero = Helper.validarEntero(entrada, "Ingrese un número: "); // Validar que el número ingresado sea correcto
            cola.add(numero); // Agregar el número a la cola
        }
        return cola;
    }

}
