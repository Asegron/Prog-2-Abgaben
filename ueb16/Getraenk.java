public abstract class Getraenk {
    private String name;
    String regexName = "^[a-zA-Z]+$";

    public Getraenk(String name) {
        setName(name);
    }

public String getName() {
    return name;
}

public void setName(String name) {
     Utils.check(name == null || name.trim().isEmpty(),
        "Das Getraenk muss benannt werden!");
     Utils.check(name.matches(regexName) == false,
        "Der Name des Getraenks darf nur Buchstaben enthalten.");

        this.name = name;
    }

    /**
     * @return name
     */
    @Override
    public String toString() {
        return name;
    }

    /* 
    Prüft ob ein Getränk schon vorhanden ist!
    */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Getraenk)) {
            return false;
        }
        Getraenk other = (Getraenk) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        
        }
        return true;
    }    

}
