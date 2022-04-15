/**
 * Klasse Uhrzeit zum Erstellen der Uhrzeit
 */
public class Uhrzeit {
    private int  stunde;
    private int  minute;

    /**
     * Konstruktor um ein Uhrzeit-Objekt zu erstellen.
     * @param stunde Muss zwischen 00-23 liegen.
     * @param minute Muss zwischen 00-59 liegen.
     */
    public Uhrzeit(int stunde , int minute) {
        setStunde(stunde);
        setMinute(minute);
    }

    /**      
     * @return stunde
     */
    public int getStunde() {
        return stunde;
    }

    /**
     * Aendern der Stunde
     * @param stunde
     */
    public void setStunde(int stunde) {
        Utils.check(stunde <= 0 || stunde >= 23, 
            "Die Stunde muss zwischen 0 bis 24 Uhr Liegen");

        this.stunde    = stunde;
    }

    /**     
     * @return minute
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Aendern der Minute
     * @param minute
     */
    public void setMinute(int minute) {
        Utils.check(stunde <= 0 || stunde >= 59, 
            "Die Minuten müssen zwischen 0 und 59 liegen");

        this.minute = minute;
    }

    /**
     * @return Uhrzeit Stunde : Minute Uhr 
     */
    @Override
    public String toString() {
        if (stunde < 10 && minute > 9) {
            return "0" + stunde + ":" + minute + " Uhr"; 
        } else if(stunde > 9 && minute < 9) {
            return stunde + ":" + "0" + minute + " Uhr";
        } else if(stunde < 9 && minute < 9) {
            return "0" + stunde + ":" + "0" + minute + " Uhr";
        } else {
            return stunde + ":" + minute + " Uhr";
        }
    }

    /**
     * Methode überprüft ob 2 Objekte gleich sind. Minute und Stunde
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Uhrzeit)) {
            return false;
        }
        Uhrzeit other = (Uhrzeit) obj;
        if (minute != other.minute) {
            return false;
        }
        if (stunde != other.stunde) {
            return false;
        }
        return true;
    }
}