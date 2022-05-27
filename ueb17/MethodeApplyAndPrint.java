
/**
 * Klasse die die MethodeApplyAndPrint zum Verwenden in einzelnen Klassen beinhaltet.
 * 
 * @author Desiree Becker, Daniel Stelz
 * @version 27.05.22
 */
public class MethodeApplyAndPrint{
    public MethodeApplyAndPrint(){ //Standardkonstruktor
    }
    
    /**
     * Methode applyAndPrint, die zwei natürliche Zahlen i und j sowie
     * eine Funktion f : N → N entgegen nimmt. Die Methode soll die übergebene Funktion auf alle
     * Zahlen zwischen i und j anwenden und das Ergebnis ausgeben.
     * 
     * @param i als uebergebene Integer-Zahl, die den Start der Zahlen darstellt, auf die die Funktion angewendet wird.
     * @param j als uebergebene Integer-Zahl, die den Start der Zahlen darstellt, bis zu der die Funktion angewendet wird.
     * @param function, die auf die kommenden Zahlen angewendet wird.
     */
    public static void applyAndPrint(int i , int j , MyFunction function){ 
        if(i <= 0 || j <= 0){
            throw new IllegalArgumentException("Mindestens eine der ubergebenen Zahlen ist keine natuerliche Zahl! Bitte geben Sie nur natuerliche Zahlen ein.");
        }
        
        while(i <= j){
            int ergebnis = function.apply(i);
            System.out.println("f(" + i + ") = " + ergebnis);
            if(ergebnis == Integer.MAX_VALUE){
                System.out.println("Obere Grenze von Integer erreicht, Ergebnis nicht korrekt.");
            }
            i++;
        }
        System.out.println("\n");
    }
    
    /**
     * Methode fakultaet, die die Funktion der Fakultaet implementiert
     *
     * @param i, die Zahl von der die Fakultaet berechnet wird.
     * @return Der Rueckgabewert gibt die Fakultaet zurueck.
     */
    public int fakultaet(int i){
        int result = 1;
        while(i > 0){
            result = result * i;
            i--;
        }
        return result;
    }
}