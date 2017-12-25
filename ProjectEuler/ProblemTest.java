import problems.Problem;

import java.lang.reflect.Field;

class ProblemTest {

    public ProblemTest(int number) throws IllegalArgumentException {

    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static void main(String[] args) {
        int number;

        if (args.length < 1 || !isNumeric(args[0])) {
            System.out.println("Error: not a number. Using 1 as an example.");
            number = 1;
        } else {
            number = Integer.parseInt(args[0]);
        }
        try {
            Class<?> problemClass = Class.forName(String.format("problems.Problem%d", number));
            for (Field field : problemClass.getDeclaredFields()) {
                field.setAccessible(true);
            }
            Problem problem = (Problem) problemClass.newInstance(); // very unsafe casting
            System.out.println(problem.webpage);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

}
