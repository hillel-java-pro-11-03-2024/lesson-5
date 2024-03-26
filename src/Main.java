import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import phonebook.PhoneBook;
import phonebook.PhoneEntry;

public class Main {

  public static void main(String[] args) {
    System.out.println("Part 1.");
    long stringFound = countOccurance(genStringList(200), "Java");
    System.out.println("From list with 200 items we receive " + stringFound + " times Java string.");
    System.out.println("========================================================");

    System.out.println("Part 2.");
    int[] inputArray = {1, 2, 3, 4, 5};
    List<Integer> convertedList = convert(inputArray);
    System.out.println("Converted inputArray: " + convertedList);
    System.out.println("========================================================");

    System.out.println("Part 3.");
    List<Integer> inputList = genIntegerList(50);
    System.out.println("Unique digits in inputList: " + findUnique(inputList));
    System.out.println("========================================================");

    System.out.println("Part 4 **.");
    Map<String, Integer> calculatedMap = calcOccurance(genStringList(200));
    System.out.println(calculatedMap);
    System.out.println("========================================================");

    System.out.println("Part 4 ***.");
    System.out.println(findOccurance(genStringList(200)));
    System.out.println("========================================================");

    System.out.println("Part 0 phonebook.");
    PhoneBook phoneBook = new PhoneBook();
    phoneBook.add(new PhoneEntry("Vitaliy", "+34 252 656 8486"));
    phoneBook.add(new PhoneEntry("Vitaliy", "+38 067 8888 8888"));
    phoneBook.add(new PhoneEntry("Test name", "+34 545 484 8756"));

    System.out.println(phoneBook.find("Vitaliy"));
    System.out.println(phoneBook.find("Test name"));
    System.out.println();
    System.out.println(phoneBook.findAll("Vitaliy"));
    System.out.println();
    System.out.println(phoneBook.find("Mark"));

  }

  private static List<StringRecord> findOccurance(List<String> source) {
    return source.stream()
        .collect(Collectors.groupingBy(str -> str, Collectors.counting()))
        .entrySet()
        .stream()
        .map(entry -> new StringRecord(entry.getKey(), entry.getValue()))
        .toList();
  }

  private static List<Integer> findUnique(List<Integer> sourceList) {
    return sourceList.stream()
        .distinct()
        .toList();
  }

  private static List<Integer> convert(int[] sourceArray) {
    return Arrays.stream(sourceArray)
        .boxed()
        .toList();
  }

  private static Map<String, Integer> calcOccurance(List<String> source) {
    Map<String, Integer> calculatedMap = new HashMap<>();
    source.forEach(
        str -> calculatedMap.compute(str, (key, value) -> value == null ? 1 : value + 1)
    );
    return calculatedMap;
  }

  private static long countOccurance(List<String> randomList, String findStr) {
    return randomList.stream()
        .filter(a -> a.equals(findStr))
        .count();
  }

  private static List<String> genStringList(int strCount) {
    List<String> dict = List.of(
        "Java", "C++", "Perl", "Basic", "Pascal", "Assembler", "Python", "JavaScript");
    Random random = new Random();
    List<String> list = new ArrayList<>(strCount);
    for (int i = 0; i < strCount; i++) {
      list.add(dict.get(random.nextInt(dict.size())));
    }
    return list;
  }

  private static List<Integer> genIntegerList(int intCount) {
    Random random = new Random();
    List<Integer> list = new ArrayList<>(intCount);
    for (int i = 0; i < intCount; i++) {
      list.add(random.nextInt(20));
    }
    return list;
  }

}
