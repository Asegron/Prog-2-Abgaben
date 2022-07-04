import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class FileReader{
    public List<String> readTextFile(String file, String prefix, int minLength, int limit) {
        File datei =  new File(file);
        List <String> result = ((Collection<String>) datei).stream().filter(String-> String.startsWith(prefix)).sorted(Comparator.comparing(String -> String)).collect(Collectors.toList());;
    
        if (!datei.exists() || !datei.canRead() ) {
            throw new FileNotReadableException();
        
        }
        if (datei.isDirectory()) {
        	throw new NotNormalFileException();
        }
        
        return result;

    }
}