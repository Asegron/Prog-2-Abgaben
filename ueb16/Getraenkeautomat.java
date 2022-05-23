import java.util.ArrayList;

public class Getraenkeautomat <T extends Flasche<?>> {
    public String getraenketyp;
    public String automatentyp;
    public static final String Flasche = null;
    public static ArrayList<Flasche<?>> flaschenlager = new ArrayList<Flasche<?>>();
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
        if( (Object)((Flasche<?>) Flasche).get() == null   ) {
            throw new IllegalArgumentException("Es duerfen keine leeren Flaschen eingelegt werden!");
        }
        flaschenlager.add(Flasche);

        }

    public void flascheAusgeben() {
        int index = 0;
        flaschenlager.remove(index);
    }

    @Override
    public String toString() {
        return "Getraenkeautomat: " + name +" | Inhalt: " + flaschenlager.toString();

    }

}

