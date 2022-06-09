
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import java.util.function.*;
import java.lang.*;

/**
 * Die Test-Klasse DoubleLinkedListTest testet die Klasse DoubleLinkedList
 */
public class DoubleLinkedListTest
{
    DoubleLinkedList dl;
    DoubleLinkedList dl2;
    /**
     * Konstruktor fuer die Test-Klasse DoubleLinkedListTest
     */
    public DoubleLinkedListTest()
    {
    }

    /**
     *  Setzt das Testgeruest fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @Before
    public void setUp()
    {
        dl = new DoubleLinkedList();
        dl.add(0, 10);
        dl.add(1, 11);
        dl.add(2, 12);
        dl.add(3, 11);
        dl.add(4, 13);
        
        dl2 = new DoubleLinkedList();
    }

    /**
     * Gibt das Testgeruest wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    @After
    public void tearDown()
    {
    }
    
    //Test add
    @Test(expected = NullPointerException.class)
    public void testAddNull(){
        dl.add(null);
        
    }
    
    @Test
    public void testAddTrue(){
        assertEquals(dl.add(14), true);
        assertEquals(14, dl.get(5));
        
    }
    
    @Test
    public void testAddLeereListe(){
        assertEquals(dl2.add(9), true);
        assertEquals(9, dl2.get(0));
        assertEquals(1, dl2.size());
    }
    
    // @Test(expected = ClassCastException.class)
    // public void testAddString(){
        // dl.add("Pizza");
    // }
    
    @Test 
    public void testAddIndex(){
        assertEquals(10, dl.get(0));
        assertEquals(11, dl.get(1));
        assertEquals(12, dl.get(2));
        assertEquals(11, dl.get(3));
        assertEquals(13, dl.get(4));
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexOutOfBoundsZuHoch(){
        dl.add(6, 10);
        
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexOutOfBoundsZuTief(){
        dl.add(-1, 10);
        
    }
    
    @Test(expected = NullPointerException.class)
    public void testAddIndexNullPointer(){
        dl.add(5, null);
        
    }
    
    @Test
    public void testAddIndexVerschieben(){
        dl.add(3, 33);
        assertEquals(10, dl.get(0));
        assertEquals(11, dl.get(1));
        assertEquals(12, dl.get(2));
        assertEquals(33, dl.get(3));
        assertEquals(11, dl.get(4));
        assertEquals(13, dl.get(5));
        assertEquals( 6, dl.size());
    }
    
    @Test
    public void testAddAllRichtigeReihenfolge(){
        Collection c = new ArrayList();
        c.add(1);
        c.add(2);
        c.add(3);
        dl.addAll(c);
        assertEquals(10, dl.get(0));
        assertEquals(11, dl.get(1));
        assertEquals(12, dl.get(2));
        assertEquals(11, dl.get(3));
        assertEquals(13, dl.get(4));
        assertEquals( 1, dl.get(5));
        assertEquals( 2, dl.get(6));
        assertEquals( 3, dl.get(7));
        assertEquals( 8, dl.size());
    }
    
    @Test(expected = NullPointerException.class)
    public void testAddAllNullpointer(){
        Collection c = new ArrayList();
        dl.addAll(c);
        
    }
    
    @Test(expected = NullPointerException.class)
    public void testAddAllNullPointer2(){
        Collection c = new ArrayList();
        c.add(1);
        c.add(null);
        c.add(3);
        dl.addAll(c);
        
    }
    //clear
    @Test
    public void testClearAll(){
        dl.clear();
        
        assertEquals(0, dl.size());
    }
    
    @Test
    public void testClearLeer(){
        dl2.clear();
        assertEquals(0, dl2.size());
    }
    
    //contains
    @Test(expected = NullPointerException.class)
    public void testContainsNullpointer(){
        dl.contains(null);
    }
    
    @Test
    public void testContainsElement(){
        assertEquals(true, dl.contains(11));
        
    }
    
    @Test
    public void testContainsElementFalse(){
        assertEquals(false, dl.contains(1));
        
    }
    
    //indexOf
    @Test(expected = NullPointerException.class)
    public void testIndexOfNullpointer(){
        dl.indexOf(null);
    }
    
    @Test
    public void testIndexOfEinzelnesElement(){
        assertEquals(0, dl.indexOf(10));
        
    }
    
    @Test
    public void testIndexOfDoppeltesElement(){
        assertEquals(1, dl.indexOf(11));
        
    }
    
    @Test
    public void testIndexOfNichtEnthaltenElement(){
        assertEquals(-1, dl.indexOf(1));
        
    }
    
    //isEmpty
    @Test
    public void testIsEmptyTrue(){
        assertEquals(true, dl2.isEmpty());
    }
    
    @Test
    public void testIsEmptyFalse(){
        assertEquals(false, dl.isEmpty());
    }
    
    //remove
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIndexOutOfBoundsNegativ(){
        dl.remove(-1);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIndexOutOfBoundsZuHoch(){
        dl.remove(5);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIndexOutOfBoundsLeereListe(){
        dl2.remove(0);
    }
    
    @Test
    public void testRemoveIndexHead(){
        assertEquals(10, dl.remove(0));
        assertEquals(11, dl.get(0));
        assertEquals(12, dl.get(1));
        assertEquals(11, dl.get(2));
        assertEquals(13, dl.get(3));
        assertEquals( 4, dl.size());
    }
    
    @Test
    public void testRemoveIndexTail(){
        assertEquals(13, dl.remove(4));
        assertEquals(10, dl.get(0));
        assertEquals(11, dl.get(1));
        assertEquals(12, dl.get(2));
        assertEquals(11, dl.get(3));
        assertEquals( 4, dl.size());
    }
    
    @Test
    public void testRemoveIndexMitte(){
        assertEquals(12, dl.remove(2));
        assertEquals(10, dl.get(0));
        assertEquals(11, dl.get(1));
        assertEquals(11, dl.get(2));
        assertEquals(13, dl.get(3));
        assertEquals( 4, dl.size());
    }
    
    @Test(expected = NullPointerException.class)
    public void testRemoveNullPointer(){
        dl.remove(null);
    }
    
    @Test
    public void testRemoveTrueHead(){
        assertEquals(true, dl.remove(dl.get(0)));
        assertEquals(11, dl.get(0));
        assertEquals(12, dl.get(1));
        assertEquals(11, dl.get(2));
        assertEquals(13, dl.get(3));
        assertEquals( 4, dl.size());
    }
    
    @Test 
    public void testRemoveTrueTail(){
        assertEquals(true, dl.remove(dl.get(4)));
        assertEquals(10, dl.get(0));
        assertEquals(11, dl.get(1));
        assertEquals(12, dl.get(2));
        assertEquals(11, dl.get(3));
        assertEquals( 4, dl.size());
    }
    
    @Test
    public void testRemoveTrueDoppeltesObjektMitte(){
        assertEquals(true, dl.remove(dl.get(1)));
        assertEquals(10, dl.get(0));
        assertEquals(12, dl.get(1));
        assertEquals(11, dl.get(2));
        assertEquals(13, dl.get(3));
        assertEquals( 4, dl.size());
    }
    
    //set
    @Test(expected = NullPointerException.class)
    public void testSetNullpointer(){
        dl.set(1, null);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetOutOfBoundsNegativ(){
        dl.set(-1, 10);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetOutOfBoundsZuHoch(){
        dl.set(5, 10);
    }
    
    @Test
    public void testSetKorrekt(){
        assertEquals(11, dl.set(1, 19));
        
        assertEquals(10, dl.get(0));
        assertEquals(19, dl.get(1));
        assertEquals(12, dl.get(2));
        assertEquals(11, dl.get(3));
        assertEquals(13, dl.get(4));
        assertEquals( 5, dl.size());
    }
    
}
