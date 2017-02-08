class fibonacci { 
	public static void main(String[] args) {
		int a=0;
		int b=1;
		int t=1;
		int max;
		if (args.length==1) {
			max=(Integer.valueOf(args[0])).intValue();
		}
		else {
			max=10;
		}
		while(t<max){
			int spare=(a+b);
			a=b;
			b=spare;
			t++;
		}
		System.out.printf("Number %d of the Fibonacci sequence is: %d%n", max, a);
	}
}
		