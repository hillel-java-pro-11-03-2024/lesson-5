package phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

  private final List<PhoneEntry> phoneDict = new ArrayList<>();

  public void add(PhoneEntry phone) {
    phoneDict.add(phone);
  }

  public PhoneEntry find(String name) {
    return phoneDict.stream()
        .filter(record -> record.getName().equals(name))
        .findFirst()
        .orElse(null);
  }

  public List<PhoneEntry> findAll(String name) {
    return phoneDict.stream()
        .filter(record -> record.getName().equals(name))
        .distinct()
        .toList();
  }

}
