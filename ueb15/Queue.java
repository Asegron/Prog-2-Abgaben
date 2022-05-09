public interface Queue {
  // Objekt hinten anfuegen
  void addLast(Object o);

  // Entferne das erste Element und gebe eine Referenz darauf zurueck
  Object removeFirst();

  // Das i-te Element zurueckgeben
  Object get(int i);

  // Testen, ob schon Elemente eingefuegt wurden
  boolean empty();

  // Testen, ob noch Elemente einfuegbar sind, d. h. ob das letzte Element schon einen Wert != null
  // hat
  boolean full();

  // Anzahl eingefuegter Elemente
  int size();
}