public class Bier extends AlkoholischesGetraenk {
    private String brauerei;
    private String regexName = "^[a-zA-Z]+$";

    public Bier(String name, float alkoholgehalt, String brauerei) {
        super(name,alkoholgehalt);

        setBrauerei(brauerei);
    }

    public String getBrauerei() {
        return brauerei;
    }

    public void setBrauerei(String brauerei) {
        Utils.checkName(brauerei == null || brauerei.trim().isEmpty(),
            "Es muss ein Name für die Brauerei eingegeben werden!");
        Utils.checkName(brauerei.matches(regexName) == false,
            "Der Name der Braurei darf nur Buchstaben enthalten!");
            this.brauerei = brauerei;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "Brauerei:" + " " + brauerei + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof Bier)) {
            return false;
        }
        Bier other = (Bier) obj;
        if (brauerei == null) {
            if (other.brauerei != null) {
                return false;
            }
        } else if (!brauerei.equals(other.brauerei)) {
            return false;
        }
        return true;
    }
}