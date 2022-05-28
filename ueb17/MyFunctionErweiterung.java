import java.util.function.*;
/**
 * Beschreiben Sie hier die Klasse MyFunctionErweiterung.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public interface MyFunctionErweiterung extends MyFunction{
    /**
     * Methode input, nimmt ein Praedikat als Argument entgegen und gibt einen Lambdaausdruck zurueck, der prueft, ob
     * die uebergebene Zahl das Praedikat erfuellt, wenn das der Fall ist, wird die applyMethode zurueck gegeben,
     * ansonsten 0
     *
     * @param predicate, uebergebenes Praedikat,nach dem die Zahl ueberprueft wird.
     * @return Der Rueckgabewert gibt bei true die applyMethode zurueck und bei false 0.
     */
    default MyFunction conditionateInput(IntPredicate predicate){
        return i->{ 
            if(predicate.test(i)){
               return apply(i);
            }else{
                return 0;
            }   
        };   
    }
    
    /**
     * Methode output, nimmt ein Praedikat als Argument entgegen und gibt einen Lambda-Ausdruck 
     * zurueck. Der Lambda-Ausdruck prueft, ob das Ergebnis der apply-Methode das Praedikat erfuellt. 
     * Ist das Praedikat erfuellt, wird das Ergebnis zurueckgegeben, ansonsten 0.
     *
     * @param predicate uebergebenes Praedikat,nach dem das Ergebnis der apply-Methode ueberprueft wird.
     * @return Der Rueckgabewert gibt bei true die applyMethode zurueck und bei false 0.
     */
    default MyFunction conditionateOutput(IntPredicate predicate){
        return i->{
            if(predicate.test(apply(i))){
                return apply(i);
            }else{
                return 0;
            }   
        };
    }
}
