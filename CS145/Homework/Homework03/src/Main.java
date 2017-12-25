
/**
 * @author Joshua Nelson
 * Copyright (c) Joshua Nelson 2017
 * Exists only to instantiate TimeChecker.java
 */
import java.util.Scanner;

public class Main {
  private static Scanner keyboard;
  
  /** Main method.
   *  ignores param args
   */
  public static void main(String[] args) {
    keyboard = new Scanner(System.in);

    // The following are just examples, they can safely be deleted.

    new TimeChecker("1999-06-10");  // ISO standard
    new TimeChecker("06/13/1999");  // US style date 
    new TimeChecker("31-12-12");    // Canada style date
    new TimeChecker("6/22/1985");   // given test case
    new TimeChecker("9/31/1944");   // given test case; should return day error
    
    new TimeChecker("2/31/1984");   // February date; should print an error
    new TimeChecker("12/12/12");    // ambiguous
    new TimeChecker("121212");      // very ambiguous - timechecker should print warning
    new TimeChecker("12.12.12");    // periods as delimeters
    new TimeChecker("6/5/1985");    // both month and day 1 digit
    new TimeChecker("85/3/4");      // year first, month and day 1 digit
    new TimeChecker("6/5/85");      // shortest delimeted form
    new TimeChecker("6 4 85");      // space delimeters
    new TimeChecker("6 1985 4");    // wacko

    while (true) {
      System.out.println("Enter a date to check.");
      new TimeChecker(keyboard.next());
    }
  }

}
