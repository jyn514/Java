import java.util.Scanner;

/**
 * 
 * @author Joshua
 * 1. In general when is it more appropriate to use a 'for loop'?
 * 		When the value will be discarded once the loop is finished.
 */
public class TriangleMaker {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter the size of your triangle.");
		int size = keyboard.nextInt();
		System.out.println();
		
		System.out.println(make(size));
		
		keyboard.close();
		System.out.println("Quitting.");
	}
	
	public static String make(int max) {
		StringBuilder triangle = new StringBuilder();
		
		for (int i = 1; i <= max; i++) {
			triangle.append(repeat('*', i));
			triangle.append('\n');
		}
		for (int i = max - 1; i > 0; i--) {
			triangle.append(repeat('*', i));
			triangle.append('\n');
		}
		
		return triangle.toString();
	}
	
	public static String repeat(char c, int length) {
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < length; i++) {
			result.append(c);
		}
		
		return result.toString();
	}
}
