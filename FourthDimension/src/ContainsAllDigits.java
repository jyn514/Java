import java.util.Map;
import java.util.HashMap;

public class ContainsAllDigits {

	static final Map<Integer, String> bases = createBases();
	static String digits;
	static int base;

	public static void main(String[] args) {
		for (int i : bases.keySet()) {
			base = i;
			digits = bases.get(i);
			int max = (int) Math.pow(10,  digits.length());
			for (int j = max / 10; j < max - 1; j++) {
				if (containsAllMultiples(String.valueOf(j))) {
					System.out.println(j);
				}
			}
			System.out.println(String.format("- end base %d", i));
		}
	}

	public static boolean containsAllMultiples(String s) { // works only for base 10

		if (!containsAlldigits(s)) { //works
			return false;
		}

		String multiple = "";

		for (int i = 1; i <= digits.length(); i++) {
			multiple += s.substring(i - 1, i);
			if (Integer.parseInt(multiple, base) % i != 0) {
				return false;
			}
		}
		return true;
	}

	static Map<Integer, String> createBases() {
		Map<Integer, String> bases = new HashMap<>();
		
		bases.put(2, "1");
		bases.put(3, "12");
		bases.put(4, "123");
		bases.put(5, "1234");
		bases.put(6, "12345");
		bases.put(7, "123456");
		bases.put(8, "1234567");
		bases.put(9, "12345678");
		bases.put(10, "123456789");
		bases.put(11, "123456789A");
		bases.put(12, "1234568789AB");
		
		return bases;
	}
	
	static boolean containsAlldigits(String s) {
		for (int i = 0; i < digits.length(); i++) {
			if (!s.contains(digits.substring(i, i + 1))) {
				return false;
			}
		}
		return true;
	}
}
