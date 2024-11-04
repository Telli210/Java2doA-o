package estructuraDeDatos;

public class StackGenericaInversa<ELEMENT> {

	private final int maximoTamanio = 20;
	private ELEMENT []datos;
	private int cuenta;
	
	
	@SuppressWarnings("unchecked")
	public StackGenericaInversa() {
		this.datos = (ELEMENT []) new Object [this.maximoTamanio];
		this.cuenta = 0;
	}
	//------------------------------------------------------------------------------------------
	public void pushInversa(ELEMENT element) {
		if (this.isFullInversa()) {
	        throw new RuntimeException("La pila esta llena...");
	    }
		this.datos[this.datos.length-1-this.cuenta]= element;
		++cuenta;
	}
	//------------------------------------------------------------------------------------------
	public ELEMENT popInversa() {
		if (this.isEmptyInversa()) {
			throw new RuntimeException("La pila esta vacia...");
		}
		--cuenta;
		return this.datos[this.datos.length-1-this.cuenta];
	}
	//------------------------------------------------------------------------------------------
	
	public ELEMENT peekInversa () {
		if (this.isEmptyInversa()) {
			throw new RuntimeException("La pila esta vacia..."); 
		}
		return this.datos[this.datos.length-this.cuenta];
	}
	//------------------------------------------------------------------------------------------
	
	public boolean isEmptyInversa() {
		return this.cuenta <= 0;
	}
	//------------------------------------------------------------------------------------------
	
	public boolean isFullInversa() {
		return this.cuenta >= this.datos.length;
	}
	//------------------------------------------------------------------------------------------
	public int countInversa() {
		return this.cuenta;
	}
	//------------------------------------------------------------------------------------------
	
	public void clearInversa() {
		this.cuenta = 0;
	}

}

