package phonebook;

public class PhoneEntry {

  @Override
  public String toString() {
    return "{name='" + name + '\'' + ", number='" + number + '\'' + '}';
  }

  private final String name;
  private final String number;

  public PhoneEntry(String name, String number) {
    this.name = name;
    this.number = number;
  }

  public String getName() {
    return name;
  }
}
