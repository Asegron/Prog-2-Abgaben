public class Sum implements CrunchOperation {
    /**
    * Summiert die Elemente des Arrays paarweise von links nach rechts auf und speichert den neuen
    * Wert in dem jeweiligen rechten Datenfeld. D.h.: a[1] = a[0] + a[1]; a[2] = a[1] + a[2]
    *
    * @param values
    */
     public void crunch(float[] values){
        for(int i = 1; i <values.length; i++ ){
            values[i] = values[i-1] + values[i];
        }
    }
}