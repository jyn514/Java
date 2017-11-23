
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Set;
import java.util.HashSet;

public class GoldbachConjecture {

	static SortedSet<Integer> primes = new TreeSet<>();
	static Set<String> primeSums = new TreeSet<>();
	static Set<Integer> composites = new HashSet<>();
	static int multiple = 2;
	static int max;
	static int traversed;
	
	public static void main(String[] args) {
		max = 100;
		iteratePrimes();
		iterateSums();
		for (String s : primeSums) {
			System.out.println(s);
		}
	}
	
	static void iterateSums() {
		for (int prime : primes) {
			traversed = prime;
			for (int multiplePrime : primes) {
				if (multiplePrime > traversed) {
					primeSums.add(String.format("%d + %d = %d", prime, multiplePrime, prime + multiplePrime));
				}
			}
		}
	}

	static void iteratePrimes() {
		primes.add(multiple);
		sieve(multiple);
		for (int i = 3; i <= max; i += 2) {
			if (!composites.contains(i)) {
				primes.add(i);
				sieve(i);
			}
		}
	}
	
	static void sieve(int i) {
		multiple = i;
		while (multiple < max) {
			composites.add(multiple);
			multiple += i;
		}
	}
	
}
