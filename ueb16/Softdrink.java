public class Softdrink extends AlkoholfreiesGetraenk {
    private float zuckergehalt;

    public Softdrink(String name, String hersteller, float zuckergehalt) {
        super(name,hersteller);

    }

    public float getZuckergehalt() {
        return zuckergehalt;
    }

    public void setZuckergehalt(float zuckergehalt) {
        Utils.check(zuckergehalt < 0 , 
        " Der Zuckergehalt darf nicht negativ sein!");
        
        this.zuckergehalt = zuckergehalt;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "Zuckergehalt:" + " " + zuckergehalt + " g" + ")";
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