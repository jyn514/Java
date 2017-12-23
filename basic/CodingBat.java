package logic;

import java.util.List;

public class CodingBat {
	public int loneSum(int a, int b, int c) {
		int sum = 0;
		for (int i : filterUnique(new int[] { a, b, c })) {
			sum += i;
		}
		return sum;
	}

	public int luckySum(int a, int b, int c) {
		int[] nums = new int[] { a, b, c };
		int sum = 0;
		for (int i : nums) {
			if (i == 13) {
				return sum;
			}
			sum += i;
		}
		return sum;
	}

	public List<Integer> doubling(List<Integer> nums) {
		nums.replaceAll(n -> n * 2);
		return nums;
	}

	public int makeChocolate(int small, int big, int goal) {
		int onlySmall = goal - big * 5;
		while (onlySmall < 0) {
			onlySmall += 5;
		}
		if (onlySmall > small) {
			return -1;
		}

		return onlySmall;
	}

	public List<Integer> rightDigit(List<Integer> nums) {
		nums.replaceAll(n -> lastDigit(n));
		return nums;
	}

	private String filter(String original, char badChar) {
		StringBuilder result = new StringBuilder();
		for (char c : original.toCharArray()) {
			if(c != badChar) {
				result.append(c);
			}
		}
		return result.toString();
	}
	
	private int lastDigit(int n) {
		String s = String.valueOf(n);
		return Integer.parseInt(s.substring(s.length() - 1));
	}

	private String repeat(String s, int n) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < n; i++) {
			result.append(s);
		}
		return result.toString();
	}

	private int difference(int a, int b) {
		return Math.abs(a - b);
	}

	private int naiveRound(int n) {
		if (n % 10 >= 5) {
			n += 10;
		}
		return n - n % 10;
	}

	private int[] filterUnique(int[] nums) {
		int newIndex = 0;
		int[] result = new int[nums.length];
		for (int oldIndex = 0; oldIndex < nums.length; oldIndex++) {
			if (count(nums, nums[oldIndex]) == 1) {
				result[newIndex] = nums[oldIndex];
				newIndex++;
			}
		}
		return result;
	}

	private int count(int[] nums, int n) {
		int c = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == n) {
				c++; // ;)
			}
		}
		return c;
	}

	private int max(int[] nums) {
		int m = 0;
		for (int i : nums) {
			if (i > m) {
				m = i;
			}
		}
		return m;
	}

	private int min(int[] nums, int max) {
		int m = max;
		for (int i : nums) {
			if (i < m) {
				m = i;
			}
		}
		return m;
	}

	private int sum(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			count += nums[i];
		}
		return count;
	}
}
