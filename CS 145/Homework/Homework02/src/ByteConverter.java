import java.util.Scanner;
public class ByteConverter {

	private static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {					
				
		System.out.println("Enter a binary number and I will convert it to decimal.");
		String binary = keyboard.nextLine().trim();
		for (char c : binary.toCharArray()) {
			if (!(c == '0' || c == '1')) {
				throw new IllegalArgumentException("Must be a valid binary number (with no spaces).");
			}
		}
		System.out.println(convertBinaryStringToDecimal(binary));
		
		
		System.out.println("Enter a decimal number and I will convert it to binary.");
		int decimal = keyboard.nextInt();
		System.out.println(convertDecimalToBinaryString(decimal));
	}
	
	private static int convertBinaryStringToDecimal(String x) { 	// Integer.parseInt(x, 2);
		int sum = 0;
		int length = x.length();
		
		for (int i = 0; i < length; i++) {
			if (x.charAt(length - 1 - i) == '1') {
				sum += Math.pow(2, i);
			}
		}
		return sum;
	}
	
	private static String convertDecimalToBinaryString(int x) { 
		StringBuilder binary = new StringBuilder();
		double tempPower;
		
		for (int power = findGreatestPower(x); power >= 0; power--) {
			tempPower = Math.pow(2, power);
			if (x >= tempPower) {
				binary.append("1");
				x -= tempPower;
			} else {
				binary.append("0");
			}
		}
		
		return binary.toString();
	}
	
	private static int findGreatestPower(int x) { // brute force 
		int p = 0;
		while (Math.pow(2, p) <= x) {
			p++;
		}
		return p - 1;
	}

}
