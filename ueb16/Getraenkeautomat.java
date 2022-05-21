import java.util.ArrayList;
import java.util.*;

public class Getraenkeautomat <T extends Flasche<Getraenk>> {
    private ArrayList<T> flaschenlager = new ArrayList<T>();
    private int[] kapazitaet;
    
    public Getraenkeautomat(int dimension) {
       kapazitaet = new int[dimension];
    }

    public int[] getKapazitaet() {
        return kapazitaet;
    }

    public void flascheEinlegen(T Flasche) {
        if( (Object)((Flasche<Getraenk>) Flasche).get() == null   ) {
            throw new IllegalArgumentException("Es duerfen keine leeren Flaschen eingelegt werden!");
        }
        flaschenlager.add(Flasche);

        }

    public void flascheAusgeben() {
        flaschenlager.get(0);
    }

    @Override
    public String toString() {
        return flaschenlager.toString();

    }
}
 

