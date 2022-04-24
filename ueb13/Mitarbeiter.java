/**
 * Unterklasse Mitarbeiter, um einen Mitarbeiter anzulegen
 */
public class Mitarbeiter extends Person{
    private  String email;
    String regexEmail = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    /**
     * Mitarbeiter Konstruktor, um ein Objekt vom Typ Mitarbeiter zu erzeugen
     * @param vorname, darf nicht leer sein extends Person
     * @param nachname, darf nicht leer sein extends Person
     * @param email, darf nicht leer sein 
     */
    public Mitarbeiter(String vorname, String nachname, String email) {
        super(vorname,nachname);
        

        setEmail(email);
    }

    /**
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Aendern der Email
     * @param email
     */
    public void setEmail(String email) {
        Utils.check(email == null || email.trim().isEmpty(), 
            "Email darf nicht leer sein");
        Utils.check(email.matches(regexEmail) == false,
            "Email ist ungültig");
        this.email = email;
    }

    /**
     * toString Methode um das Mitarbeiter-Objekt aufbereitet auszugeben,
     * benutzt toString von Person
     * @return Vorname Nachname (Email)
     */
    @Override
    public String toString() {
        return super.toString()  + " ("+ email + ")";
    }

    /**
     * Methode reserviere, um eine Reservierung vornehmen zu können
     * @param raum
     * @param beginn
     * @param ende
     * @param bemerkung
     */
    public void reserviere (Raum raum ,Uhrzeit beginn, Uhrzeit ende, String bemerkung ) {
        Reservierung reservierung = new Reservierung(beginn, ende);
        reservierung.setBemerkung(bemerkung);
        reservierung.setRaum(raum);
        reservierung.setMitarbeiter(this);        
    }

    /**
     * Methode überprüft ob 2 Objekte gleich sind.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof Mitarbeiter)) {
            return false;
        }
        Mitarbeiter other = (Mitarbeiter) obj;
        if (email == null) {
            if (other.email != null) {
                return false;
            }
        } else if (!email.equals(other.email)) {
            return false;
        }
        return true;
    }    
}
