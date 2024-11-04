package estructuraDeDatos;

public class QueueInversa<ELEMENT> {

    private final static Integer defaulDimension = 10;

    private ELEMENT[] data;
    private int head;  // posición de la cabeza (donde se eliminan elementos)
    private int tail;  // posición de la cola (donde se añaden elementos)
    private int count; // contador de elementos

    public QueueInversa() {
        this(QueueInversa.defaulDimension);
    }

    @SuppressWarnings("unchecked")
    public QueueInversa(int dimension) {
        this.data = (ELEMENT[]) new Object[dimension];
        this.head = 0;  // comenzamos desde el final
        this.tail = 0;  // comenzamos desde el final
        this.count = 0;
    }

    // Métodos internos de la cola next (prev)
    private int prev(int pos) {
        if (--pos < 0) {
            pos = this.data.length - 1;
        }
        return pos;
    }

    public boolean isEmpty() {
        return this.count <= 0;
    }

    public boolean isFull() {
        return this.count >= data.length;
    }

    // Devuelve el número de elementos en la cola.
    public int size() {
        return this.count;
    }

    // Métodos de la cola

    // Inserta el elemento especificado en esta cola
    public boolean add(ELEMENT element) {
        if (this.isFull()) {
            throw new IllegalStateException("Cola llena ...");
        }

        // Primero, añadir el elemento en la posición de tail
        this.data[this.tail] = element;

        // Ahora, mover el tail hacia atrás
        this.tail = prev(this.tail);
        ++this.count;

        return true;
    }

    // Inserta el elemento especificado en esta cola
    public boolean offer(ELEMENT element) {
        if (this.isFull()) {
            return false;
        }

        // Primero, añadir el elemento en la posición de tail
        this.data[this.tail] = element;

        // Ahora, mover el tail hacia atrás
        this.tail = prev(this.tail);
        ++this.count;

        return true;
    }

    // Recupera y elimina la cabeza de esta cola
    public ELEMENT poll() {
        if (this.isEmpty()) {
            return null;
        }

        // Obtener el elemento antes de mover head
        ELEMENT result = this.data[this.head];

        // Mover head hacia atrás
        this.head = prev(this.head);
        --this.count;

        return result;
    }

    // Recupera y elimina la cabeza de esta cola
    public ELEMENT remove() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Cola vacía ...");
        }

        // Obtener el elemento antes de mover head
        ELEMENT result = this.data[this.head];

        // Mover head hacia atrás
        this.head = prev(this.head);
        --this.count;

        return result;
    }

    // Recupera, pero no elimina, la cabeza de esta cola
    public ELEMENT element() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Cola vacía ...");
        }

        return this.data[this.head];
    }

    // Recupera, pero no elimina, la cabeza de esta cola
    public ELEMENT peek() {
        if (this.isEmpty()) {
            return null;
        }

        return this.data[this.head];
    }
}