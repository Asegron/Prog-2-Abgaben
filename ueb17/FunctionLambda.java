import static java.lang.Math.*;
/**
 * Beschreiben Sie hier die Klasse FunctionsLambda.
 * 
 * @author Desiree Becker, Daniel Stelz
 * @version 28.05.22
 */
public class FunctionLambda{
    private static final int BEGINN = 1;
    private static final int END    = 10;
    
    private static final String MSG_QUADRAT   = "f(x) = x^2 : ";
    private static final String MSG_FAKULTAET = "f(x) = x! : ";
    private static final String MSG_XHXP1     = "f(x) = x^(x + 1) :";
    private static final String MSG_FIBO      = "f(x) = fib(x) : ";
    
    MethodeApplyAndPrint m;
    private FunctionLambda(){
        m = new MethodeApplyAndPrint();
    }
    
    /**
     * Methode start ruft die einzelnen Methoden der jeweiligen Funktionen auf.
     *
     */
    public void start(){
        
        startQuadrat();
        
        startFakultaet();
        
        startXHochXPlus1();
        
        startFibonacci();
        
    }
    
    /**
     * Methode startQuadrat, enthaelt die Implementierung der x^2-Funktion und ruft applyAndPrint damit auf.
     *
     */
    public void startQuadrat(){
        MyFunction quadrat = i -> i * i;
        System.out.println(MSG_QUADRAT);
        m.applyAndPrint(BEGINN, END, quadrat);
    }
    
    /**
     * Methode startFakultaet, enthaelt die Implementierung der Fakultaet-Funktion und ruft applyAndPrint damit auf.
     *
     */
    public void startFakultaet(){
        MyFunction fak = i -> { 
            return m.fakultaet(i);
        };
        System.out.println(MSG_FAKULTAET);
        m.applyAndPrint(BEGINN, END, fak);
    }
    
    /**
     * Methode startXHochXPlus1, enthaelt die Implementierung der x^(x+1)-Funktion und ruft applyAndPrint damit auf.
     *
     */
    public void startXHochXPlus1(){
        MyFunction exp = i -> (int)pow((double)i, (double)i+1);
        System.out.println(MSG_XHXP1);
        m.applyAndPrint(BEGINN, END, exp);
    }
    
    /**
     * Methode startFibonacci, enthaelt die Implementierung der Fibonacci-Funktion und ruft applyAndPrint damit auf.
     *
     */
    public void startFibonacci(){
        MyFunction fib = i -> {
            int aktuell =  1;
            int vorgaenger = 1;
            
            for(int j = 2; j < i; j++){
                int zs = aktuell;
                aktuell += vorgaenger;
                vorgaenger = zs;
            }
            return aktuell;
        };    
        System.out.println(MSG_FIBO);
        m.applyAndPrint(BEGINN, END, fib);
    }
    
    /**
     * Methode main zum Starten des Programms.
     *
     */
    public static void main(String[] args){
        FunctionLambda f = new FunctionLambda();
        f.start();
    }
}