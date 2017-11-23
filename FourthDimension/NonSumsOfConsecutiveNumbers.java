/**
 * @author Joshua
 * @version 2017-09-03
 */

public class NonSumsOfConsecutiveNumbers {
	
	public static void main(String[] args) {

		for (int i = 0; i < 100000; i+=2) { // for every number between 0 and x
											// odd numbers are always consecutive sums
			if (!sumOfConsectiveNumbers(i)) {
				System.out.println(i);
			}
		}
	}
	
	static boolean sumOfConsectiveNumbers(int x) {
		for (int j = 3; j <= (x / 2); j+=2) {
			if (x % j == 0) {
				return true;
			}
		}
		
		return false;
	}

}
