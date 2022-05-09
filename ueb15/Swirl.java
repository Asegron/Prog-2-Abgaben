public class Swirl implements CrunchOperation{
    /**
     * Führt n zufällige Vertauschungen der Datenfelder durch; 
     * n ist durch die Länge des float-Arrays gegeben. 
     * @param values
     */
    public void crunch(float[] values){
        int n = values.length;
        int index;
        java.util.Random r = new java.util.Random();
        for(int i=0; i<n; i++){
            index = r.nextInt(n);
            float number = values[i];
            values[i] = values[index];
            values[index] = number;
        }
    }
}