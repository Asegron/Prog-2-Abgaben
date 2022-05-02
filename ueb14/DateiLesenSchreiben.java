import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.*;

public class DateiLesenSchreiben {
    
    public static void ladeDatei(String datName) { 
        datName = datName + (".txt");
        
        File file = new File(datName);
        //lesbarkeit der Datei prüfen
        if (!file.exists() || !file.canRead()) {
            throw new IllegalArgumentException("Datei existiert nicht oder ist nicht lesbar!");       
        }

        BufferedReader in = null;
        PrintStream diskWriter = null;       
        try { 
            in = new BufferedReader(new FileReader(datName)); 
            String zeile; 
            diskWriter = new PrintStream("ergebnis.txt");
            diskWriter.println("Stringlänge:\t Rekursiv:\t Iterativ:\t \n");
                while ((zeile = in.readLine()) != null && !zeile.isEmpty()) {                 
                    PalindromRekursiv palindromRekursiv = new PalindromRekursiv(); 
                    // Misst die Zeit von PalindromRekursiv
                    long beginRekursiv = System.nanoTime();
                    palindromRekursiv.istPalindrom(zeile.toLowerCase());
                    long endRekursiv = System.nanoTime() - beginRekursiv;                                
    
                    PalindromIterativ palindromIterativ = new PalindromIterativ();
                    // Misst die Zeit von PalindromIterativ
                    long beginIterativ = System.nanoTime();
                    palindromIterativ.istPalindrom(zeile.toLowerCase());
                    long endIterativ = System.nanoTime() - beginIterativ;               
                    diskWriter.println(zeile.length() + "\t" + endRekursiv + "\t" + endIterativ);                   
                } 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } finally { 
            if (in != null) 
                try { 
                    in.close(); 
                    diskWriter.close();
                } catch (IOException e) { 
                } 
        }         
    }
}

