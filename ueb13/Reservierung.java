/**
 * Klasse Reservierung, um als Mitarbeiter einen Raum für ein Meeting zu
 */
public class Reservierung {
    private String bemerkung;
    private Uhrzeit beginn;
    private Uhrzeit ende;
    private Mitarbeiter mitarbeiter;
    private Raum raum;

    /**
     * Konstruktor um ein Reservierung-Objekt zu erstellen
     * @param beginn Uhrzeit
     * @param ende Uhrzeit
     */
    public Reservierung(Uhrzeit beginn, Uhrzeit ende) {
        this.beginn = beginn;
        this.ende = ende;

        setBeginn(beginn);
        setEnde(ende);
    }

    /**
     * Reservierung Konstruktor
     * @param mitarbeiter
     * @param raum
     * @param beginn
     * @param ende
     * @param bemerkung
     */
    public Reservierung (Mitarbeiter mitarbeiter, Raum raum, Uhrzeit beginn, Uhrzeit ende, String bemerkung) {
        this(beginn, ende);
        setMitarbeiter(mitarbeiter);
        setRaum(raum);
        setBemerkung(bemerkung);
    }

    /**
     * @return bemerkung
     */
    public String getBemerkung() {
        return bemerkung;
    }

    /**
     * Methode setBemerkung
     * @param bemerkung, darf nicht leer sein
     */
    public void setBemerkung (String bemerkung) {
        Utils.check(bemerkung == null || bemerkung.trim().isEmpty(), 
            "Bemerkung darf nicht leer sein");

        this.bemerkung = bemerkung;
    }

    /**     
     * @return beginn 
     */
    public Uhrzeit getBeginn() {
        return beginn;
    }

    /**
     * @param beginn 
     */
    public void setBeginn(Uhrzeit beginn) {
        this.beginn = beginn;
    }

    /**
     * @param ende 
     */
    public Uhrzeit getEnde() {
        return ende;
    }

    /**     
     * @param ende
     */
    public void setEnde(Uhrzeit ende) {
        this.ende = ende;
    }

    /**     
     * @param mitarbeiter
     */
    public void setMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }

    /**     
     * @param raum
     */
    public void setRaum(Raum raum) {
        this.raum = raum;
        raum.addReservierung(this);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Reservierung)) {
            return false;
        }
        Reservierung other = (Reservierung) obj;
        if (beginn == null) {
            if (other.beginn != null) {
                return false;
            }
        } else if (!beginn.equals(other.beginn)) {
            return false;
        }
        if (bemerkung == null) {
            if (other.bemerkung != null) {
                return false;
            }
        } else if (!bemerkung.equals(other.bemerkung)) {
            return false;
        }
        if (ende == null) {
            if (other.ende != null) {
                return false;
            }
        } else if (!ende.equals(other.ende)) {
            return false;
        }
        return true;
    }

    /**
     * Ausgabe von der Uhrzeit mit Aufruf von toString von Mitarbeiter
     */
    @Override
    public String toString() {
        return mitarbeiter.toString() + " von " + beginn + " bis " + ende + " für " + bemerkung;
    }
}
