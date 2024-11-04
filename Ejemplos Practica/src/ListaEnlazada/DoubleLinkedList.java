package ListaEnlazada;

//
//Creado por Julio Tentor <jtentor@fi.unju.edu.ar>
//

import java.util.Iterator;

// Clase que representa una lista doblemente enlazada
public class DoubleLinkedList<ELEMENT> implements ILinkedList<ELEMENT> {

 //region Clase Node

 // Clase interna que representa un nodo en la lista doblemente enlazada
 protected class Node<ELEMENT> {
     // Elemento almacenado en el nodo
     protected ELEMENT item;
     // Referencia al nodo siguiente
     protected Node<ELEMENT> next;
     // Referencia al nodo anterior
     protected Node<ELEMENT> prev;

     // Constructor por defecto
     protected Node() {
         this(null, null, null);
     }

     // Constructor con un elemento
     protected Node(ELEMENT item) {
         this(item, null, null);
     }

     // Constructor con un elemento y el siguiente nodo
     protected Node(ELEMENT item, Node<ELEMENT> next) {
         this(item, next, null);
     }

     // Constructor completo con elemento, siguiente y nodo anterior
     protected Node(ELEMENT item, Node<ELEMENT> next, Node<ELEMENT> prev) {
         this.item = item;
         this.next = next;
         this.prev = prev;
     }

     @Override
     public String toString() {
         return this.item.toString();
     }
 }
 //endregion

 //region Atributos

 // Primer nodo de la lista
 private Node<ELEMENT> head;
 // Número de elementos en la lista
 private int count;
 // Último nodo de la lista
 private Node<ELEMENT> tail;
 //endregion

 //region Constructores

 // Constructor por defecto que inicializa una lista vacía
 public DoubleLinkedList() {
     this.head = null;
     this.count = 0;
     this.tail = null;
 }
 //endregion

 //region Métodos de la lista enlazada

 // Devuelve el número de elementos en la lista
 public int size() {
     return this.count;
 }

 // Agrega un elemento al principio de la lista (versión básica)
 public void addFirstRookieVersion(ELEMENT item) {
     if (this.size() <= 0) {
         // Si la lista está vacía, head y tail apuntan al nuevo nodo
         this.head = this.tail = new Node<ELEMENT>(item, null, null);
         ++this.count;
     } else {
         // Si la lista no está vacía, añade el nuevo nodo al inicio
         Node<ELEMENT> temp = new Node<ELEMENT>(item, null, null);
         temp.next = this.head;
         this.head.prev = temp;
         this.head = temp;
         ++this.count;
     }
 }

 // Inserta un elemento al principio de la lista
 public void addFirst(ELEMENT item) {
     Node<ELEMENT> temp = new Node<ELEMENT>(item, this.head, null);
     if (this.size() <= 0) {
         this.tail = temp;
     } else {
         this.head.prev = temp;
     }
     this.head = temp;
     ++this.count;
 }

 // Agrega un elemento al final de la lista (versión básica)
 public void addLastRookieVersion(ELEMENT item) {
     if (this.size() <= 0) {
         // Si la lista está vacía, head y tail apuntan al nuevo nodo
         this.head = this.tail = new Node<ELEMENT>(item, null, null);
         ++this.count;
     } else {
         // Si la lista no está vacía, añade el nuevo nodo al final
         Node<ELEMENT> temp = new Node<ELEMENT>(item, null, null);
         temp.prev = this.tail;
         this.tail.next = temp;
         this.tail = temp;
         ++this.count;
     }
 }

 // Añade un elemento al final de la lista
 public void addLast(ELEMENT item) {
     Node<ELEMENT> temp = new Node<ELEMENT>(item, null, this.tail);
     if (this.size() <= 0) {
         this.head = temp;
     } else {
         this.tail.next = temp;
     }
     this.tail = temp;
     ++this.count;
 }

 // Remueve y devuelve el primer elemento de la lista
 public ELEMENT removeFirst() {
     if (this.size() <= 0) {
         throw new RuntimeException("La lista está vacía...");
     }
     ELEMENT item = this.head.item;
     this.head = this.head.next;
     if (this.head == null) {
         this.tail = null;
     } else {
         this.head.prev = null;
     }
     --this.count;
     return item;
 }

 // Remueve y devuelve el último elemento de la lista
 public ELEMENT removeLast() {
     if (this.size() <= 0) {
         throw new RuntimeException("La lista está vacía...");
     }
     ELEMENT item = this.tail.item;
     if (this.head.next == null) {
         this.head = this.tail = null;
     } else {
         this.tail = this.tail.prev;
         this.tail.next = null;
     }
     --this.count;
     return item;
 }
 //endregion

 //region Métodos de Object

 @Override
 public String toString() {
     if (this.size() <= 0) {
         return "";
     }

     // Utiliza StringBuilder para construir la representación de la lista
     StringBuilder sb = new StringBuilder();

     sb.append("[" + this.head.item.toString());
     for (Node<ELEMENT> skip = this.head.next; skip != null; skip = skip.next) {
         sb.append(", " + skip.item.toString());
     }
     sb.append("]");

     return sb.toString();
 }
 //endregion

 //region Métodos de Iterable

 // Devuelve un iterador para recorrer la lista desde el inicio
 @Override
 public Iterator<ELEMENT> iterator() {
     return new DoubleLinkedListIterator(this.head);
 }

 // Clase interna que implementa un iterador para la lista
 public class DoubleLinkedListIterator implements Iterator<ELEMENT> {
     private Node<ELEMENT> current;

     public DoubleLinkedListIterator(Node<ELEMENT> current) {
         this.current = current;
     }

     @Override
     public boolean hasNext() {
         return this.current != null;
     }

     @Override
     public ELEMENT next() {
         if (!this.hasNext()) {
             throw new RuntimeException("La lista está vacía...");
         }
         ELEMENT item = this.current.item;
         this.current = this.current.next;
         return item;
     }
 }

 // Devuelve un iterador para recorrer la lista desde el final hacia el inicio
 public Iterator<ELEMENT> iteratorBack() {
     return new DoubleLinkedListIteratorBack(this.tail);
 }

 // Clase interna que implementa un iterador para recorrer hacia atrás
 public class DoubleLinkedListIteratorBack implements Iterator<ELEMENT> {
     private Node<ELEMENT> current;

     public DoubleLinkedListIteratorBack(Node<ELEMENT> current) {
         this.current = current;
     }

     @Override
     public boolean hasNext() {
         return this.current != null;
     }

     @Override
     public ELEMENT next() {
         if (!this.hasNext()) {
             throw new RuntimeException("La lista está vacía...");
         }
         ELEMENT item = this.current.item;
         this.current = this.current.prev;
         return item;
     }
 }
 //endregion

}

