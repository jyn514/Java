
/**
 * @author Joshua Nelson and Clayton Oney
 * @date 2017-09-19
 */

import java.util.Scanner;

public class BasalMetabolicRateCalculator {

    Scanner keyboard = new Scanner(System.in);
    double height, weight;
    int age;
    String lifestyle;

    BasalMetabolicRateCalculator() {
        height = 0;
        weight = 0;
        age = 0;
        lifestyle = "";
    }

    public static void main(String[] args) {
        while (true) {
            BasalMetabolicRateCalculator b = new BasalMetabolicRateCalculator();
            System.out.println("Welcome to the BMR calculator!\n"
                    + "This will calculate how much energy you burn at rest in one day.");

            System.out.println("Are you male or female? Please enter your sex at birth (m/f)");
            String sex = b.getSex();

            System.out.print("How tall are you in inches?\n");
            b.height = b.keyboard.nextDouble();
            b.keyboard.nextLine(); // hacky

            System.out.println("What is your weight in pounds?");
            b.weight = b.keyboard.nextDouble();
            b.keyboard.nextLine();

            System.out.println("What is your age in years?");
            b.age = b.keyboard.nextInt();
            b.keyboard.nextLine();

            System.out.println("Would you describe your lifestyle as \"Sedentary\",\n"
                    + "\"Somewhat Active\", \"Active\", or \"Highly Active\"?");
            b.lifestyle = b.getLifestyle();

            double BMR;
            if (sex.equals("M")) {
                BMR = b.calculateMaleBMR();
            } else {
                BMR = b.calculateFemaleBMR();
            }

            switch (b.lifestyle) {
            case "SEDENTARY":
                BMR *= 1.20;
                break;
            case "SOMEWHAT ACTIVE":
                BMR *= 1.3;
                break;
            case "ACTIVE":
                BMR *= 1.4;
                break;
            case "HIGHLY ACTIVE":
                BMR *= 1.5;
                break;
            default:
                throw new IllegalStateException();
            }

            System.out.println(String.format("Your BMR is %f calories!\n\n", BMR));
        }
    }

    private double calculateFemaleBMR() {
        return 655 + 4.3 * weight + 4.7 * height - 4.7 * age;
    }

    private double calculateMaleBMR() {
        return 66.0 + 6.3 * weight + 12.9 * height - 6.8 * age;
    }

    private String getSex() {
        String input = keyboard.next().toUpperCase();
        keyboard.nextLine();
        if (!input.equals("M") && !input.equals("F")) {
            System.out.println("Please enter M or F.");
            return getSex();
        }
        return input;
    }

    private String getLifestyle() {
        String input = keyboard.nextLine().toUpperCase();
        if (!input.equals("SEDENTARY") && !input.equals("SOMEWHAT ACTIVE") && !input.equals("ACTIVE")
                && !input.equals("HIGHLY ACTIVE")) {
            System.out.println(
                    "Please enter one of \"Sedentary\",\n" + "\"Somewhat Active\", \"Active\", or \"Highly Active\".");
            return getLifestyle();
        }
        return input;
    }

}
