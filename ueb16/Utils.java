public class Utils {
    /**
     * Check Methode, wirft IllegalArgumentException, 
     * falls eine Bedingung nicht erfüllt ist.
     * @param Bedingung 
     * @param msg
     */
    public static void check(boolean bedingung, String msg) {
        if(bedingung)  {
            throw new IllegalArgumentException(msg);
        }
    
}
    public static void checkName(boolean bedingung, String msg) {
        if(bedingung)  {
            throw new NameException(msg);
    }
}

}