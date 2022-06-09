
/**
 * Die Klasse Node, die die Knoten fuer doppelt verkettete Listen verwaltet.
 * 
 */
public class Node<T>
{
     // Wert des Knotens
     private T value;
     // Vorheriger Knoten
     private Node pre;
     // Nächster Knoten
     private Node next;
  
     //Konstruktor
     /**
      * Node Konstruktor, legt einen Knoten mit gegebenen Wert an
      *
      * @param value, der Wet des Knotens wird mitgegeben
      */
     public Node(T value){
         this.value = value;
         next = null;
     }

     /**
      * Methode setValue, setzt den Wert des Knotens neu
      *
      * @param v, der neue Wet wird mitgegeben
      */
     public void setValue(T v) {
         value = v;
     }

     /**
      * Methode setPrevious, setzt den Vorgaenger des Knotens 
      *
      * @param p, der neue Vorgaenger
      */
     public void setPrevious(Node p) {
         this.pre = p;
     }

     /**
      * Methode setNext, setzt den Nachfolger des Knotens 
      *
      * @param p, der neue Nachfolger
      */
     public void setNext(Node n) {
         this.next = n;
     }

     /**
      * Methode getValue, gibt den Wert des Knotens zurueck.
      *
      * @return Der Rueckgabewert gibt den Wert des Knotens zurueck.
      */
     public T getValue() {
         return value;
     }

     /**
      * Methode getPrevious, gibt den Vorgaenger des Knotens zurueck.
      *
      * @return Der Rueckgabewert gibt den Vorgaenger des Knotens zurueck.
      */
     public Node getPrevious() {
         return this.pre;
     }

     /**
      * Methode getNext, gibt den Nachfolger des Knotens zurueck.
      *
      * @return Der Rueckgabewert gibt den Nachfolger des Knotens zurueck.
      */
     public Node getNext() {
         return next;
     }

}