public class Flasche <T extends Getraenk>{
    private T inhalt;
    public void set(T object) { this.inhalt = object; }
    public T get() { return inhalt; }
}


