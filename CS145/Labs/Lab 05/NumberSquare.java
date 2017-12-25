import java.util.Scanner;

public class NumberSquare {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    while (true) {
      System.out.println("Type a whole number and I will print it in the form of a square.");
      printSquare(keyboard.next());
    }
  }

  private static void printSquare(String number) {
    if (number.equals("1")) {
      System.out.println("1");
      return;
    }
    for (char c : number.toCharArray()) {
      if (!Character.isDigit(c)) {
        throw new IllegalArgumentException("Must be a positive number");
      }
    }
    if (number.equals("0") || number.contains("-")) {
      throw new IllegalArgumentException("Must be a positive number");
    }

    // " " * number.length() - 2
    String whitespace = new String(new char[number.length() - 2]).replace("\0", " ");

    System.out.println(number);
    for (int i = 1; i < number.length() - 1; i++) {
      System.out.println(String.format("%s%s%s", number.charAt(i), whitespace,
              number.charAt(number.length() - i - 1)));
    }
    System.out.println(new StringBuilder(number).reverse().toString());
  }
}
