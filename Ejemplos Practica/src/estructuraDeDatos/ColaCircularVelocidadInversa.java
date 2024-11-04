package estructuraDeDatos;

public class ColaCircularVelocidadInversa<E> {

    private final static int defaultDimension = 10;
    private E[] data;
    private int head;
    private int tail;

    public ColaCircularVelocidadInversa() {
        this(ColaCircularVelocidadInversa.defaultDimension);
    }

    @SuppressWarnings("unchecked")
    public ColaCircularVelocidadInversa(int dimension) {
        this.data = (E[]) new Object[dimension + 1]; // Espacio adicional para distinguir entre cola llena y vacía.
        this.head = 0; // Posición donde se eliminarán los elementos.
        this.tail = 0; // Posición donde se añadirán los elementos.
    }

    private int prev(int pos) {
        if (--pos < 0)
            pos = this.data.length - 1;
        return pos;
    }

    public boolean add(E element) {
        if (this.isFull()) {
            throw new IllegalStateException("Cola llena ...");
        }

        // Primero, almacenar el elemento en la posición tail
        this.data[this.tail] = element; // Añadir el elemento en la posición de tail
        // Luego, mover tail hacia atrás
        this.tail = prev(this.tail);
        return true;
    }

    public E peek() {
        if (this.isEmpty()) {
            return null;
        }
        // Primero, obtener el dato en la posición head
        E result = this.data[head]; // Obtener el elemento en la posición head
        return result; // Retornar el elemento
    }

    public E remove() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Cola vacía ...");
        }

        // Primero, obtener el dato en head
        E result = this.data[head]; // Obtener el elemento en la posición head
        // Luego, mover head hacia atrás
        this.head = prev(this.head);
        return result; // Retornar el elemento
    }

    public int size() {
        if (this.tail >= this.head) {
            return this.tail - this.head;
        } else {
            return this.data.length - this.head + this.tail;
        }
    }

    public boolean isEmpty() {
        return this.tail == this.head;
    }

    public boolean isFull() {
        return this.prev(this.tail) == this.head;
    }
}


