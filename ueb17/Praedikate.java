import java.util.function.*;
/**
 * Beschreiben Sie hier die Klasse Praedikat.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Praedikate
{
    private static final int BEGINN = 1;
    private static final int END    = 10;
    
    private static final String MSG_QUADRAT   = "Nur die Quadratzahl der geraden Zahlen wird berechnet:\nf(x) = x * x : ";
    private static final String MSG_FAKULTAET = "Nur ungerade Ergebnisse werden ausgegeben:\nf(x) = x! : ";
    
    MethodeApplyAndPrint m;
    
    private Praedikate(){
        m = new MethodeApplyAndPrint();
    }
   
    /**
     * Methode start, die die Implementierungen der Praedikate odd und even enthaelt und anschliessend
     * die applyAndPrint Methode aufruft fuer verschiedene Faelle.
     *
     */
    public void start(){
        IntPredicate predicateOdd = new IntPredicate(){
            public boolean test(int i){
                return (i % 2 != 0);
            }
        };
        
        IntPredicate predicateEven = i -> (i % 2 == 0); 
        
        MyFunctionErweiterung quadrat = i -> i * i;
        System.out.println(MSG_QUADRAT);
        m.applyAndPrint(BEGINN, END, quadrat.conditionateInput(predicateEven));
        
        MyFunctionErweiterung fak = i -> { 
            return m.fakultaet(i);
        };
        System.out.println(MSG_FAKULTAET);
        m.applyAndPrint(BEGINN, END, fak.conditionateOutput(predicateOdd));
        
        
    }
    
    /**
     * Methode main zum Starten des Programms.
     *
     */
    public static void main(String[] args){
        Praedikate p = new Praedikate();
        p.start();
    }
}
