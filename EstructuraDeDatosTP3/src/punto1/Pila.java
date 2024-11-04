package punto1;

public class Pila {
	private int dimension;
	private String [] datos;
	private int count;
	
	public Pila() {
		this(5);
	}

	public Pila(int dimension) {
		this.dimension = dimension;
		this.datos = new String[this.dimension];
		this.count = 0;
	}
	
	//Apilar
	public void push(String elemento) {
		if(this.count >= this.dimension) {
			throw new RuntimeException("La pila esta llena");
		}
		this.datos[this.count] = elemento;
		++this.count;
	}
	
	//Desapilar
	public String pop() {
		if(this.empty()) {
			throw new RuntimeException("La pila esta vacia");
		}
		--this.count;
		return this.datos[this.count];
	} 
	
	//Consultar la cima
	public String peek() {
		if(this.empty()) {
			throw new RuntimeException("La pila esta vacia");
		}
		return this.datos[this.count - 1];
	}
	
	//Esta vacia
	public boolean empty() {
		return this.count <= 0;
	}
	
	//Esta llena 
	public int count() {
		return this.count;
	}
	
	public void mostrarStack() {
		for(int i = 0; i < 5;i++) {
			System.out.println(datos[i]);
		}
	}
}
