package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public abstract class Problem {


    public final String webpage;
    public final List<Map<Object, Object>> testCases;

    public Problem(int i, List<? extends Object[]> tests) {
        webpage = String.format("https://projecteuler.net/problem=%d", i);
        testCases = makeTestResults((List<Object[]>) tests); // so much unsafe casting
    }

    private static List<Map<Object, Object>> makeTestResults(List<Object[]> tests) {
        List<Map<Object, Object>> tempList = new ArrayList<>();

        for (Object[] s : tests) {
            Map<Object, Object> tempMap = new HashMap<>();
            tempMap.put(s[0], s[1]);
            tempList.add(tempMap);
        }
        return tempList;
    }

}
