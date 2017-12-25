import java.util.Scanner;
import java.util.Random;

public class CoinSimulator {

	public static void main(String[] args) {
		while (true) {
			Scanner keyboard = new Scanner(System.in);
			Random rand = new Random();
			System.out.println("Welcome to the coin simulator! Enter a number of coins to flip.");
			int coins = keyboard.nextInt();
			int heads = 0;
			int tails = 0;
			for (int i = 0; i < coins; i++) {
				if (rand.nextInt(2) == 1) {
					heads++;
					System.out.println("Flipped and got heads.");
				} else {
					tails++;
					System.out.println("Flipped and got tails.");
				}
			}
			System.out.println(
					String.format("After flipping %d coins, there were %d heads and %d tails.", coins, heads, tails));
		}
	}

}
