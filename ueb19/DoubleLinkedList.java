
import java.util.*;
import java.util.function.*;
import java.lang.*;

/**
 * Die Klasse DoubleLinkedList, die die Datenstruktur der doppelt verketteten Liste verwaltet.
 */
public class DoubleLinkedList<E> implements List<E>

{
    //Kopf der Liste
    private Node head;
    //Schwanz der Liste
    private Node tail;
    
    //Kostruktor 
    public DoubleLinkedList(){
        this.head = null;
        this.tail = null;
    }
    
    //Aufgabe v
    /**
     * Methode add, haengt das angegebene Element an das Ende dieser Liste an.
     *
     * @param e, anzuhaengendes Element
     * @return gibt true zurueck, wenn das Anhaengen erfolgreich war.
     */
    @Override
    public boolean add(E e){
        if(e == null){
            throw new NullPointerException();
            
        }
        
        Node n = new Node(e);
        
        if(head == null){
            head = n;
            tail = n;
        }else{
            n.setPrevious(tail);
            tail.setNext(n);
            tail = n;
        }
        return true;
    }
    
    //Aufgabe xi
    /**
     * Methode add, fuegt das angegebene Element an der angegebenen Position in diese Liste ein
     *
     * @param index, gibt den Index an , an dem das Element eingefuegt werden soll
     * @param element, das Element, das eigefuegt werden soll
     */
    @Override
    public void add(int index, E element){
        if(index < 0 || index > size()){
            throw new IndexOutOfBoundsException();
        }
        
        if(element == null){ //kann man element mit == auf null pruefen?
            throw new NullPointerException();
        }
        
        Node neu = new Node(element);
        if(head == null){ //liste vorher leer
            head = neu;
            tail = neu;
        }else{
            Node n = head;
            for(int i = 0; i < index; i++){
                n = n.getNext();
            }
        
       
        
            if(n == null){//hinter tail einfuegen
               n = neu;
               n.setPrevious(tail);
               tail.setNext(n);
               tail = n;
            } else{//mittendrin einfuegen
                n.getPrevious().setNext(neu);
                neu.setPrevious(n.getPrevious());
                neu.setNext(n);
                n.setPrevious(neu);
            
            }
        }
        
        
        
    }
    
    //Aufgabe vii
    /**
     * Methode addAll, haengt alle Elemente in der angegebenen Sammlung an das Ende dieser Liste 
     * in der Reihenfolge an, in der sie vom Iterator der angegebenen Sammlung zurueckgegeben werden
     *
     * @param c, die Collection, die angehaengt werden soll
     * @return Der Rueckgabewert gibt true zurueck, wenn es erfolgreich angehaengt wurde
     */
    @Override
    public boolean addAll(Collection<? extends E> c){
        if(c == null || c.size() == 0){
            throw new NullPointerException();
        }
        
        E n ;
        Iterator i = c.iterator();
        while(i.hasNext()){
            n = (E)i.next();
            if(n == null){
                throw new NullPointerException();
            }
            
        }
        
        E e;
        Iterator j = c.iterator();
        int length = size();
        while(j.hasNext()){
            e =(E) j.next();
            add(length, e);
            length++;
        }
       
        return true;
    }
    
    @Override 
    public boolean addAll(int index, Collection<? extends E> c){
        throw new UnsupportedOperationException();
    }
    
    //Aufgabe viii
    /**
     * Methode clear, entfernt alle Elemente aus dieser Liste 
     *
     */
    @Override
    public void clear(){
        int length = size();
        if(length > 0){
            tail = null;
            head = null;
        }
    }
    
    //Aufgabe iii
    /**
     * Methode contains, gibt true zurueck, wenn diese Liste das angegebene Element enthaelt.
     *
     * @param o, das Objekt, das in der Liste enthalten sein soll
     * @return Der Rueckgabewert ist true wenn sich das Element in der Liste befindet
     */
    @Override
    public boolean contains(Object o){
        if(o == null){
            throw new NullPointerException();
            
        }
        
        
        if(head != null){
            Node n = head;
            while(n != null && !n.getValue().equals(o)){
                n = n.getNext();
            }
            
            if(n != null){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean containsAll(Collection<?> c){
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean equals(Object o){
        throw new UnsupportedOperationException();
    }
    
    //Aufgabe ix
    /**
     * Methode get, gibt das Element an der angegebenen Position in dieser Liste zurueck.
     *
     * @param index, das Element an dem Index soll zurueck gegeben werden
     * @return Der Rueckgabewert gibt das Element an der Stelle zurueck.
     */
    @Override
    public E get(int index){
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        
        Node n = head;
        
        for(int i = 0; i < index; i++){
            n = n.getNext();
        }
        
        return (E)n.getValue();
    }
    
    @Override
    public int hashCode(){
        throw new UnsupportedOperationException();
    }
    
    //Aufgabe xiii
    /**
     * Methode indexOf, gibt den Index des ersten Vorkommens des angegebenen Elements in dieser Liste 
     * zurueck oder -1, wenn diese Liste das Element nicht enthaelt.
     *
     * @param o, das Objekt, dessen Index zurueck gegeben wird
     * @return Der Rueckgabewert gibt den Index, an dem sich das Element befindet zurueck, ansonsten -1
     */
    @Override
    public int indexOf(Object o){
        if(o == null){
            throw new NullPointerException();
        }
        
        
        if(head != null){
            
            for(int i = 0; i < size(); i++){
                if(o.equals(get(i))){
                    return i;
                }
            }
            
        }
        return -1;
    }
   
    //Aufgabe ii
    /**
     * Methode isEmpty, gibt true zurueck, wenn diese Liste keine Elemente enthaelt.
     *
     * @return Der Rueckgabewert gibt true zurueck, wenn die Liste keine Elemente enthaelt, ansonsten false
     */
    @Override
    public boolean isEmpty(){
        if(head == null){
            return true;
        }
        return false;
    }
    
    @Override
    public Iterator<E> iterator(){
        throw new UnsupportedOperationException();
    }
    
    @Override
    public int lastIndexOf(Object o){
        throw new UnsupportedOperationException();
    }
    
    @Override
    public ListIterator<E> listIterator(){
        throw new UnsupportedOperationException();
    }
    
    @Override
    public ListIterator<E> listIterator(int index){
        throw new UnsupportedOperationException();
    }
    
    //Aufgabe xii
    /**
     * Methode remove, entfernt das Element an der angegebenen Position in dieser Liste 
     *
     * @param index, die Stelle, an dem das Element entfernt werden soll
     * @return Der Rueckgabewert gibt das entfernte Element zurueck
     */
    @Override
    public E remove(int index){
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        E entfernt;
        
        if(size() == 1){
            entfernt = (E)head.getValue();
            head = null;
            tail = null;
            
        } else{
            Node n = head;
            for(int i = 0; i < index; i++){
                n = n.getNext();
            }
            
            Node pre = n.getPrevious();
            Node next = n.getNext();
            
            if(pre != null){
                pre.setNext(next);
            } else{
                head = next;
            }
            
            if(next != null){
                next.setPrevious(pre);
            } else{
                tail = pre;
            }
            n.setPrevious(null);
            n.setNext(null);
            entfernt = (E)n.getValue();
            n = null;
        }
        
        return entfernt;
    }
    
    //Aufgabe vi
    /**
     * Methode remove, entfernt das erste Vorkommen des angegebenen Elements aus dieser Liste, 
     * falls vorhanden. 
     *
     * @param o Ein Parameter gibt das zu entfernende Element an.
     * @return Der Rueckgabewert gibt true zurueck, wenn das Objekt erfolgreich entfernt wurde.
     */
    @Override
    public boolean remove(Object o){
        if(o == null){
            throw new NullPointerException();
        }
       
        //was ist wenn gar keine Elemente darin, also head == null
        if(head == null){
            return false;
        }
        
        Node n = head;
        while(n != null && !n.getValue().equals(o)){
            n = n.getNext();
        }
        
        if(n != null){
            Node pre = n.getPrevious();
            Node next = n.getNext();
            
            if(pre != null){
                pre.setNext(next);
            } else{
                head = next;
            }
            
            if(next != null){
                next.setPrevious(pre);
            } else{
                tail = pre;
            }
            n.setPrevious(null);
            n.setNext(null);
            
            return true;
        }
        return false;
    }
    
    @Override
    public boolean removeAll(Collection<?> c){
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void replaceAll(UnaryOperator<E> operator){
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean retainAll(Collection<?> c){
        throw new UnsupportedOperationException();
    }
    
    //Aufgabe x
    /**
     * Methode set, ersetzt das Element an der angegebenen Position in dieser Liste durch das
     * angegebene Element.
     *
     * @param index, die Stelle an der das Objekt ersetzt werden soll.
     * @param element, stellt das Element dar, das das urspruengliche ersetzen soll.
     * @return Der Rueckgabewert gibt das Objekt zurueck, das ueberschrieben wurde.
     */
    @Override
    public E set(int index, E element){
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        
        if(element == null){
            throw new NullPointerException();
        }
        
        
        Node n = head;
        
        for(int i = 0; i < index; i++){
            n = n.getNext();
        }
        E pre = (E)n.getValue();
        n.setValue(element);
        return pre;
    }
    
    //Aufgabe i
    /**
     * Methode size(), gibt die Anzahl der Elemente in dieser Liste zurueck.
     *
     * @return Der Rueckgabewert gibt die Anzahl der Elemente in dieser Liste zurueck.
     */
    @Override
    public int size(){
        int size = 0;
        if(head != null){
            Node n = head;
            while(n != null){
                size++;
                n= n.getNext();
            }
            
        }
        return size;
    }
    
    @Override
    public void sort(Comparator<? super E> c){
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Spliterator<E> spliterator(){
        throw new UnsupportedOperationException();
    }
    
    @Override
    public List<E> subList(int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Object[] toArray(){
        throw new UnsupportedOperationException();
    }
    
    //Aufgabe iv
    /**
     * Methode toArray, gibt ein Array zurueck, das alle Elemente in dieser Liste in der richtigen 
     * Reihenfolge enthaelt (vom ersten bis zum letzten Element). 
     * Der Laufzeittyp des zurueckgegebenen Arrays ist der des angegebenen Arrays.
     *
     * @param a, das Array, in das die Liste geschrieben werden soll
     * @return Der Rueckgabewert gibt das Array zurueck.
     */
    @Override
    public <T> T[] toArray(T[] a){
        if(a == null){
            throw new NullPointerException();
        }
       
        
        int length = size();
        
        Node n = head;
        
        if(a.length >= length){
            for(int i = 0; i < length; i++){
                a[i] =(T) n.getValue();
                n = n.getNext();
            }
            
            for(int i = a.length; i >= length; i--){
                a[i] = null;
            }
            
        }
        
        T[] re = a.clone();
        System.arraycopy(a, 0, re, 0, length);
        for(int i = 0; i < re.length; i++){
            re[i] =(T) n.getValue();
            n = n.getNext();
        }
        
        return re;
    }
    
}

