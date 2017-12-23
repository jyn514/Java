class Fibonacci {
	public static void main(String[] args) {
		long a = 0, b = 1, max, spare;
		int t = 1;
		if (args.length == 1) {
			max = (Integer.valueOf(args[0])).intValue();
            if (max > 94) {
                System.out.println("Numbers after 94 overflow "
                 + "the Java long type. Using 10 as a sample value.");
                max = 10;
            } else if (max < 0) {
                System.out.println("Refusing to calculate negative value. "
                + "Using 10 as a sample value.");
                max = 10;
            }
		}
		else {
			max = 10;
		}
		while(t++<max){
			spare = a + b;
			a = b;
			b = spare;
		}
		System.out.printf("Number %d of the Fibonacci sequence is: %d%n", max, a);
	}
}

