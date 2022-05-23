import java.util.*;

public class GetraenkeautomatDialog{
    public List<Flasche<?>> flascheListe = new ArrayList<>();
    public Getraenkeautomat getraenkeautomat = null;
    private Scanner input = new Scanner(System.in);

    //Konstanten
    private static final int GETRAENKEAUTOMAT_ANLEGEN           =1;
    private static final int GETRAENKEAUTOMATEN_ZURUECKSETZEN   =2;
    private static final int FLASCHE_ERSTELLEN                  =3;
    private static final int FLASCHE_EINLEGEN                   =4;
    private static final int FLASCHE_AUSGEBEN                   =5;
    private static final int ALLE_FLASCHE_AUSGEBEN              =6;
    private static final int GETRAENKEAUTOMAT_AUSGEBEN          =7;
    private static final int ENDE                               =0;
    private static final int BIER                               =1;
    private static final int WEIN                               =2;
    private static final int ROTWEIN                            =3;
    private static final int WEISSWEIN                          =4;
    private static final int WASSER                             =5;
    private static final int SOFTDRINK                          =6;
    private static final int GETRAENKE                          =7;
    private static final int ALKHOLISCHES_GETRAENK              =8;
    private static final int ALKOHOLFREIES_GETRAENK             =9;
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
        System.out.println( GETRAENKEAUTOMAT_ANLEGEN         + ": Getraenkeautomaten anlegen;\n" +
                            GETRAENKEAUTOMATEN_ZURUECKSETZEN + ": Getraenkeautomaten zuruecksetzen;\n" + 
                            FLASCHE_ERSTELLEN                + ": Eine Flasche mit Inhalt erstellen;\n" +
                            FLASCHE_EINLEGEN                 + ": Flasche einlegen;\n"  +
                            FLASCHE_AUSGEBEN                 + ": Die erste Flasche wird aus dem Automaten ausgeben;\n"+
                            ALLE_FLASCHE_AUSGEBEN            + ": Alle existierenden Flaschen werden genannt;\n" +
                            GETRAENKEAUTOMAT_AUSGEBEN        + ": Inhalt des Getraenkeautomaten wird ausgeben;\n" +
                            ENDE                             + ": beenden ->\n");

        return input.nextInt();                   
    }

    /*
     * @param funktion 
     */
    private void ausfuehrenFunktion(int funktion) {
        if (funktion == GETRAENKEAUTOMAT_ANLEGEN) {
            getraenkeautomatErstellen();
        }

        else if (funktion == GETRAENKEAUTOMATEN_ZURUECKSETZEN) {
            this.getraenkeautomat = null;
            System.out.println("Der Getraenkeautomat wurde erfolgreich zurueckgesetzt!");
        }

        else if (funktion == FLASCHE_ERSTELLEN) {
            flascheErstellen();
        }

        else if (funktion == FLASCHE_EINLEGEN){
            if(getraenkeautomat == null) {
                throw new IllegalArgumentException("Es wurde noch kein Getraenkeautomat angelegt!");
            }
            final Flasche<?> flasche = (Flasche<?>) flascheListeeWaehlen(this.flascheListe);
            if(flasche.getraenketyp.equals(getraenkeautomat.getraenketyp)== false && flasche.automatentyp.equals(getraenkeautomat.automatentyp) == false) {

                throw new IllegalArgumentException("Falscher Getraenketyp!");
                
            }
            getraenkeautomat.flascheEinlegen(flasche);
        }

        else if (funktion == FLASCHE_AUSGEBEN) {
            getraenkeautomat.flascheAusgeben();
            System.out.println("Die Flasche " + Getraenkeautomat.flaschenlager.get(0) + "wurde ausgegeben!");
        }

        else if (funktion == ALLE_FLASCHE_AUSGEBEN) {
            if(flascheListe.isEmpty()) {
                throw new IllegalArgumentException("Es wurden noch keine Flaschen erstellt!");
            }
            flascheListe.forEach((t) -> System.out.println(t));
        }

        else if (funktion == GETRAENKEAUTOMAT_AUSGEBEN) {
            if (getraenkeautomat == null) {
                throw new IllegalArgumentException("Es wurde noch kein Getraenkeautomat angelegt!");
            }
            System.out.println(getraenkeautomat);
        }

        else if (funktion == ENDE) {
            System.out.println("Ende");
        }
        
        else {
            System.out.println("Falsche Eingabe!");
        }
    }

    public int einlesenTypInhalt() {
        System.out.println("\n---------------------------------");
        System.out.println("Welchen Typ wollen Sie erstellen?" + "\n" 
                + "\n" + BIER + ": Bier" + "\n" + WEIN + ": Wein" + "\n" + ROTWEIN + ": Rotwein" + "\n" + WEISSWEIN + ": Weisswein" + "\n" +  + WASSER + ": Wasser" 
                + "\n" + SOFTDRINK + ": Softdrink" + "\n");
        System.out.println("---------------------------------");
        System.out.print("\nOption: ");

        return input.nextInt();
    }

    public int einlesenTypAutomat() {
        System.out.println("\n---------------------------------");
        System.out.println("Welchen Typ wollen Sie erstellen?" + "\n" 
                + "\n" + BIER + ": Biere" + "\n" + WEIN + ": Weine" + "\n" + ROTWEIN + ": Rotweine" + "\n" + WEISSWEIN + ": Weissweine" + "\n" +  + WASSER + ": Wasser" 
                + "\n" + SOFTDRINK + ": Softdrinks" + "\n" + GETRAENKE + ": Getraenke" + "\n" + ALKHOLISCHES_GETRAENK + ": Alkoholische Getraenke" + "\n" + ALKOHOLFREIES_GETRAENK + ": Alkoholfreie Getraenke");
        System.out.println("---------------------------------");
        System.out.print("\nOption: ");

        return input.nextInt();
    }

    /**
     * Hilfsmethode Getraenkeautomat erstellen um einen Getraenkeautomaten
     * in die GetraenkeautomatListe einzufügen 
     * 
     * @return Getraenkeautomat
     */
    private Getraenkeautomat getraenkeautomatErstellen() {
        String name;
        int dimension;
        int typ = einlesenTypAutomat();
        input.nextLine();

        System.out.println("Name des Getraenkeautomatens: ");
        name = input.nextLine();
        Utils.checkName(name == null || name.trim().isEmpty(), 
            "Der Getraenkeautomat muss benannt werden!");
        
        System.out.println("Kapazitaet des Getraenkeautomats eingeben!");
        dimension = input.nextInt();
        Utils.check(dimension <= 0,
        "Die Kapazität muss mindestens 1 betragen!");

        if (typ == 1) {
            Getraenkeautomat<Flasche<Bier>> getraenkeautomat = new Getraenkeautomat<Flasche<Bier>>(dimension, name);
            this.getraenkeautomat = getraenkeautomat;
            this.getraenkeautomat.getraenketyp = "Bier";
            this.getraenkeautomat.automatentyp = "AlkoholischesGetraenk";
        }
        if (typ == 2) {
            Getraenkeautomat<Flasche<Wein>> getraenkeautomat = new Getraenkeautomat<Flasche<Wein>>(dimension, name);
            this.getraenkeautomat = getraenkeautomat;
            this.getraenkeautomat.getraenketyp = "Wein";
            this.getraenkeautomat.automatentyp = "AlkoholischesGetraenk";
        }
        if (typ == 3) {
            Getraenkeautomat<Flasche<Rotwein>> getraenkeautomat = new Getraenkeautomat<Flasche<Rotwein>>(dimension, name);
            this.getraenkeautomat = getraenkeautomat;
            this.getraenkeautomat.getraenketyp = "Rotwein";
            this.getraenkeautomat.automatentyp = "AlkoholischesGetraenk";
        }
        if (typ == 4) {
            Getraenkeautomat<Flasche<Weisswein>> getraenkeautomat = new Getraenkeautomat<Flasche<Weisswein>>(dimension, name);
            this.getraenkeautomat = getraenkeautomat;
            this.getraenkeautomat.getraenketyp = "Weisswein";
            this.getraenkeautomat.automatentyp = "AlkoholischesGetraenk";
        }
        if (typ == 5) {
            Getraenkeautomat<Flasche<Wasser>> getraenkeautomat = new Getraenkeautomat<Flasche<Wasser>>(dimension, name);
            this.getraenkeautomat = getraenkeautomat;
            this.getraenkeautomat.getraenketyp = "Wasser";
            this.getraenkeautomat.automatentyp = "AlkoholfreiesGetraenk";
        }
        if (typ == 6) {
            Getraenkeautomat<Flasche<Softdrink>> getraenkeautomat = new Getraenkeautomat<Flasche<Softdrink>>(dimension, name);
            this.getraenkeautomat = getraenkeautomat;
            this.getraenkeautomat.getraenketyp = "Softdrink";
            this.getraenkeautomat.automatentyp = "AlkoholfreiesGetraenk";
        }
        if (typ == 7) {
            Getraenkeautomat<Flasche<Getraenk>> getraenkeautomat = new Getraenkeautomat<Flasche<Getraenk>>(dimension, name);
            this.getraenkeautomat = getraenkeautomat;
            this.getraenkeautomat.automatentyp = "Getraenk";
        }
        if (typ == 8) {
            Getraenkeautomat<Flasche<AlkoholischesGetraenk>> getraenkeautomat = new Getraenkeautomat<Flasche<AlkoholischesGetraenk>>(dimension, name);
            this.getraenkeautomat = getraenkeautomat;
            this.getraenkeautomat.automatentyp = "AlkoholischesGetraenk";
        }
        if (typ == 9) {
            Getraenkeautomat<Flasche<AlkoholfreiesGetraenk>> getraenkeautomat = new Getraenkeautomat<Flasche<AlkoholfreiesGetraenk>>(dimension, name);
            this.getraenkeautomat = getraenkeautomat;
            this.getraenkeautomat.automatentyp = "AlkoholfreiesGetraenk";
        }
        return null;
    }

    private Bier waehleBier() {
     
        String name;
        float alkoholgehalt;
        String brauerei;
        String regexName = "^[a-zA-Z]+$";

        input.nextLine();

        System.out.println(("Name: "));
        name = input.nextLine();
        Utils.checkName(name == null || name.trim().isEmpty(),
        "Das Getraenk muss benannt werden!");
        Utils.checkName(name.matches(regexName) == false,
        "Der Name des Getraenks darf nur Buchstaben enthalten.");

        System.out.println("Alkoholgehalt: ");
        alkoholgehalt = input.nextFloat();
        input.nextLine();
        Utils.check(alkoholgehalt == 0,
        "Das Getraenk ist nicht alkoholisch!");
        Utils.check(alkoholgehalt < 0,
        "Der Alkoholgehalt darf nicht negativ an!");
        Utils.check(alkoholgehalt > 100,
        "der Alkoholgehalt darf nicht hoeher als 100% betragen!");

        System.out.println("Brauerei: ");
        brauerei = input.nextLine();

        return new Bier(name, alkoholgehalt, brauerei);     
    }

    private Wein waehleWein() {
        String name;
        float alkoholgehalt;
        String weingut;
        String regexName = "^[a-zA-Z]+$";

        input.nextLine();

        System.out.println(("Name: "));
        name = input.nextLine();
        Utils.checkName(name == null || name.trim().isEmpty(),
        "Das Getraenk muss benannt werden!");
        Utils.checkName(name.matches(regexName) == false,
        "Der Name des Getraenks darf nur Buchstaben enthalten.");

        System.out.println("Alkoholgehalt: ");
        alkoholgehalt = input.nextFloat();
        input.nextLine();
        Utils.check(alkoholgehalt == 0,
        "Das Getraenk ist nicht alkoholisch!");
        Utils.check(alkoholgehalt < 0,
        "Der Alkoholgehalt darf nicht negativ an!");
        Utils.check(alkoholgehalt > 100,
        "der Alkoholgehalt darf nicht hoeher als 100% betragen!");

        System.out.println("Weingut: ");
        weingut = input.nextLine();

        return new Wein(name, alkoholgehalt, weingut);
    }

    private Rotwein waehleRotwein() {
        String name;
        float alkoholgehalt;
        String weingut;
        String regexName = "^[a-zA-Z]+$";

        input.nextLine();

        System.out.println(("Name: "));
        name = input.nextLine();
        Utils.checkName(name == null || name.trim().isEmpty(),
        "Das Getraenk muss benannt werden!");
        Utils.checkName(name.matches(regexName) == false,
        "Der Name des Getraenks darf nur Buchstaben enthalten.");

        System.out.println("Alkoholgehalt: ");
        alkoholgehalt = input.nextFloat();
        input.nextLine();
        Utils.check(alkoholgehalt == 0,
        "Das Getraenk ist nicht alkoholisch!");
        Utils.check(alkoholgehalt < 0,
        "Der Alkoholgehalt darf nicht negativ an!");
        Utils.check(alkoholgehalt > 100,
        "der Alkoholgehalt darf nicht hoeher als 100% betragen!");

        System.out.println("Weingut: ");
        weingut = input.nextLine();

        return new Rotwein(name, alkoholgehalt, weingut);

    }

    private Weisswein waehleWeisswein() {
        String name;
        float alkoholgehalt;
        String weingut;
        String regexName = "^[a-zA-Z]+$";

        input.nextLine();

        System.out.println(("Name: "));
        name = input.nextLine();
        Utils.checkName(name == null || name.trim().isEmpty(),
        "Das Getraenk muss benannt werden!");
        Utils.checkName(name.matches(regexName) == false,
        "Der Name des Getraenks darf nur Buchstaben enthalten.");

        System.out.println("Alkoholgehalt: ");
        alkoholgehalt = input.nextFloat();
        input.nextLine();
        Utils.check(alkoholgehalt == 0,
        "Das Getraenk ist nicht alkoholisch!");
        Utils.check(alkoholgehalt < 0,
        "Der Alkoholgehalt darf nicht negativ an!");
        Utils.check(alkoholgehalt > 100,
        "der Alkoholgehalt darf nicht hoeher als 100% betragen!");

        System.out.println("Weingut: ");
        weingut = input.nextLine();

        return new Weisswein(name, alkoholgehalt, weingut);
    }
    private Wasser waehleWasser() {

        String name;
        String hersteller;
        String quelle;
        String regexName = "^[a-zA-Z]+$";

        input.nextLine();

        System.out.println(("Name: "));
        name = input.nextLine();
        Utils.checkName(name == null || name.trim().isEmpty(),
        "Das Getraenk muss benannt werden!");
        Utils.checkName(name.matches(regexName) == false,
        "Der Name des Getraenks darf nur Buchstaben enthalten.");

        System.out.println(("Hersteller: "));
        hersteller = input.nextLine();
        Utils.checkName(name == null || name.trim().isEmpty(),
        "Das Getraenk muss benannt werden!");
        Utils.checkName(name.matches(regexName) == false,
        "Der Name des Getraenks darf nur Buchstaben enthalten.");

        System.out.println(("Quelle: "));
        quelle = input.nextLine();
        Utils.checkName(name == null || name.trim().isEmpty(),
        "Die Quelle muss benannt werden!");
        Utils.checkName(name.matches(regexName) == false,
        "Die Quelle des Getraenks darf nur Buchstaben enthalten.");

        return new Wasser(name, hersteller, quelle);
    }

    private Softdrink waehleSoftdrink() {

        String name;
        String hersteller;
        float zuckergehalt;
        String regexName = "^[a-zA-Z]+$";

        input.nextLine();

        System.out.println(("Name: "));
        name = input.nextLine();
        Utils.checkName(name == null || name.trim().isEmpty(),
        "Das Getraenk muss benannt werden!");
        Utils.checkName(name.matches(regexName) == false,
        "Der Name des Getraenks darf nur Buchstaben enthalten.");

        System.out.println(("Hersteller: "));
        hersteller = input.nextLine();
        Utils.checkName(name == null || name.trim().isEmpty(),
        "Der Hersteller des Getraenks muss benannt werden!");
        Utils.checkName(name.matches(regexName) == false,
        "Der Hersteller des Getraenks darf nur Buchstaben enthalten.");

        System.out.println("Zuckergehalt: ");
        zuckergehalt = input.nextFloat();
        Utils.check(zuckergehalt < 0,
        "Der Zuckergehalt darf nicht negativ an!");

        return new Softdrink(name, hersteller, zuckergehalt);
    }

    /* Erstellt eine Flasche mit eingegebenem Inhalt
    /  Dieser Inhalt wird in eine Flasche gefüllt und
    /  in die flascheListe eingefügt.
    */
    private void flascheErstellen() {
        
        int typ = einlesenTypInhalt();
 
        if( typ == 1) {
            Flasche<Bier> flasche = new Flasche<Bier>();
            flasche.getraenketyp = "Bier";
            flasche.automatentyp = "AlkoholischesGetraenk";
            flasche.fuellen(waehleBier());
            flascheListe.add(flasche);
            System.out.println("Eine Flasche vom Typ Bier wurde erstellt!");
        }
        if( typ == 2) {
            Flasche<Wein> flasche = new Flasche<Wein>();
            flasche.getraenketyp = "Wein";
            flasche.automatentyp = "AlkoholischesGetraenk";
            flasche.fuellen(waehleWein());
            flascheListe.add(flasche);
            System.out.println("Eine Flasche vom Typ Wein wurde erstellt!");
        }
        if( typ == 3) {
            Flasche<Rotwein> flasche = new Flasche<Rotwein>();
            flasche.getraenketyp = "Wein";
            flasche.automatentyp = "AlkoholischesGetraenk";
            flasche.fuellen(waehleRotwein());
            flascheListe.add(flasche);
            System.out.println("Eine Flasche vom Typ Rotwein wurde erstellt!");
        }
        if( typ == 4) {
            Flasche<Weisswein> flasche = new Flasche<Weisswein>();
            flasche.getraenketyp = "Wein";
            flasche.automatentyp = "AlkoholischesGetraenk";
            flasche.fuellen(waehleWeisswein());
            flascheListe.add(flasche);
            System.out.println("Eine Flasche vom Typ Weisswein wurde erstellt!");
        }
        if( typ == 5) {
            Flasche<Wasser> flasche = new Flasche<Wasser>();
            flasche.getraenketyp = "Wasser";
            flasche.automatentyp = "AlkoholfreiesGetraenk";
            flasche.fuellen(waehleWasser());
            flascheListe.add(flasche);
            System.out.println("Eine Flasche vom Typ Wasser wurde erstellt!");
        }
        if( typ == 6) {
            Flasche<Softdrink> flasche = new Flasche<Softdrink>();
            flasche.getraenketyp = "Softdrink";
            flasche.automatentyp = "AlkoholfreiesGetraenk";
            flasche.fuellen(waehleSoftdrink());
            flascheListe.add(flasche);
            System.out.println("Eine Flasche vom Typ Softdrink wurde erstellt!");
        }
    }

    /**
     * Funkt. zum Anzeigen und Auswählen einer Flasche
     * @param flascheListe
     * @return Flasche1
     */
    private Object flascheListeeWaehlen(final List<Flasche<?>> flascheListe) {
        System.out.println("Waehle eine Flasche aus aus!");
        
        for (int i = 0; i < flascheListe.size(); i++) {
            System.out.println( i+1 + ": " +  flascheListe.get(i));
        }
        int index = input.nextInt() -1 ;
        return flascheListe.get(index);
    }
    
    /**
     * Mainmethode
     */
    public static void main(String[] args) {
        new GetraenkeautomatDialog().start();
    }
}        