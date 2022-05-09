public abstract class NumberCruncherAbstrakt implements NumberCruncher {

    private float[] values;

    
    //Operationen
    protected static final String SUM        = "sum"     ;
    protected static final String SWIRL      = "swirl"   ;
    protected static final String DIVIDE     = "divide"  ;
    protected static final String SUBTRACT   = "subtract";
    protected static final String AVERAGE    = "average" ;
    
    protected static final String MSG_VALUES_LEER = "Bitte geben Sie eine nicht-leere Werte-Array";
    protected static final String MSG_OPERATION_LEER = "Das Operations-Array darf nicht leer sein";


    public NumberCruncherAbstrakt(float[] values) {
        check(values != null && values.length > 0, MSG_VALUES_LEER);
        this.values = values;
    }

    
    /**
     * Methode crunch fuehrt die gegebene Operation auf das values-Array durch
     * @param operations, darf nicht leer sein oder null
     * @throws ILLegalArgumentException bei falscher Eingabe
     */
    public void crunch(String[] operations){
        check(operations != null && operations.length > 0, MSG_OPERATION_LEER);
        for(String operation : operations){
            switch(operation) {
                case SUM:
                    sum();
                break;
                case SWIRL:
                    swirl();
                break;
                case DIVIDE:
                    divide();
                break;
                case SUBTRACT:
                    subtract();
                break;
                case AVERAGE:
                    average();
                break;                  
            }
        }
    }

    /**
     * Gibt das values-Array zurueck
     * 
     * @return values
     */
    public float[] getNumbers(){
        return values;
    }
    private static void check(boolean bedingung, String msg) {
        if(!bedingung)
            throw new RuntimeException(msg);
    }
    
}