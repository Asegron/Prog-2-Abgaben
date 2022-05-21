import java.util.*;

public class GetraenkeautomatDialog{
    private List<Getraenkeautomat<Flasche<Getraenk>>> getraenkeautomatList = new ArrayList<>();
    private List<Raum> raumList = new ArrayList<T>();
    private Uhrzeit uhrzeit1;
    private Uhrzeit uhrzeit2;

    private Scanner input = new Scanner(System.in);

    //Konstanten
    private static final int GETRAENKEAUTOMAT_ANLEGEN    =1;   
    private static final int AUSGEBEN                   =2;
    private static final int ENDE                       =0;

    /**
     * IllegalArgumentException = Parameter werden üperprüft 
     * InputMismatchException   = Buchstabe bei Zahl oder umgekehrt /Fehlermeldung
     * Exception fängt ALles bsp NULL Pointer
     * Schluckt die Fehlermeldung
     * funktion = einlesenFunktion();   Wartet auf eingegebene Zahl 
     * ausfuehrenFunktion(funktion); Wenn Zahl eingeǵeben wird Funktionsschleife gestartet
     */
    public void start() {
        int funktion = -1;

        while (funktion != ENDE) {
            try {
                funktion = einlesenFunktion();
                ausführenFunktion(funktion);
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
        System.out.println( GETRAENKEAUTOMAT_ANLEGEN     + ": Getraenkeautomaten anlegen; " + 
                            AUSGEBEN                + ": Reservierungen ausgeben; " +   
                            ENDE                    + ": beenden -> ");

        return input.nextInt();                   
    }

    /**
     * Methode ausführenFunktion arbeitet die Befehle ab
     * Prüft auf gültige Funktion und ob Raum/Mitarbeiter angelegt wurden
     * Keine Reservierung ohne Mitarbeiter/Raum möglich
     * @param funktion 
     */
    private void ausführenFunktion(int funktion) {
        if (funktion == GETRAENKEAUTOMAT_ANLEGEN) {
            getraenkeautomatList .add(GetraenkeautomatErstellen()));
        }


        else if (funktion == RESERVIERUNG_ANLEGEN) {
            Utils.check(mitarbeiterList.isEmpty() && raumList.isEmpty(), 
                "Bitte legen Sie zuerst einen Mitarbeiter und einen Raum an.");
            Utils.check(mitarbeiterList.isEmpty(),
                "Bitte legen Sie zuerst einen Mitarbeiter an.");
            Utils.check(raumList.isEmpty(),
                "Bitter legen Sie zuerst einen Raum an.");

            reservieren();
        }

        else if (funktion == AUSGEBEN) {
            raumList.forEach(System.out::println);
        }

        else if (funktion == ENDE) {
            System.out.println("Ende");
        }
        
        else {
            System.out.println("Falsche Eingabe!");
        }
    }

    /**
     * Hilfsmethode Mitarbeiter erstellen um einen Mitarbeiter 
     * in die MitarbeiterListe einzufügen
     * 
     * @return Mitarbeiter
     */
    private Getraenkeautomat<Flasche<Getraenk>> getraenkeautomatErstellen() {
        String getraenketyp;
        String name;
        input.nextLine();

        System.out.println("Name des Getraenkeautomatens: ");
        name = input.nextLine();
        Utils.check(name == null || vorname.trim().isEmpty(), 
            "Der Getraenkeautomat muss benannt werden!");
        System.out.println("Nachname: ");
        getraenketyp = input.nextLine();
        Utils.check(nachname == null || nachname.trim().isEmpty(), 
            "Nachname darf nicht leer sein");
        Utils.check(nachname.matches(regexName) == false,
            "Nachname muss mit einem Großbuchstaben beginnen und mit Kleinbuchstaben auffolgen.");    

  
        return new Getraenkeautomat<Getraenk, name>;
    }

    /**
     * Hilfsmethode Raum erstellt Raum für RaumListe
     * 
     * @return Raum
     */
    private Raum raumErstellen() {
        int geb;
        int raum;
        int etage;

        System.out.println("Raum für das Meeting bestimmen ");

        System.out.print("Gebäude wählen: ");
        geb = input.nextInt();
        input.nextLine();
        Utils.check(geb < 0, 
            "Gebäude ungültig");

        System.out.print("Etage wählen: ");
        etage = input.nextInt();
        input.nextLine();
        
        System.out.print("Raum wählen: ");
        raum = input.nextInt();
        input.nextLine();
        Utils.check(raum < 0, 
            "Raum ungültig");   

        return new Raum(geb, etage, raum);
    }
    
    /**
     * Hilfsmethode reservieren um eine Reservierung anzulegen.
     */
    private void reservieren() {
        String bemerkung;
        int beginnStunde;
        int endeStunde; 
        int beginnMinute;
        int endeMinute;

        final Mitarbeiter mitarbeiter = (Mitarbeiter) mitarbeiterListeWaehlen(this.mitarbeiterList);
        final Raum raum = (Raum) raumListeWaehlen(this.raumList);
        input.nextLine();

        System.out.print("Bemerkung hinzufügen: ");
        bemerkung = input.nextLine();
        Utils.check(bemerkung == null || bemerkung.trim().isEmpty(), 
            "Bemerkung darf nicht leer sein");

        System.out.print("Uhrzeit: Beginn der Reservierung: ");
        System.out.print("Stunde angeben: ");
        beginnStunde = input.nextInt();
        input.nextLine();
        Utils.check(beginnStunde <= 0 || beginnStunde >= 23, 
            "Die Stunde muss zwischen 0 bis 24 Uhr liegen");

        System.out.print("Minute angeben: ");
        beginnMinute = input.nextInt();
        input.nextLine();
        Utils.check(beginnMinute <= 0 || beginnMinute >= 59, 
            "Die Minuten müssen zwischen 0 und 59 liegen");

        uhrzeit1 = new Uhrzeit(beginnStunde, beginnMinute);

        System.out.print("Uhrzeit: Ende der Reservierung: ");
        System.out.print("Stunde angeben: ");
        endeStunde = input.nextInt();
        input.nextLine();
        Utils.check(endeStunde <= 00 || endeStunde >= 23, 
            "Die Stunde muss zwischen 0 und 24 liegen");

        System.out.print("Minute angeben: ");
        endeMinute = input.nextInt();
        input.nextLine();
        Utils.check(endeMinute <= 0 || endeMinute >= 59, 
            "Die Minuten müssen zwischen 0 und 59 liegen");

        uhrzeit2 = new Uhrzeit(endeStunde, endeMinute);

        mitarbeiter.reserviere(raum, uhrzeit1, uhrzeit2, bemerkung);
    }
    
    /**
     * Methode zum anzeigen und auswählen des Raumes
     * @param raumListe
     * @return Raum
     */
    private Object raumListeWaehlen(final List <Raum> list) {
        System.out.println("Wähle einen Raum aus");
        
        for (int i = 0; i < list.size(); i++) {
            System.out.println( i+1 + ": " + list.get(i)); 
        }
        int index = input.nextInt() -1;
        return list.get(index);
    }

    /**
     * Funkt. zum anzeigen und auswählen eines Mitarbeiters
     * @param mitarbeiterList
     * @return Mitarbeiter
     */
    private Object mitarbeiterListeWaehlen(final List <Mitarbeiter> list) {
        System.out.println("Wähle einen Mitarbeiter aus");
        
        for (int i = 0; i < list.size(); i++) {
            System.out.println( i+1 + ": " +  list.get(i));
        }
        int index = input.nextInt() -1 ;
        return list.get(index);
    }
    
    /**
     * Mainmethode
     */
    public static void main(String[] args) {
        new GetraenkeautomatDialog().start();
    }
}        