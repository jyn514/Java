import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ShapeFrontEnd {
	public static final String instructions;
	private transient static String input;
	
	static {
		StringBuilder i = new StringBuilder();
		i.append("Enter 1 to add a shape\n");
		i.append("Enter 2 to remove a shape\n");
		i.append("Enter 3 to print current shapes\n");
		i.append("Enter 4 to quit");
		instructions = i.toString();
	}
	
	/**
	 * @param args is ignored
	 */
	public static void main(String[] args) {
		final BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		final List<Shape> shapes = new ArrayList<>();
		int in = 0;
		
		System.out.println("Welcome to the Shape Collector!");
		System.out.println(instructions);
		
		try {
		while (in < 1 || in > 4) {
			switch((int) getNumber(keyboard, 1)) {
			
			case 1:
				System.out.println("What shape would you like to add? Choices: Rectangle, Circle, Triangle");
				switch(getShape(keyboard)) {
				case "rectangle":
					System.out.println("Please enter a height follow by a length.");
					shapes.add(new Rectangle(getNumber(keyboard), getNumber(keyboard)));
					break;
				case "circle":
					System.out.println("Please enter a radius.");
					shapes.add(new Circle(getNumber(keyboard)));
					break;
				case "triangle":
					System.out.println("Please enter a base and a height");
					shapes.add(new Triangle(getNumber(keyboard), getNumber(keyboard)));
					break;
				default:
					System.out.println("This shouldn't happen either. Bug bug buggy!");
				}
			case 2:
				break;
			case 3:
				print(shapes);
				break;
			case 4: 
				System.exit(0);
				break;
			default:
				System.out.println("Please enter a number between 1 and 4.");
			}
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static String getShape(BufferedReader r) throws IOException {
		input = r.readLine().trim().toLowerCase();
		if (!(input.equals("rectangle") || input.equals("circle") || input.equals("triangle"))) {
			System.out.println("Please enter 'Rectangle', 'Circle', or 'Triangle'");
			return getShape(r);
		}
		return input;
	}
	
	private static float getNumber(BufferedReader r, int maxSize) throws IOException {
		input = r.readLine().trim();
		if ((maxSize > 0 && input.length() > maxSize) || !isNumeric(input)) {
			System.out.printf("Please enter a number less than %d digits long.", maxSize);
			return getNumber(r, maxSize);
		} else {
			return Float.parseFloat(input);
		}
	}
	
	private static float getNumber(BufferedReader r) throws IOException {
		return getNumber(r, 0);
	}
	
	private static boolean isNumeric(String s) {
		return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	}
	
	private static <T> void print(List<T> l) {
		for (T t : l) {
			System.out.println(t);
		}
	}

}
