public class Wasser extends AlkoholfreiesGetraenk {
    private String quelle;
    private String regexName = "^[a-zA-Z]+$";

    public Wasser(String name, String hersteller, String quelle) {
        super(name,hersteller);
        
        setQuelle(quelle);

    }

    public String getQuelle() {
        return quelle;
    }

    public void setQuelle(String quelle) {
        Utils.checkName(quelle == null || quelle.trim().isEmpty(),
            "Es muss ein Name für die Quelle eingegeben werden!");
        Utils.checkName(quelle.matches(regexName) == false,
            "Der Name der Quelle darf nur Buchstaben enthalten!");
            this.quelle = quelle;
    }

    @Override
    public String toString() {
        return super.toString() + "Quelle:" + " " + quelle + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof Wasser)) {
            return false;
        }
        Wasser other = (Wasser) obj;
        if (quelle == null) {
            if (other.quelle != null) {
                return false;
            }
        } else if (!quelle.equals(other.quelle)) {
            return false;
        }
        return true;
    }
}