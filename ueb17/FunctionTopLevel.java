
/**
 * Klasse FunctionsTopLevel implementiert die Funktion f(x) = x! als TopLevel-Klasse.
 * 
 * @author Desiree Becker, Daniel Stelz
 * @version 27.05.22
 */
public class FunctionTopLevel{
    private static final int BEGINN = 1;
    private static final int END    = 10;
    
    private static final String MSG_FAKULTAET = "f(x) = x! : ";
    
    MethodeApplyAndPrint m;
    private FunctionTopLevel(){
        m = new MethodeApplyAndPrint();
    }
    
     /**
     * Methode start, die die applyAndPrint mit der Fakultaet aufruft
     *
     */
    public void start(){
        FunctionFakultaet ff = new FunctionFakultaet();
        System.out.println(MSG_FAKULTAET);
        m.applyAndPrint(BEGINN, END, ff);
        
        
    }
    
    /**
     * Methode main zum Starten des Programms.
     *
     */
    public static void main(String[] args){
        FunctionTopLevel f = new FunctionTopLevel();
        f.start();
    
    }
}
