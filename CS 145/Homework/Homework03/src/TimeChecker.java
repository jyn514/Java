public class TimeChecker {

  private static final String delimeters = "[\\/.\\- ]"; // literal '/', '.', '-', or ' '

  private int day, month, year;
  private int digitCount = 0, delimeterCount = 0;

  private String input, initialInput;
  private String format = "", errorMessage = "";   // format is a string of form mmddyyyy or similar

  private boolean monthEstablished = false, dayEstablished = false, yearEstablished = false;

  private String[] stringComponents = new String[3];
  private int[] components = new int[3];

  /**
   * @author Joshua Nelson
   * @date 2017-12-09
   * Copyright (c) Joshua Nelson 2017
   *
   *       TimeChecker start class
   *
   *       If valid, prints "[the date] is a valid date of form [some format]!"
   *       If invalid, prints a string explaining why it's invalid
   *
   *       Supports most forms of dates, including:
   *       mm/dd/yyyy
   *       m/d/yyyy
   *       m/d/yy
   *       yy/m/d
   *       yyyy-mm-dd (ISO Standard format)
   *       mm.dd.yy
   *       m d yy
   *       m yyyy d (no, I didn't plan for that)
   *       mmddyyyy
   *       mmddyy
   *       ddmmyy
   *       ddmmyyyy
   *
   *       Does not support:
   *       leap years when in form mmddyy (because that's a screwy date system
   *       anyway)
   *
   */

  public TimeChecker(String s) {

    input = s;
    initialInput = s;

    initialValidation();

    if (errorMessage != "") {
      System.out.print(errorMessage);
      return;

    }
    if (delimeterCount == 0) { // only numbers e.g. 10181999, this is most difficult to parse
      if (digitCount != 6) {
        // TODO
        errorMessage += ("Only six-digit dates can be missing delimeters.\n");
        return;
      } else {
        findSixDigitDateWithoutDelimeters();
      }
    } else {
      findDelimetedDate();
    }

    if (errorMessage != "") {
      System.out.print(errorMessage);
      return;
    }

    validate(); // checks that dates make sense

    if (errorMessage != "") {
      System.out.print(errorMessage);
    } else {
      System.out.println(String.format("%s is a valid date of form %s.", initialInput, format));
    }
  }

  // should ONLY be run if code does not have delimeters
  private void findSixDigitDateWithoutDelimeters() throws NumberFormatException {

    System.out.println(
        "Assuming year is two digits, format is mmddyy, and year <= 2017 "
        + String.format("for string %s; not a recommended format.", initialInput));

    format = "mmddyy";
    month = Integer.parseInt(input.substring(0, 2));
    day = Integer.parseInt(input.substring(2, 4));
    year = Integer.parseInt(input.substring(4));

    if (year > 17) {
      year += 1900;
    } else {
      year += 2000;
    }
  }

  private void findDelimetedDate() throws IllegalArgumentException {

    // don't yet know which bits are which
    stringComponents = input.split(delimeters);
    components[0] = Integer.parseInt(stringComponents[0]);
    components[1] = Integer.parseInt(stringComponents[1]);
    components[2] = Integer.parseInt(stringComponents[2]);

    for (int i = 0; i < 3; i++) {

      if (stringComponents[i].length() == 4 || components[i] > 31
          || (dayEstablished && monthEstablished)) { // year

        if (yearEstablished) {
          errorMessage += String.format(
              "Illegal date, year established and %s is too long to be a month or day.\n",
              stringComponents[i]);

        } else {
          year = components[i];
          yearEstablished = true;
          format += repeat(stringComponents[i].length(), 'y');
        }

      } else if (components[i] > 12 || monthEstablished) { // day

        if (dayEstablished) {
          errorMessage += String.format("Day established, and %s too long to be month.\n",
              stringComponents[i]);
        } else {
          day = components[i];
          dayEstablished = true;
          format += repeat(stringComponents[i].length(), 'd');
        }

      } else { // must be month
        // note - this can't be else-if, because it is a finally block
        if (monthEstablished) {
          errorMessage += "Improperly placed delimeters.\n";
        }
        month = components[i];
        monthEstablished = true;
        format += repeat(stringComponents[i].length(), 'm');
      }
    }
  }

  private void validate() throws IllegalArgumentException {
    if (month > 12) {
      errorMessage += "There are only 12 months in a year.\n";

    } else if (day > 31) {
      errorMessage += "No month has more than 31 days\n";

    } else if (month == 0 && day == 0) {
      errorMessage += "Cannot have a month or day with value '0'.\n";

    } else if (hasThirtyDays(month) && day == 31) {
      errorMessage += String.format("Month %s only has 30 days.\n", month);

    } else if (month == 2) { // February
      if (!isLeapYear(year) && day == 29) {
        errorMessage += "February only has 29 days on leap years.\n";

      } else if (day >= 30) {
        errorMessage += "February never more than 29 days.\n";
      }
    }
  }

  private void initialValidation() throws IllegalArgumentException {

    for (char c : input.toCharArray()) {
      if (Character.isDigit(c)) {
        digitCount++;
      } else if (String.valueOf(c).matches(delimeters)) {
        delimeterCount++;
      } else {
        throw new IllegalArgumentException("Contains illegal characters.");
      }
    }

    if (delimeterCount != 0 && delimeterCount != 2) {
      errorMessage += "Wrong number of delimeters.";
    }
  }

  private static boolean hasThirtyDays(int month) {
    return (month == 4 || month == 6 || month == 9 || month == 11);
  }

  private static boolean isLeapYear(int year) {
    return (year % 4 == 0 && (year % 400 == 0 || !(year % 100 == 0)));
  }

  private static String repeat(int times, char c) {
    return new String(new char[times]).toString().replace('\0', c);
  }
}
