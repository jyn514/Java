import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Logic {
    private static transient String show = "", lastOp = "";
    private static transient TYPE lastTyped = TYPE.NUMBER;
    private static transient BigDecimal current = BigDecimal.ZERO;
    private static final String SUPPORTED = "+-*/^!";

    private Logic() {}

    private enum TYPE {
        NUMBER, OPERATION, OTHER
    }

    @NotNull
    public static String handle(String s) {
        if (isNumeric(s)) {
            if (lastTyped == TYPE.NUMBER) {
                current = current.multiply(BigDecimal.TEN);
                current = current.add(new BigDecimal(s));
                show = current.toPlainString();
            } else if (lastOp.equals("")) {
                current = new BigDecimal(s);
                show = s;
            } else {
                applyLastOp(new BigDecimal(s));
            }
            lastTyped = TYPE.NUMBER;
        } else if (SUPPORTED.contains(s)) {
            lastTyped = TYPE.OPERATION;
            lastOp = s;
            if (!requiresSecondValue(s)) {
                applyLastOp(current);
            }
        } else {
            lastTyped = TYPE.OTHER;
            show = "Unsupported operation";
        }
        return show;
    }

    private static void applyLastOp(BigDecimal s) {
        switch(lastOp) {
            case "+":
                current = current.add(s);
                break;
            case "-":
                current = current.subtract(s);
                break;
            case "*":
                current = current.multiply(s);
                break;
            case "/":
                current = current.divide(s, BigDecimal.ROUND_HALF_EVEN);
                break;
            case "^":
                current = current.pow(s.intValueExact());
                break;
            case "!":
                if (!isInteger(current)) {
                    show = "Domain error: Can only take factorial of integers";
                    return;
                }
                current = new BigDecimal(factorial(current.toBigInteger()));
                break;
            default:
                show = "Well, this shouldn't happen.";
                System.out.printf("Error. Last op is %s, current is %f, show is %s", lastOp, current, show);
                return;
        }
        lastOp = "";
        show = String.valueOf(current);
    }

    private static boolean isInteger(BigDecimal bd) {
            return bd.signum() == 0 || bd.scale() <= 0 || bd.stripTrailingZeros().scale() <= 0;
    }

    private static BigInteger factorial(BigInteger n) {
        if (n.compareTo(BigInteger.ONE) == 0 || n.compareTo(BigInteger.ZERO ) == 0) { return BigInteger.ONE; }
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }

    @Contract("null -> false")
    private static boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }

    @Contract(pure = true)
    private static boolean requiresSecondValue(@NotNull String operator) {
        return !operator.equals("!");
    }
}
