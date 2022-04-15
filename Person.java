/**
 * Oberklasse Person von der die Klasse Mitarbeiter erbt. 
 */
public abstract class Person {
    private  String vorname;
    private  String nachname;
    String regexName = "^[A-Z]+[a-zA-Z]*$";

    /**
     * Person Konstruktor, um ein Person-Objekt zu erstellen
     * @param vorname, darf nicht leer sein
     * @param nachname, darf nicht leer sein
     */
    public Person(String vorname, String nachname) {       
        setVorname(vorname);
        setNachname(nachname);

    }

    /**     
     * @return vorname
     */    
    public String getVorname() {
        return vorname;
    }

    /**
     * Aendern des Vornamen
     * @param vorname, darf nicht leer sein
     */
    public void setVorname(String vorname) {
        Utils.check(vorname == null || vorname.trim().isEmpty(), 
            "Vormane darf nicht leer sein");
        Utils.check(vorname.matches(regexName) == false,
            "Vorname muss mit Großbuchstaben beginnen und mit Kleinbuchstaben auffolgen.");    

        this.vorname = vorname;
    }

    /**     
     * @return nachname
     */
    public String getNachname() {
        return nachname;
    }

    /**
     * Aendern des Nachnamen
     * @param nachname, darf nicht leer sein
     */
    public void setNachname(String nachname) {
        Utils.check(nachname == null || nachname.trim().isEmpty(), 
            "Nachname darf nicht leer sein");
        Utils.check(nachname.matches(regexName) == false,
            "Nachname muss mit Großbuchstaben beginnen und mit Kleinbuchstaben auffolgen.");

        this.nachname = nachname;
    }

    /**
     * @return vorname und nachname
     */
    @Override
    public String toString() {
        return vorname + " " + nachname;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nachname == null) ? 0 : nachname.hashCode());
        result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
        return result;
    }

    /**
     * Methode überprüft ob 2 Objekte gleich sind. Hier Vorname und Nachname
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person other = (Person) obj;
        if (nachname == null) {
            if (other.nachname != null) {
                return false;
            }
        } else if (!nachname.equals(other.nachname)) {
            return false;
        }
        if (vorname == null) {
            if (other.vorname != null) {
                return false;
            }
        } else if (!vorname.equals(other.vorname)) {
            return false;
        }
        return true;
    }    
}