package estructuraDeDatos;

public class Pila {
	private int dimension;
	private char [] datos;
	private int count;
	
	public Pila() {
		this(5);
	}

	public Pila(int dimension) {
		this.dimension = dimension;
		this.datos = new char[this.dimension];
		this.count = 0;
	}
	
	public void push(char elemento) {
		if(this.count >= this.dimension) {
			throw new RuntimeException("La pila esta llena");
		}
		this.datos[this.count] = elemento;
		++this.count;
	}
	
	public char pop() {
		if(this.empty()) {
			throw new RuntimeException("La pila esta vacia");
		}
		--this.count;
		return this.datos[this.count];
	} 
	
	public char peek() {
		if(this.empty()) {
			throw new RuntimeException("La pila esta vacia");
		}
		return this.datos[this.count - 1];
	}
	
	public boolean empty() {
		return this.count <= 0;
	}
	
	public int count() {
		return this.count;
	}
	
}
