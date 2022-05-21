public class Flasche <T extends Getraenk> {
    private T inhalt;
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
