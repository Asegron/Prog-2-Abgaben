import java.util.ArrayList;

public class Getraenkeautomat <T extends Flasche<Getraenk>> {
    public static final String Flasche = null;
    private ArrayList<T> flaschenlager = new ArrayList<T>();
    private int[] kapazitaet;
    private String name = null;
    
    public Getraenkeautomat(int dimension, String name) {
       kapazitaet = new int[dimension];
       this.name = name;
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
        return "Getraenkeautomat: " + name + " | Inhalt: " + flaschenlager.toString();

    }
}
 

