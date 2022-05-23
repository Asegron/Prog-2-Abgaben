public class Wein extends AlkoholischesGetraenk {
    private String weingut;
    private String regexName = "^[a-zA-Z]+$";

    public Wein(String name, float alkoholgehalt, String weingut) {
        super(name,alkoholgehalt);

        this.weingut = weingut;
    }

    public String getWeingut() {
        return weingut;
    }

    public void setWeingut(String weingut) {
        Utils.checkName(weingut == null || weingut.trim().isEmpty(),
            "Es muss ein Name für das Weingut eingegeben werden!");
        Utils.checkName(weingut.matches(regexName) == false,
            "Der Name des Weingutes darf nur Buchstaben enthalten!");
            this.weingut = weingut;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "Weingut:" + " " + weingut + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof Wein)) {
            return false;
        }
        Wein other = (Wein) obj;
        if (weingut == null) {
            if (other.weingut != null) {
                return false;
            }
        } else if (!weingut.equals(other.weingut)) {
            return false;
        }
        return true;
    }
}