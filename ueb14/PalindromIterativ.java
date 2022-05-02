public class PalindromIterativ implements Palindrom {
    
    @Override
    public boolean istPalindrom(String wort) {

        wort = wort.toLowerCase();
        
        if(wort.length() == 0 || wort.length() == 1){
            return true;
        }   

        for(int i = 0; i < wort.length()/2;i++){
            if(wort.charAt(i) != wort.charAt(wort.length()-i-1)){
                return false;
            }
        }
        return true;
           
    }

    public static String removeWhitesspace(String wort){
        wort = wort.replaceAll("\\s+", "");
        return wort;
    }
 
}