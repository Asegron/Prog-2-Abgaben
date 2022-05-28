
/**
 * Klasse FunctionStaticNested implementiert die Funktion f(x) = x! als StaticNested-Klasse.
 * 
 * @author Desiree Becker, Daniel Stelz
 * @version 28.05.22
 */
public class FunctionStaticNested{
    private static final int BEGINN = 1;
    private static final int END    = 10;
    
    private static final String MSG_FAKULTAET = "f(x) = x! : ";
    
    static MethodeApplyAndPrint m;
    private FunctionStaticNested(){
        m = new MethodeApplyAndPrint();
    }
    
    public static class Fakultaet implements MyFunction{
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
    
    /**
     * Methode start, die die applyAndPrint mit der Fakultaet aufruft
     *
     */
    public void start(){
        Fakultaet fakul = new Fakultaet();
        System.out.println(MSG_FAKULTAET);
        m.applyAndPrint(BEGINN, END, fakul);
        
    }
    
    /**
     * Methode main zum Starten des Programms.
     *
     */
    public static void main(String[] args){
        FunctionStaticNested f = new FunctionStaticNested();
        f.start();
    
    } 
}
