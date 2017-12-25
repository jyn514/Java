import java.util.Scanner;
import java.util.Random;

public class Game {
	private static Scanner keyboard = new Scanner(System.in);
	private static Random rand = new Random();
	private static final String[] actions = new String[] { "rock", "paper", "scissors" };

	public static void main(String[] args) {
		System.out.println("Welcome to Rock Paper Scissors. Best two out of three?");
		do {
			play();
			System.out.println("Play again? (yes/no)");
		} while (keyboard.nextLine().equalsIgnoreCase("yes"));
		System.out.println("Goodbye!");
	}

	private static void play() {
		int turns = 0;
		int playerWins = 0;
		int computerWins = 0;
		while (turns < 3) {
			switch (turn()) {
			case 1:
				playerWins++;
				break;
			case -1:
				computerWins++;
				break;
			default:
				break;
			}
			System.out.println(String.format("Player has won %d times and the computer has won %d times.", playerWins,
					computerWins));
			turns++;
		}
		if (playerWins < computerWins) {
			System.out.println("The Computer Wins!");
		} else if (playerWins != computerWins) {
			System.out.println("The Player Wins!");
		} else {
			System.out.println("Tie!");
		}

	}

	private static int turn() { // returns -1 for player loss, 1 for player win, 0 for draw
		System.out.println("Enter 'rock', 'paper', or 'scissors'.");
		String in = keyboard.nextLine().toLowerCase();
		if (in.equals("rock") || in.equals("paper") || in.equals("scissors")) {
			return winTurn(in);
		} else {
			System.out.println("Not valid input; the computer wins.");
			return -1;
		}
	}

	private static int winTurn(String playerAction) {
		String computerAction = actions[rand.nextInt(3)];
		if (computerAction.equals(playerAction)) {
			return 0;
		} else if ((computerAction.equals("rock") && playerAction.equals("scissors")
				|| computerAction.equals("scissors") && playerAction.equals("paper")
				|| computerAction.equals("paper") && playerAction.equals("rock"))) {
			return -1; // computer win
		} else {
			return 1; // player must have won
		}
	}
}
