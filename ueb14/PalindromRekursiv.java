public class PalindromRekursiv implements Palindrom {

    @Override
    public boolean istPalindrom(String wort) {
        if (wort.length() == 0 || wort.length() == 1) {
            return true;
        }
        if (wort.charAt(0) == wort.charAt(wort.length() - 1)) {
            return istPalindrom(wort.substring(1, wort.length() - 1));
        }

        return false;
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
            }else {
                String wort = args[0];
                PalindromRekursiv palindromRekursiv = new PalindromRekursiv();
                System.out.println(palindromRekursiv.istPalindrom(removeWhitesspace(wort.toLowerCase())));

            }
        } else {
            System.out.println("Keine Textdatei angegeben!");
        }
    }
}