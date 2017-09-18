class factors{
	public static void main(String[] args) {
		long n;
//accepts input or uses sample input
		if (args.length==1) {
			n=Long.valueOf(args[0]).longValue();
		}
		else {
			n=144;
			System.out.printf("Using 144 as a sample input.%n");
		}
//corner cases
		if (n==0 || n==1) {
			System.out.printf("%d is not prime and has no factors.%n", n);
		}
		else {
			long div=2;
			java.util.List<Long> factors=new java.util.ArrayList<Long>();
//calculates all factors
			while (div<n) {
				if(n%div==0) {
					factors.add(div);
				}
				div++;
			}
			if (factors.size()!=0) {
				System.out.printf("Factors: ");
				for(long d: factors)
					System.out.printf("%d ", d);
				System.out.printf("%n");
			}
			else {
				System.out.printf("%d is prime.%n", n);
			}
		}
	}
}