public class StringQueue implements Queue {

  private final String[] strings;

  public StringQueue(int size) {
    if (size <= 0) {
      throw new IllegalArgumentException("Warteschlange muss größer als 0 sein");
    }
    this.strings = new String[size];
  }

  public StringQueue() {
    this(10);
  }

  @Override
  public void addLast(Object o) {
    if (!(o instanceof String)) {
      throw new ClassCastException(
          String.format("%s is not of type String", o.getClass().getName()));
    }
    if (full()) {
      throw new IllegalArgumentException("Warteschlange ist voll");
    }
    strings[size()] = (String) o;
  }

  @Override
  public String removeFirst() {
    if (empty()) {
      throw new IllegalArgumentException("Warteschlange ist leer");
    }
    String firstString = strings[0];
    int index = 0;
    for (int i = index; i < strings.length - 1; i++) {
      if (strings[i] != null) {
        strings[i] = strings[i + 1];
      }
    }
    strings[strings.length - 1] = null;
    return firstString;
  }

  @Override
  public String get(int i) {
    return strings[i];
  }

  @Override
  public boolean empty() {
    return strings[0] == null;
  }

  @Override
  public boolean full() {
    return strings[strings.length - 1] != null;
  }

  @Override
  public int size() {
    int count = 0;
    for (String string : strings) {
      if (string != null) {
        count++;
      }
    }
    return count;
  }
}