public class CollatzConjecture {

	public static void main(String[] args) {
		Long x = new Long("1453256527451");
		collatz(x);
	}

	public static void collatz(long x) {
		long count = 0;
		while (x != 1) {
			if (x % 2 == 0) {
				x /= 2;
			} else {
				x = x * 3 + 1;
			}
			System.out.println(x);
			count += 1;
		}
		System.out.println(String.format("\nThe total number of steps is %d", count));
	}
}
