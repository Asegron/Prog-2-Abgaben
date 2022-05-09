public class Average implements CrunchOperation {
    /**
     * Bestimmt den Durchschnitt aller Werte im Array und speichert 
     * den Durchschnittswert im Datenfeld mit dem größten Wert.
     * @param values
     */
    public void crunch(float[] values){
        float durchschnitt;
        int maxIndex = 0;
        float summe = 0;
        float max = 0;
        for(int i=0; i < values.length; i++) {
            if(values[i] > max) {
                max = values[i];
                maxIndex = i;
            }
            summe = summe + values[i]; 
        }
        durchschnitt = summe / values.length;
        values[maxIndex] = durchschnitt;                
    }
}