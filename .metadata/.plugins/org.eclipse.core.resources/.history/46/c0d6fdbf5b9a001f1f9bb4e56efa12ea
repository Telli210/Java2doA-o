package arboles;

// Created by Julio Tentor <jtentor@fi.unju.edu.ar>

public class BinaryTree<ELEMENT> {

    //region Clase Interna para Nodos de Árbol Binario
    protected class BTNode<ELEMENT> {
        public ELEMENT item;           // Almacena el valor del nodo
        public BTNode<ELEMENT> left;   // Referencia al hijo izquierdo
        public BTNode<ELEMENT> right;  // Referencia al hijo derecho

        // Constructor por defecto: nodo vacío
        public BTNode() {
            this(null, null, null);
        }

        // Constructor: nodo con un valor, sin hijos
        public BTNode(ELEMENT item) {
            this(item, null, null);
        }

        // Constructor: nodo con un valor y referencias a hijos izquierdo y derecho
        public BTNode(ELEMENT item, BTNode<ELEMENT> left, BTNode<ELEMENT> right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }

        // Representación del nodo en cadena de texto
        @Override
        public String toString() {
            return this.item.toString();
        }

        // Método para mostrar el valor del nodo (para recorridos)
        public void Visit() {
            System.out.printf("%s ", this.item.toString());
        }
    }
    //endregion

    //region Atributos
    protected BTNode<ELEMENT> root;  // Raíz del árbol
    //endregion

    //region Constructores

    // Constructor por defecto: árbol vacío
    public BinaryTree() {
        this.root = null;
    }

    // Constructor: crea un árbol con un solo nodo raíz
    public BinaryTree(ELEMENT item) {
        this(item, null, null);
    }

    // Constructor: crea un árbol con un nodo raíz y subárboles izquierdo y derecho opcionales
    public BinaryTree(ELEMENT item, BinaryTree<ELEMENT> left, BinaryTree<ELEMENT> right) {
        this.root = new BTNode<ELEMENT>(item, null, null);
        if (left != null) {
            this.root.left = left.root;
        }
        if (right != null) {
            this.root.right = right.root;
        }
    }
    //endregion

    // Método para representar el árbol como una cadena de texto
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb, this.root);
        return sb.toString();
    }

    // Método recursivo para construir la representación en cadena del árbol
    protected void toString(StringBuilder sb, BTNode<ELEMENT> root) {
        if (root != null) {
            sb.append(root.item.toString());
            if (root.left != null) {
                sb.append("(");
                toString(sb, root.left);
                if (root.right != null) {
                    sb.append(",");
                    toString(sb, root.right);
                }
                sb.append(")");
            } else {
                if (root.right != null) {
                    sb.append("(,");
                    toString(sb, root.right);
                    sb.append(")");
                }
            }
        }
    }

    // Método para recorrer el árbol en preorden
    public void PreOrder() {
        PreOrder(this.root);
    }

    // Método recursivo para recorrer en preorden
    protected void PreOrder(BTNode<ELEMENT> root) {
        if (root != null) {
            root.Visit();        // Visitar nodo actual
            PreOrder(root.left);  // Recorrer subárbol izquierdo
            PreOrder(root.right); // Recorrer subárbol derecho
        }
    }

    // Método para recorrer el árbol en inorden
    public void InOrder() {
        InOrder(this.root);
    }

    // Método recursivo para recorrer en inorden
    protected void InOrder(BTNode<ELEMENT> root) {
        if (root != null) {
            InOrder(root.left);   // Recorrer subárbol izquierdo
            root.Visit();         // Visitar nodo actual
            InOrder(root.right);  // Recorrer subárbol derecho
        }
    }

    // Método para recorrer el árbol en postorden
    public void PostOrder() {
        PostOrder(this.root);
    }

    // Método recursivo para recorrer en postorden
    protected void PostOrder(BTNode<ELEMENT> root) {
        if (root != null) {
            PostOrder(root.left);  // Recorrer subárbol izquierdo
            PostOrder(root.right); // Recorrer subárbol derecho
            root.Visit();          // Visitar nodo actual
        }
    }

    // Método para recorrer el árbol en orden descendente
    public void DescendingOrder() {
        DescendingOrder(this.root);
    }

    // Método recursivo para recorrer en orden descendente
    protected void DescendingOrder(BTNode<ELEMENT> root) {
        if (root != null) {
            DescendingOrder(root.right); // Recorrer subárbol derecho
            root.Visit();                // Visitar nodo actual
            DescendingOrder(root.left);   // Recorrer subárbol izquierdo
        }
    }

    // Método para contar todos los nodos en el árbol
    public int NodeCount() {
        return NodeCount(this.root);
    }

    // Método recursivo para contar nodos
    protected int NodeCount(BTNode<ELEMENT> root) {
        if (root != null) {
            return 1 + NodeCount(root.left) + NodeCount(root.right);
        }
        return 0;
    }

    // Método para contar solo las hojas en el árbol
    public int LeafCount() {
        return LeafCount(this.root);
    }

    // Método recursivo para contar hojas
    protected int LeafCount(BTNode<ELEMENT> root) {
        if (root != null) {
            if ((root.left == null) && (root.right == null)) {
                return 1;
            } else {
                return LeafCount(root.left) + LeafCount(root.right);
            }
        }
        return 0;
    }

    // Método para contar solo los nodos internos
    public int InternalCount() {
        return InternalCount(this.root);
    }

    // Método recursivo para contar nodos internos
    protected int InternalCount(BTNode<ELEMENT> root) {
        if (root != null) {
            if ((root.left == null) && (root.right == null)) {
                return 0;
            } else {
                return 1 + InternalCount(root.left) + InternalCount(root.right);
            }
        }
        return 0;
    }

    // Método para obtener el nivel máximo (profundidad) del árbol
    public int MaxLevel() {
        return MaxLevel(this.root);
    }

    // Método recursivo para calcular el nivel máximo
    protected int MaxLevel(BTNode<ELEMENT> root) {
        if (root != null) {
            if ((root.left != null) || (root.right != null)) {
                int leftLevel = MaxLevel(root.left);
                int rightLevel = MaxLevel(root.right);
                return 1 + Math.max(leftLevel, rightLevel);
            }
            return 0;
        }
        return -1;
    }

    // Método para obtener la altura del árbol
    public int Height() {
        return MaxLevel() + 1;
    }
}
