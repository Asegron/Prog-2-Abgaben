
/**
 * Beschreiben Sie hier die Klasse Fakultaet.
 * 
 * @author Desiree Becker, Daniel Stelz
 * @version 27.05.22
 */
public class Fakultaet implements MyFunction{
    MethodeApplyAndPrint m;
    public Fakultaet(){
        m= new MethodeApplyAndPrint();
    }
    
    /**
     * Methode apply, um die Fakultaet-Funktion zu implementieren
     *
     * @param i, Zahl von der die Fakultaet berechnet wird
     * @return Der Rueckgabewert ist i!
     */
    public int apply(int i){
        return m.fakultaet(i);
    }
}
