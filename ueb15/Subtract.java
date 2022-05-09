public class Subtract implements CrunchOperation{

    /**
     * Subtrahiert die Elemente des Arrays paarweise von links nach rechts auf und 
     * speichert den neuen Wert in dem jeweils rechten Datenfeld.
     * @param values
     */
    public void crunch(float[] values) {
        for(int i = 1; i <values.length; i++ ){
            values[i] = values[i-1] - values[i];
        }
    }
    
}