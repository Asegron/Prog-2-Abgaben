public class Weisswein extends Wein {
    
    public Weisswein (String name, float alkoholgehalt, String weingut) {
        super(name,alkoholgehalt,weingut);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof Weisswein )) {
            return false;
        }
        return true;
    }
}