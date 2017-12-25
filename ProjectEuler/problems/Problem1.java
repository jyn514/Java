package problems;

import java.util.Arrays;
import java.util.List;

class Problem1 extends problems.Problem {
    private static final int number = 1;
    private static final String description = "Sum all multiples of 3 and 5 below n.";
    private static final List<Long[]> tests = makeTests();

    private static final long expectTestOne = 23;
    private static final long inputTestOne = 10;
    private static final long expectTestTwo = 233168;
    private static final long inputTestTwo = 1000;


    public Problem1() {
        super(number, tests);
    }

    private static List<Long[]> makeTests() {
        Long[] a = {inputTestOne, expectTestOne};
        Long[] b = {inputTestTwo, expectTestTwo};
        return Arrays.asList(a, b);
    }
}
