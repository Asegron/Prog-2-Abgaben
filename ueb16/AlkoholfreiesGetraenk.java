public abstract class AlkoholfreiesGetraenk extends Getraenk {
    private String hersteller;
    private String regexName = "^[a-zA-Z]+$";

    public AlkoholfreiesGetraenk(String name, String hersteller) {
        super(name);

        setHersteller(hersteller);
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        Utils.checkName(hersteller == null || hersteller.trim().isEmpty(),
            "Es muss ein Hersteller angegeben werden!");
        Utils.checkName(hersteller.matches(regexName) == false,
            "Der Name des Herstellers darf nur aus Buchstaben bestehen!");
            this.hersteller = hersteller;
    
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof AlkoholfreiesGetraenk)) {
            return false;
        }
        AlkoholfreiesGetraenk other = (AlkoholfreiesGetraenk) obj;
        if (hersteller == null) {
            if (other.hersteller != null) {
                return false;
            }
        } else if (!hersteller.equals(other.hersteller)) {
            return false;
        }
        return true;
    }
}