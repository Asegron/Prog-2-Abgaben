import java.util.*;

public class Raum {
    private  int geb;
    private  int etage;
    private  int raum;
    protected List<Reservierung> reservierung;

    /**
     * Raum Konstruktor um eine Raum-Objekt zu erstellen
     * @param geb, muss > 0 sein
     * @param raum, muss > 0 sein
     */
    public Raum (int geb, int etage, int raum) {
        Utils.check(geb < 0, 
            "Gebäude ungültig");
        Utils.check(raum < 0, 
            "Raum ungültig");

        this.geb = geb;
        this.etage = etage;
        this.raum = raum;

        reservierung = new ArrayList<>();

        setGeb(geb);
        setEtage(etage);
        setRaum(raum);
    }

    /**
     * Methode addReservierung, um eine Reservierung der Liste hinzu zu fügen
     * @param reservierung
     */
    public void addReservierung(Reservierung reservierung) {
        this.reservierung.add(reservierung);
    }

    /**
     * Reservierung aus der Liste wählen
     * @param index
     * @return Reservierung
     */
    public Reservierung getReservierung(int index) {
        return this.reservierung.get(index);
    }

    /**
     * Methode um die Anzahl der gespeicherten Reservierungen auszugeben
     * @return anzahl der Reservierungen
     */
    public int getAnzahlReservierungen() {
        return reservierung.size();
    }

    /**
     * 
     * @return geb
     */
    public int getGeb() {
        return geb;
    }

    /**
     * @param geb 
     */
    public void setGeb(int geb) {
        this.geb = geb;
    }

    /**
     * 
     * @return etage
     */
    public int getEtage() {
        return etage;
    }

    /**
     * @param etage 
     */
    public void setEtage(int etage) {
        this.etage = etage;
    }

    /**
     * 
     * @return raum
     */
    public int getRaum() {
        return raum;
    }

    /**
     * @param raum
     */
    public void setRaum(int raum) {
        this.raum = raum;
    }

    /** 
     * toString Methode, zur aufbereiteten Ausgabe des Raums
     * Ausgabe bsp: "18-0.1"
     */
    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Raum %d-%d.%d", geb, etage, raum));
        reservierung.forEach(reservierung -> stringBuilder.append("\ngebucht von " + reservierung));
        return stringBuilder.toString();
    }

    /**
     * Methode überprüft ob 2 Objekte gleich sind.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Raum)) {
            return false;
        }
        Raum other = (Raum) obj;
        if (etage != other.etage) {
            return false;
        }
        if (geb != other.geb) {
            return false;
        }
        if (raum != other.raum) {
            return false;
        }
        return true;
    }

}
