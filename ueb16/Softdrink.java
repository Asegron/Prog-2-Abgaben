public class Softdrink extends AlkoholfreiesGetraenk {
    private String zuckergehalt;
    private String regexName = "^[a-zA-Z0-9_.-]*$";

    public Softdrink(String name, String hersteller, String zuckergehalt) {
        super(name,hersteller);

    }

    public String getZuckergehalt() {
        return zuckergehalt;
    }

    public void setZuckergehalt(String zuckergehalt) {
        Utils.checkName(zuckergehalt == null || zuckergehalt.trim().isEmpty(),
            "Es muss ein Zuckergehalt für den Softdrink angegeben werden!");
        Utils.checkName(zuckergehalt.matches(regexName) == false,
            "Der Zuckergehalt muss aus Buchstaben und Zahlen bestehen!");
            this.zuckergehalt = zuckergehalt;
    }

    @Override
    public String toString() {
        return super.toString() + "\t\tZuckergehalt:" + " " + zuckergehalt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof Softdrink)) {
            return false;
        }
        Softdrink other = (Softdrink) obj;
        if (zuckergehalt == null) {
            if (other.zuckergehalt != null) {
                return false;
            }
        } else if (!zuckergehalt.equals(other.zuckergehalt)) {
            return false;
        }
        return true;
    }
}