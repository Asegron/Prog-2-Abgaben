public class PalindromIterativ implements Palindrom {
    
    @Override
    public boolean istPalindrom(String wort) {

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
    
    public static void main(String[] args) { 
        if (args.length == 1) {
            if (args[0].endsWith(".txt")) { 
                String datei = args[0];
                DateiLesenSchreiben.ladeDatei(datei);
            } else {
                String wort = args[0];
                PalindromIterativ palindromIterativ = new PalindromIterativ();
                System.out.println(palindromIterativ.istPalindrom(removeWhitesspace(wort.toLowerCase())));
            }
        } else {
            System.out.println("Keine Textdatei angegeben!");
        }
    }
}