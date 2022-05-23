public class Flasche <T extends Getraenk> {
    private T inhalt;
    public String getraenketyp;
    public String automatentyp;
    public void fuellen(T object) { 
        this.inhalt = object; 
    }
    public T get() { 
        return inhalt; 
    }

    public <T extends Getraenk> void leeren() {
        this.inhalt = null;
    }

    @Override
    public String toString() {
        return inhalt.toString();
    }

}
