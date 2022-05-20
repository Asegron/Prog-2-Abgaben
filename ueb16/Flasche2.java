public class Flasche2 <T extends Getraenk>{
    private T inhalt;
    public void set(T object) { this.inhalt = object; };
    public T get() { return inhalt; } {

    if (inhalt instanceof AlkoholfreiesGetraenk) {
        throw new IllegalArgumentException("Darf keine abstrakte Klasse enthalten");
    }
    if (inhalt instanceof AlkoholischesGetraenk) {
        throw new IllegalArgumentException("Darf keine abstrakte Klasse enthalten");
    }
    if (inhalt instanceof Getraenk) {
        throw new IllegalArgumentException("Darf keine abstrakte Klasse enthalten");
    }
}

}


