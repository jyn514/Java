/*
 * @author Joshua Nelson
 */
import java.util.TreeMap;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class CoinCounterFrontEnd {

	private static Scanner keyboard = new Scanner(System.in);
	
	private static final Map<Long, String> coinNames = makeCoinNames();
	
	private static long originalCoinValue;
	
	private static TreeMap<Long, Long> numberOfCoins = new TreeMap<Long, Long>();

	public static void main(String[] args) {

		while (true) {

			System.out.println("Enter a whole number.\nThe machine will determine a combination of coins.");
			String input = keyboard.next();
			while (!isNumeric(input)) {
				System.out.println("Argument must be an integer greater than or equal to zero.");
				input = keyboard.next();
			}
			originalCoinValue = Long.parseLong(input);
			numberOfCoins = CoinCounter.calculate(originalCoinValue);

			System.out.println(String.format("%d cents in smallest denominations:", originalCoinValue));
			for (Long value : numberOfCoins.descendingKeySet()) {
				System.out.println(String.format("    %d %s", numberOfCoins.get(value), coinNames.get(value)));
			}
		}
	}
	
	private static boolean isNumeric(String s) {  
	    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	}  
	
	private static final Map<Long, String> makeCoinNames() {
		Map<Long,String> coinNames = new HashMap<Long, String>();
		
		coinNames.put((long) 10000, "hundred-dollar bills");
		coinNames.put((long) 5000, "fifty-dollar bills");
		coinNames.put((long) 2000, "twenty-dollar bills");
		coinNames.put((long) 1000, "ten-dollar bills");
		coinNames.put((long) 500, "five-dollar bills");
		coinNames.put((long) 100, "one-dollar bills");
		coinNames.put((long) 25, "quarters");
		coinNames.put((long) 10, "dimes");
		coinNames.put((long) 5, "nickels");
		coinNames.put((long) 1, "pennies");
		
		return coinNames;
	}

}
