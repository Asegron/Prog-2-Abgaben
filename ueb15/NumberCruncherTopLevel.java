public class NumberCruncherTopLevel extends NumberCruncherAbstrakt{

    /**
    * Konstruktor der Klasse NumberCruncherTopLevel
    */
    public NumberCruncherTopLevel(float [] values) {
        
       super(values);
    }
  

    /**
     * Ruft die Top-Level-Klasse Sum auf.
     */
    public void sum() {
        new Sum().crunch(getNumbers());
    }

    /**
     * Ruft die Top-Level-Klasse Swirl auf.
     */
     public void swirl() {
        new Swirl().crunch(getNumbers());
    }

    /**
     * Ruft die Top-Level-Klasse Divide auf.
     */
    public void divide() {
        new Divide().crunch(getNumbers());
    }

    /**
     * Ruft die Top-Level-Klasse Subtract auf.
     */
    public void subtract() {
        new Subtract().crunch(getNumbers());
    }

    /**
     * Ruft die Top-Level-Klasse Average auf.
     */
    public void average() {
        new Average().crunch(getNumbers());
    }

}