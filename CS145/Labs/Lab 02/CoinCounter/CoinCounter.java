
/*
 * @author Joshua Nelson and James Dalton O'Guin
 * 2017-08-31
 * Question 1: What does the mod operator do?
 *     It takes the remainder of integer division
 * Question 2: How can `mod` be used to determine if a number is even or odd?
 *     Find the result of the number `mod` 2. If there is a remainder, it is odd; otherwise, it is even.
 */

import java.util.TreeMap;

public class CoinCounter {

	private static TreeMap<Long, Long> allCoins = new TreeMap<>();
	private static long coinValue;

	public static TreeMap<Long, Long> calculate(long originalCoinValue) {

		allCoins.clear();
		coinValue = originalCoinValue;

		if (coinValue < 0) {
			throw new IllegalArgumentException("Input must be a valid positive integer.");
		}

		add(10000);
		add(5000);
		add(2000);
		add(1000);
		add(500);
		add(100);
		add(25);
		add(10);
		add(5);
		add(1);

		return allCoins;
	}

	private static void add(int value) {
		if (coinValue >= value) {
			allCoins.put((long) value, (long) coinValue / value);
			coinValue %= value;
		}
	}
}
