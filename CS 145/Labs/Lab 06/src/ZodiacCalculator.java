/**
 * @author Joshua Nelson and Samyu Comandur 
 */

import java.util.Scanner;

public class ZodiacCalculator {

	public static void main(String[] args) {
		int month, day;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter your numeric month and birthday, respectively.");
		// TODO: take it either any order

		while (true) {
			month = keyboard.nextInt(); // delimeter can be any whitespace character: space, newline, tab, etc.
			day = keyboard.nextInt();

			if (!dateExists(month, day)) {
				System.out.println(String.format("Month %s and day %s is not a valid date.", month, day));
			} else {
				String zodiacSign = calculate(convert(month, day));
				System.out.println(String.format("You are a %s!", zodiacSign));

			}
		}

	}

	private static boolean dateExists(int month, int day) { // allows Feb. 29th since we don't know the year
		if (month > 12 || day > 31 || month == 0 || day == 0 || (month == 2 && day == 30) || (hasThirtyDays(month) && day == 31)) {
			return false;
		}
		return true;
	}

	private static int convert(int month, int day) { // last two digits are always day, beginning is month
		return month * 100 + day;
	}

	private static String calculate(int converted) {
		String zodiacSign;
		if (converted < 120 || converted > 1222) {
			zodiacSign = "Capricorn";
		} else if (converted < 220) {
			zodiacSign = "Aquarius";
		} else if (converted < 321) {
			zodiacSign = "Pisces";
		} else if (converted < 421) {
			zodiacSign = "Aries";
		} else if (converted < 521) {
			zodiacSign = "Taurus";
		} else if (converted < 621) {
			zodiacSign = "Gemini";
		} else if (converted < 723) {
			zodiacSign = "Cancer";
		} else if (converted < 823) {
			zodiacSign = "Leo";
		} else if (converted < 923) {
			zodiacSign = "Virgo";
		} else if (converted < 1023) {
			zodiacSign = "Libra";
		} else if (converted < 1122) {
			zodiacSign = "Scorpio";
		} else {
			zodiacSign = "Sagittarius";
		}
		return zodiacSign;
	}

	private static boolean hasThirtyDays (int month) {
		return (month == 2 || month == 4 || month == 6 || month == 9 || month == 11);
	}
}
