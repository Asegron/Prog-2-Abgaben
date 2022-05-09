import java.util.Arrays;


public class NumberCruncherAnonym extends NumberCruncherAbstrakt {
    
    /**
    * Konstruktor der Klasse NumberCrucherAnonym
    *
    * @param values darf nicht leer oder null sein
    */
    public NumberCruncherAnonym(float [] values) {    
       super(values);
    }
    

    public void sum() {
        CrunchOperation sum = new CrunchOperation(){
            public void crunch(float[] values){
                for(int i = 1; i <values.length; i++ ){
                    values[i] = values[i-1] + values[i];
                }
            }
        };
        sum.crunch(getNumbers());
    }

    public void swirl() {
        CrunchOperation swirl = new CrunchOperation(){
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
        };
        swirl.crunch(getNumbers());
    }

    public void divide(){
        CrunchOperation divide = new CrunchOperation(){
            public void crunch(float[] values){   
                int n = values.length;
                float[][] matrix = new float [n][2];
                Arrays.sort (values);
                for(int i=0; i<n; i++){
                    matrix[i][0] = values[i];
                    matrix[i][1] = i; 
                }
                int low = 0;
                int high = n-1;
                while(low < high) {
                    matrix[high][0] /= matrix[low][0];
                    low++;
                    high--;
                }
                for(int i=n-1; i>=n/2; i--) {
                    values[ (int) matrix[i][1] ] = matrix[i][0];
                            //index                   value
                }
            }
        };
        divide.crunch(getNumbers());       
    }
    
    public void subtract() {
        CrunchOperation substract = new CrunchOperation(){
            public void crunch(float[] values) {
                for(int i = 1; i <values.length; i++ ){
                    values[i] = values[i-1] - values[i];
                }
            }
        };
        substract.crunch(getNumbers());    
    }

    public void average(){
        CrunchOperation average = new CrunchOperation(){
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
        };
        average.crunch(getNumbers());
    }
}