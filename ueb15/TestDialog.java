import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class TestDialog {
    private Scanner input;
    private NumberCruncher cruncher;

    // Funktion
    private static final int CRUNCHER_ANLEGEN = 1;
    private static final int SUM = 2;
    private static final int SWIRL = 3;
    private static final int DIVIDE = 4;
    private static final int SUBTRACT = 5;
    private static final int AVERAGE = 6;
    private static final int ENDE = 0;

    // Cruncher Art
    private static final int RANDOM_CRUNCHER = 1;
    private static final int CRUNCHER = 2;

    // NumberCruncher Typ
    private static final int ANONYM = 1;
    private static final int TOP_LEVEL = 2;

    private TestDialog() {
        input = new Scanner(System.in);
    }

    /**
     * Hauptschleife des Programms
     */
    private void start() {
        int funktion = -1;
        while (funktion != ENDE) {
            try {
                funktion = einleseFunktion();
                ausfuehreFunktion(funktion);
            } catch (InputMismatchException e) {
                System.err.println(e + ": Funktion ungültig!");
                input.nextLine();
            } catch (RuntimeException e) {
                System.err.println(e);
            } catch (Throwable e) {
                e.printStackTrace(System.out);
            }
        }
    }

    /**
     * Methode zum Auswaehlen der Funktion
     *
     * @return auswahl
     */
    private int einleseFunktion() {

        System.out.println(CRUNCHER_ANLEGEN + ": Cruncher Anlegen; " + SUM + ": Funktion Sum; " + SWIRL
                + ": Funktion Swirl; " + DIVIDE + ": Funktion Divide; " + SUBTRACT + ": Funktion Substract; " + AVERAGE
                + ": Funktion Average; " + ENDE + ": beenden -> ");

        return input.nextInt();

    }

    /**
     * Methode zum ausfuehren der Funktion
     *
     * @param funktion die ausgewaehlte Funktion
     */
    private void ausfuehreFunktion(int funktion) {
        switch (funktion) {
            case CRUNCHER_ANLEGEN:
                anlegeCruncher(funktion);
                break;
            case SUM:
                cruncher.sum();
                break;
            case SWIRL:
                cruncher.swirl();
                break;
            case DIVIDE:
                cruncher.divide();
                break;
            case SUBTRACT:
                cruncher.subtract();
                break;
            case AVERAGE:
                cruncher.average();
                break;
            case ENDE:
                System.out.println("Programmende!");
                break;
            default:
                System.out.println("Falsche Eingabe!");

        }
        System.out.println(java.util.Arrays.toString(cruncher.getNumbers()));
    }

    private void anlegeCruncher(int length) {

        System.out.print("RandomCruncher / zufaellige Werte generieren : " + RANDOM_CRUNCHER + "\n"
                + "Cruncher / Werte selbt eintragen: " + CRUNCHER + "\n" + "-> ");
        int cruncherTyp = input.nextInt();
        
        if(cruncherTyp <=0 || cruncherTyp >2) {
            throw new TestDialogException("Bitte entweder Option 1 oder 2 auswählen!"); 
        
        }
        System.out.println("Wie groß soll das Array sein?");
        length = input.nextInt();
        input.nextLine();
        float[] values = new float[length];

        if (cruncherTyp == RANDOM_CRUNCHER) {
            values = new float[length];
            Random r = new Random();
            for (int i = 0; i < values.length; i++) {
                values[i] = r.nextFloat();
            }
        } else if (cruncherTyp == CRUNCHER) {
            System.out.println("Bitte gebe " + "'" + length + "'" + " Werte ein.");
            values = new float[length];
           
            for (int i = 0; i < values.length; i++) {
            System.out.print(String.format("%d Wert: ", i + 1));
            values[i] = input.nextFloat();
            }

        } else {
            throw new TestDialogException("Typ Ungueltig!");
        }

        System.out.print("NumberCruncherAnonym: " + ANONYM + "\n" + "NumberCruncherTopLevel: " + TOP_LEVEL + "\n" + "-> ");
        int typ = input.nextInt();
        if (typ == ANONYM) {
            this.cruncher = new NumberCruncherAnonym(values);
        } else if (typ == TOP_LEVEL) {
            this.cruncher = new NumberCruncherTopLevel(values);
        } else {
            throw new TestDialogException("Typ ungueltig!");
        }
    }

    public static void main(String[] args) {
        new TestDialog().start();
    }
}

class TestDialogException extends RuntimeException {
    public TestDialogException() {
    }

    public TestDialogException(String msg) {
        super(msg);
    }
}