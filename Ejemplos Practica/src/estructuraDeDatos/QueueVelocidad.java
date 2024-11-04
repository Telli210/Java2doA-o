package estructuraDeDatos;

public class QueueVelocidad {
	private final static int defaultDimension = 10;
    private int[] data;
    private int head;
    private int tail;

    public QueueVelocidad() {
        this(QueueVelocidad.defaultDimension);
    }

    public QueueVelocidad(int dimension) {
        this.data = new int[dimension + 1]; // Espacio adicional para distinguir entre cola llena y vacía.
        this.head = 0;
        this.tail = 0;
    }

    private int next(int pos) {
        return (pos + 1) % this.data.length;
    }

    public boolean add(int element) {
        if (this.isFull()) {
            throw new IllegalStateException("Cola llena ...");
        }
        this.data[this.tail] = element;
        this.tail = this.next(this.tail);
        return true;
    }

    public Integer peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.data[this.head];
    }

    public Integer remove() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Cola vacía ...");
        }
        int result = this.data[this.head];
        this.head = this.next(this.head);
        return result;
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
        return this.next(this.tail) == this.head;
    }
}
