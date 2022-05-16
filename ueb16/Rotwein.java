public class Rotwein extends Wein {
    
    public Rotwein(String name, float alkoholgehalt, String weingut) {
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
        if (!(obj instanceof Rotwein)) {
            return false;
        }
        return true;
    }
}