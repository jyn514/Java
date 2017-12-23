import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CountryConverter {

  private static final Path codes = Paths.get(".").toAbsolutePath().resolve("codes.txt").normalize();
  private static final String FOUR_SPACES = "    ";
  private static final Map<String, String> COUNTRIES = makeCountries();

  public static void main(String[] args) {
    if (COUNTRIES == null) {
        throw new IllegalStateException("No countries loaded!");
    }
    Scanner keyboard = new Scanner(System.in);
    String input;
    String upper;
    boolean found = false;

    do {
      System.out.println("Enter a 3 letter code to look up, or type 'quit' to exit.");
      input = keyboard.nextLine();
      upper = input.toUpperCase();

      if (COUNTRIES.containsKey(upper)) {
        System.out.println(COUNTRIES.get(upper));
        found = true;
      } else {
        for (String key : COUNTRIES.keySet()) {
          if (COUNTRIES.get(key).contains(input)) {
            System.out.println(key);
            found = true;
          }
        }
      }
      if (!found) {
        System.out.println(input + " is neither a valid country code nor the official name of a United Nations member.");
      }
    } while (!upper.equals("QUIT"));

   keyboard.close();
  }

  private static final Map<String, String> makeCountries() {
    Map<String, String> countries = new HashMap<>();
    List<String> raw;
    try {
      raw = Files.readAllLines(codes);
      raw.remove(0);
      for (String line : raw) {
        String[] temp = line.split(FOUR_SPACES); // temp[0] = fullName; temp[1] = countryCode
        countries.put(temp[1], temp[0]); // countries.put(countryCode, fullName);
      }
      return countries;

    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;

  }

}
