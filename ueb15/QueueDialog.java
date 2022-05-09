import java.util.Scanner;

public class QueueDialog {

  private Queue queue;

  public void readInput() {
    try (final Scanner scanner = new Scanner(System.in)) {
      while (true) {
        final String input = readString(scanner, "Command: ").toLowerCase().trim();
        if (queue == null
            && (!input.equalsIgnoreCase("erstellen") && !input.equalsIgnoreCase("stop"))) {
          System.out.println("Es wurde noch keine Warteschlange mit *erstellen* erstellt!");
          continue;
        }
        executeCommand(scanner, input);
      }
    }
  }

  private void executeCommand(final Scanner scanner, String input) {
    try {
      switch (input) {
        case "erstellen":
          if (queue != null) {
            final String mode =
                readString(
                        scanner, "Soll die aktuelle Warteschlange überschrieben werden? (Ja/Nein)")
                    .toLowerCase();
            if (mode.equals("nein") || !mode.equals("ja")) {
              System.out.println("Lager wird nicht überschrieben");
              break;
            }
          }
          final String mode =
              readString(scanner, "Art der Warteschlange (String, Person): ").trim().toLowerCase();
          final int size = readInt(scanner, "Größe des Lagers: ");
          if (mode.equals("string")) {
            queue = new StringQueue(size);
          } else if (mode.equals("person")) {
            queue = new PersonQueue(size);
          } else {
            System.out.println("Falsche Eingabe");
          }
          break;
        case "ausgeben":
          print(queue);
          break;
        case "entfernen":
          System.out.println(queue.removeFirst() + " wurde entfernt");
          break;
        case "anlegen":
          if (queue instanceof StringQueue) {
            queue.addLast(readString(scanner, "Neuer String: "));
          } else {
            queue.addLast(
                new Person(readString(scanner, "Vorname: "), readString(scanner, "Nachname: ")));
          }
          break;
        case "stop":
          System.exit(0);
        default:
          System.out.printf("Der Befehl %s existiert nicht\n", input);
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }

  /**
   * @param scanner das genutzte Scanner Objekt
   * @param promtMessage
   * @return der eingegebene String
   */
  private String readString(final Scanner scanner, final String promtMessage) {
    System.out.print(promtMessage);
    return scanner.nextLine();
  }

  /**
   * Wartet bis der Nutzer eine Nummer eingegeben hat
   *
   * @param scanner
   * @param promtMessage
   * @return die eingegebene Nummer
   */
  private int readInt(final Scanner scanner, final String promtMessage) {
    System.out.print(promtMessage);
    while (!scanner.hasNextInt()) {
      scanner.nextLine();
      System.out.print(promtMessage);
    }
    final int number = scanner.nextInt();
    scanner.nextLine();
    return number;
  }

  public void print(Queue q) {
    if (q.empty()) {
      System.out.println("Warteschlange ist leer");
    }
    for (int i = 0; i < q.size(); i++) {
      Object object = q.get(i);
      if (object == null) {
        break;
      }
      System.out.println(object);
    }
  }

  public static void main(String... args) {
    new QueueDialog().readInput();
  }
}
