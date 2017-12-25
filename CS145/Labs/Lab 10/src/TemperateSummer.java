import java.util.Scanner;

/**
 * @date 2017-09-28
 * @author Joshua
 * @questions
 * 		1. Are arrays able to change in size?
 * 			No, they are of immutable length.
 * 		2. What is the last valid index of an array, given the length?
 * 			length - 1
 */
public class TemperateSummer {

	static Scanner keyboard = new Scanner(System.in);
	
	TemperateSummer() {
		new TemperateSummer(10);
	}
	
	TemperateSummer(int days) {
		calculate(days);
	}
	
	private void calculate(int max) {
		float[] days = new float[max];
		float sum = 0;
		for (int i = 0; i < max; i++) {
			System.out.println("Day " + (i + 1));
			float temp = keyboard.nextFloat();
			days[i] = temp;
			sum += temp;
		}
		
		float average = sum / max;
		System.out.println("The average temperature over the 10 days was " + average);
		System.out.println("The days that were above average were:");
		
		for (int i = 0; i < max; i++) {
			if (days[i] > average) {
				System.out.println(String.format("Day %d with %f", i + 1, days[i]));
			}
		}
	}
	
	public static void main(String[] args) {
		int days = 10;
		System.out.println("This temperature tester program will find the temperatures that are greater than average. ");
		System.out.println("How many days would you like to enter? [default: 10]");
		String in = keyboard.nextLine();
		if (isNumeric(in)) {
			days = Integer.parseInt(in);
		}
		System.out.println(String.format("Please enter a temperature for the following %d days:", days));
		
		new TemperateSummer(days);
		
		System.out.println("Quitting.");
		keyboard.close();
	}
	
	public static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");
	}

}
