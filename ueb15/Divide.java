import java.util.*;

public class Divide  implements CrunchOperation{

    /**
     * Teilt die n/2 größten Werte im Array durch die n/2 kleinsten und speichert den neuen Wert
     * im Datenfeld des jeweils größeren Wertes. D.h. der größte Wert wird durch den Kleinsten geteilt, 
     * der Zweitgrößte durch den Zweitkleinsten usw...
     * @param values
     */
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
        }
    }
    
}