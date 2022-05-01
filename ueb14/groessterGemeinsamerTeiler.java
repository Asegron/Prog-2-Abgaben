public class groessterGemeinsamerTeiler {
    
    public static int ggt(int a, int b) {
    if (b == 0) {
        return a;
    }
    
    if (a < 0 || b < 0){
           throw new IllegalArgumentException("Nur natürliche Zahlen erlaubt!");
    }
    
    return ggt(b, a % b);
    }
}