public abstract class AlkoholischesGetraenk extends Getraenk {
    private float alkoholgehalt;

    public AlkoholischesGetraenk(String name, float alkoholgehalt) {
        super(name);

        setAlkoholgehalt(alkoholgehalt);
    }

    public float getAlkoholgehalt() {
        return alkoholgehalt;
    }

    public void setAlkoholgehalt(float alkoholgehalt) {
        Utils.check(alkoholgehalt == 0,
         "Das Getraenk ist nicht alkoholisch!");
         Utils.check(alkoholgehalt < 0,
         "Der Alkoholgehalt darf nicht negativ an!");
         Utils.check(alkoholgehalt > 100,
         "der Alkoholgehalt darf nicht hoeher als 100% betragen!");
        this.alkoholgehalt = alkoholgehalt;
    
    }

    @Override
    public String toString() {
        return super.toString()  + "\t\tAlkoholgehalt:" + " " + alkoholgehalt +  "%" ;

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