import java.util.*;

public class GetraenkeautomatDialog{
    private List<Getraenkeautomat<Flasche<Getraenk>>> getraenkeautomatList = new ArrayList<>();
    //private List<Raum> raumList = new ArrayList<T>();

    private Scanner input = new Scanner(System.in);

    //Konstanten
    private static final int GETRAENKEAUTOMAT_ANLEGEN           =1;
    private static final int FLASCHE_ERSTELLEN                  =2;
    private static final int FLASCHE_FUELLEN                    =3;
    private static final int FLASCHE_LEEREN                     =4;
    private static final int FLASCHE_EINLEGEN                   =5;
    private static final int FLASCHE_AUSGEBEN                   =6;
    private static final int INHALT_GETRAENKEAUTOMAT_AUSGEBEN   =7;
    private static final int ALLE_GETRAENKEAUTOMATEN_AUSGEBEN   =8;
    private static final int ENDE                               =0;

    /**
     * IllegalArgumentException = Parameter werden üperprüft 
     * InputMismatchException   = Buchstabe bei Zahl oder umgekehrt /Fehlermeldung
     * Exception fängt Alles ab zb NULL Pointer
     * Schluckt die Fehlermeldung
     * funktion = einlesenFunktion();   Wartet auf eingegebene Zahl 
     * ausfuehrenFunktion(funktion); Wenn Zahl eingegeben wird Funktionsschleife gestartet
     */
    public void start() {
        int funktion = -1;

        while (funktion != ENDE) {
            try {
                funktion = einlesenFunktion();
                ausfuehrenFunktion(funktion);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e);
            }
            catch(InputMismatchException e) {
                System.out.println(e);
                input.nextLine();
            }
            catch (Exception e) {
                System.out.println("Fehler: " + e);
                e.printStackTrace(System.out);
            }
        }
    }

    /**
     * Hier werden die Optionen ausgegeben
     */
    private int einlesenFunktion() {
        System.out.println( GETRAENKEAUTOMAT_ANLEGEN         + ": Getraenkeautomaten anlegen; " + 
                            FLASCHE_ERSTELLEN                + ": Flasche erstellen: " +
                            FLASCHE_FUELLEN                  + ": Flasche mit Inhalt füllen: " +
                            FLASCHE_LEEREN                   + ": Inhalt einer Flasche leeren: " +
                            FLASCHE_EINLEGEN                 + ": Flasche einlegen; "  +
                            FLASCHE_AUSGEBEN                 + ": Flasche wird ausgegeben;" +
                            INHALT_GETRAENKEAUTOMAT_AUSGEBEN + ": Inhalt des Getraenkeautomats ausgeben;"+
                            ALLE_GETRAENKEAUTOMATEN_AUSGEBEN + ": Inhalt aller Getraenkeautomaten ausgeben; " +
                            ENDE                             + ": beenden -> ");

        return input.nextInt();                   
    }

    /**
     * Methode ausführenFunktion arbeitet die Befehle ab
     * Prüft auf gültige Funktion und ob Raum/Mitarbeiter angelegt wurden
     * Keine Reservierung ohne Mitarbeiter/Raum möglich
     * @param funktion 
     */
    private void ausfuehrenFunktion(int funktion) {
        if (funktion == GETRAENKEAUTOMAT_ANLEGEN) {
            getraenkeautomatList.add(getraenkeautomatErstellen());
        }

        //if(funktion == FLASCHE_EINLEGEN){
            //getraenkeautomatList.getraenkeautomatListeWaehlen();
       // }

        else if(funktion == FLASCHE_AUSGEBEN ) {

        }

        else if (funktion == ALLE_GETRAENKEAUTOMATEN_AUSGEBEN) {
            getraenkeautomatList.forEach(System.out::println);
        }

        else if(funktion == INHALT_GETRAENKEAUTOMAT_AUSGEBEN) {
            Object gausgewaehlterAutomat = ((Object) getraenkeautomatList).getraenkeautomatListeWaehlen();
            System.out.println((ausgewaehlterAutomat));
        }

        else if (funktion == ENDE) {
            System.out.println("Ende");
        }
        
        else {
            System.out.println("Falsche Eingabe!");
        }
    }

    /**
     * Hilfsmethode Getraenkeautomat erstellen um einen Getraenkeautomaten
     * in die GetraenkeautomatListe einzufügen
     * 
     * @return Getraenkeautomat
     */
    private Getraenkeautomat<Flasche<Getraenk>> getraenkeautomatErstellen() {
        String name;
        int dimension;

        input.nextLine();

        System.out.println("Name des Getraenkeautomatens: ");
        name = input.nextLine();
        Utils.checkName(name == null || name.trim().isEmpty(), 
            "Der Getraenkeautomat muss benannt werden!");
        System.out.println("Kapazitaet des Getraenkeautomats eingeben!");
        dimension = input.nextInt();
        Utils.check(dimension <= 0,
        "Die Dimension muss mindestens 1 betragen!");

        return new Getraenkeautomat<>(dimension, name);
    }

    //private void flascheAusgeben() {
        //final Getraenkeautomat getraenkeautomat = (Getraenkeautomat) getraenkeautomatListeWaehlen(this.getraenkeautomatList);
        //getraenkeautomat.Flasche.leeren();
   //}


    /**
     * Funkt. zum Anzeigen und Auswählen eines Getraenkeautomats
     * @param getraenkeautomatList
     * @return Getraenkeautomat
     */
    private Object getraenkeautomatListeWaehlen(final List getraenkeautomatList) {
        System.out.println("Wähle einen Getraenkeautomaten aus!");
        
        for (int i = 0; i < getraenkeautomatList.size(); i++) {
            System.out.println( i+1 + ": " +  getraenkeautomatList.get(i));
        }
        int index = input.nextInt() -1 ;
        return (Object)getraenkeautomatList.get(index);
    }
    
    /**
     * Mainmethode
     */
    public static void main(String[] args) {
        new GetraenkeautomatDialog().start();
    }
}        