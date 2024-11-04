package ListaEnlazada;

//
//Creado por Julio Tentor <jtentor@fi.unju.edu.ar>
//

import java.util.Iterator;

// Clase que representa una lista simplemente enlazada
public class SimpleLinkedList<ELEMENT> implements ILinkedList<ELEMENT> {

 //region Clase Node

 // Clase interna que representa un nodo en la lista simplemente enlazada
 private class Node<ELEMENT> {
     // Elemento almacenado en el nodo
     public ELEMENT item;
     // Referencia al siguiente nodo
     public Node<ELEMENT> next;

     // Constructor por defecto
     public Node() {
         this(null, null);
     }

     // Constructor con un elemento
     public Node(ELEMENT item) {
         this(item, null);
     }

     // Constructor completo con elemento y siguiente nodo
     public Node(ELEMENT item, Node<ELEMENT> next) {
         this.item = item;
         this.next = next;
     }

     @Override
     public String toString() {
         return this.item.toString();
     }
 }
 //endregion

 //region Atributos

 // Primer nodo de la lista
 protected Node<ELEMENT> head;
 // Número de elementos en la lista
 protected int count;
 // Último nodo de la lista
 protected Node<ELEMENT> tail;
 //endregion

 //region Constructores

 // Constructor por defecto que inicializa una lista vacía
 public SimpleLinkedList() {
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
     if (this.count == 0) {
         // Si la lista está vacía, head y tail apuntan al nuevo nodo
         this.head = this.tail = new Node<ELEMENT>(item, null);
         ++this.count;
     } else {
         // Si la lista no está vacía, añade el nuevo nodo al inicio
         Node<ELEMENT> temp = new Node<ELEMENT>(item, null);
         temp.next = this.head;
         this.head = temp;
         ++this.count;
     }
 }

 // Inserta un elemento al principio de la lista
 public void addFirst(ELEMENT item) {
     Node<ELEMENT> temp = new Node<ELEMENT>(item, this.head);
     if (this.count == 0) {
         this.tail = temp;
     }
     this.head = temp;
     ++this.count;
 }

 // Agrega un elemento al final de la lista (versión básica)
 public void addLastRookieVersion(ELEMENT item) {
     if (this.count == 0) {
         // Si la lista está vacía, head y tail apuntan al nuevo nodo
         this.head = this.tail = new Node<ELEMENT>(item, null);
         ++this.count;
     } else {
         // Si la lista no está vacía, añade el nuevo nodo al final
         Node<ELEMENT> temp = new Node<ELEMENT>(item, null);
         this.tail.next = temp;
         this.tail = temp;
         ++this.count;
     }
 }

 // Añade un elemento al final de la lista
 public void addLast(ELEMENT item) {
     Node<ELEMENT> temp = new Node<ELEMENT>(item, null);
     if (this.count == 0) {
         this.head = temp;
     } else {
         this.tail.next = temp;
     }
     this.tail = temp;
     ++this.count;
 }

 // Remueve y devuelve el primer elemento de la lista
 public ELEMENT removeFirst() {
     if (this.count == 0) {
         throw new RuntimeException("La lista está vacía...");
     }
     ELEMENT item = this.head.item;
     this.head = this.head.next;
     if (this.head == null) {
         this.tail = null;
     }
     --this.count;
     return item;
 }

 // Remueve y devuelve el último elemento de la lista
 public ELEMENT removeLast() {
     if (this.count == 0) {
         throw new RuntimeException("La lista está vacía...");
     }
     ELEMENT item = this.tail.item;
     if (this.head.next == null) {
         // Si la lista tiene solo un elemento, la dejamos vacía
         this.head = this.tail = null;
     } else {
         // Recorremos la lista para llegar al penúltimo nodo
         Node<ELEMENT> skip = this.head;
         while (skip.next.next != null) {
             skip = skip.next;
         }
         // Actualizamos tail al penúltimo nodo
         this.tail = skip;
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
     return new SimpleLinkedListIterator(this.head);
 }

 // Clase interna que implementa un iterador para la lista
 private class SimpleLinkedListIterator implements Iterator<ELEMENT> {
     private Node<ELEMENT> current;

     public SimpleLinkedListIterator(Node<ELEMENT> current) {
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
 //endregion

}
