public interface NumberCruncher {
    /**
    * Summiert die Elemente des Arrays paarweise von links nach rechts auf und speichert den neuen
    * Wert in dem jeweiligen rechten Datenfeld. D.h.: a[1] = a[0] + a[1]; a[2] = a[1] + a[2]
    */
    void sum ();

    /** 
    * Führt n zufällige Vertauschungen der Datenfelder durch; 
    * n ist durch die Länge des float-Arrays gegeben 
    */
    void swirl();

    /** 
    * Teilt die n/2 größten Werte im Array durch die n/2 kleinsten und speichert den neuen Wert
    * im Datenfeld des jeweils größeren Wertes. D.h. der größte Wert wird durch den Kleinsten geteilt. 
    * Der Zweitgrößte durch den Zweitkleinsten usw.
    */
    void divide();

    /**
     * Subtrahiert die Elemente des Arrays paarweise von links nach rechts auf und 
     * speichert den neuen Wert in dem jeweils rechten Datenfeld
     */
    void subtract();

    /**
     * Bestimmt den Durchschnitt aller Werte im Array und speichert 
     * den Durchschnittswert im Datenfeld mit dem größten Wert.
     */
    void average();

    /**
     * Fuehrt die gegebene Operationen auf der Werte-Array durch.
     * @param operation
     */
    void crunch(String [] operation);
    
    /**
     * Gibt die Werte-Array zurueck
     * @return
     */
    float[] getNumbers();
}