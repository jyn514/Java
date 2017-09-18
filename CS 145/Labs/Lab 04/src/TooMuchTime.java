
import java.util.Scanner;
public class TooMuchTime {

	static Scanner keyboard = new Scanner(System.in);
	static int seconds;

	public static void main(String[] args) {
		System.out.println("Enter a time in the format \"00:00:00\" and I will give the time in seconds.");
		String time = keyboard.nextLine();
		int timeInSeconds = 0;
		String formattedTime = "";

		String[] parts = time.split(":");

		timeInSeconds += Integer.parseInt(parts[0]) * 3600;
		timeInSeconds += Integer.parseInt(parts[1]) * 60;
		timeInSeconds += Integer.parseInt(parts[2]);

		System.out.println(timeInSeconds);

		System.out.println("Enter a number of seconds to add:");
		seconds = keyboard.nextInt();
		timeInSeconds += seconds;

		formattedTime += timeInSeconds / 3600;
		timeInSeconds %= 3600;
		formattedTime += ":";

		formattedTime += timeInSeconds / 60;
		timeInSeconds %= 60;
		formattedTime += ":";

		formattedTime += timeInSeconds;

		System.out.println(formattedTime);
	}
}
