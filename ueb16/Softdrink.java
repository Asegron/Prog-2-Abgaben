public class Softdrink extends AlkoholfreiesGetraenk {
    private float zuckergehalt;

    public Softdrink(String name, String hersteller, float zuckergehalt) {
        super(name,hersteller);

    }

    public float getZuckergehalt() {
        return zuckergehalt;
    }

    public void setZuckergehalt(float zuckergehalt) {
        this.zuckergehalt = zuckergehalt;
    }

    @Override
    public String toString() {
        return super.toString() + "\t\tZuckergehalt:" + " " + zuckergehalt + " g";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof AlkoholischesGetraenk)) {
            return false;
        }
        return true;
    }
}