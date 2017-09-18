
/**
 * @author Joshua Nelson
 */

import java.util.Scanner;
import java.util.Map;
import java.text.DecimalFormat;
import java.util.HashMap;

public class LongHeavyProgram {
	private static Scanner keyboard = new Scanner(System.in);
	private static double weight, height;
	private static final Map<String, Double> weights = createWeightMap();
	private static final Map<String, Double> heights = createHeightMap();
	private static DecimalFormat twoDecimalPlaces = new DecimalFormat("#.##");

	public static void main(String[] args) {
		System.out.println("Enter a weight in pounds.");
		weight = keyboard.nextDouble();
		if (weight < 0) {
			throw new IllegalArgumentException("Must be a positive number.");
		}
		System.out.println("Enter a height in feet");
		height = keyboard.nextDouble();
		if (height < 0) {
			throw new IllegalArgumentException("Must be a positive number.");
		}

		for (String s : weights.keySet()) {
			System.out.println(String.format("%s lbs is %s %s.", twoDecimalPlaces.format(weight),
					twoDecimalPlaces.format(weights.get(s) * weight), s));
		}
		for (String s : heights.keySet()) {
			System.out.println(String.format("%s feet is %s %s.", twoDecimalPlaces.format(height),
					twoDecimalPlaces.format(heights.get(s) * height), s));
		}
		System.out.println("Goodbye!");

	}

	private static final Map<String, Double> createHeightMap() {
		// maps units to percentage of feet
		Map<String, Double> map = new HashMap<>();
		map.put("meters", .305);
		map.put("hands", 3.0);
		map.put("furlongs", .002);
		map.put("cubits", .667);
		map.put("rack units", 6.857);
		return map;
	}

	private static final Map<String, Double> createWeightMap() {
		// maps various units to percentage of pounds
		Map<String, Double> map = new HashMap<>();
		map.put("kilograms", .0456);
		map.put("stones", .071);
		map.put("slugs", .031);
		map.put("pennyweights", 291.667);
		map.put("grains", 7000.0);
		return map;
	}
}
