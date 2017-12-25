import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matrix {
	public static void main(String args[]) {
		Matrix m = new Matrix(Arrays.asList(1, 2, 3, 4, 5),
				Arrays.asList(1, 2, 3, 4, 5),
				Arrays.asList(3, 451, 14, 123, 125));
		System.out.println(m);
		m.add(4);
		System.out.println(m);
		m.add(m);
		System.out.println(m);
		m.subtract(m);
		System.out.println(m);

	}

	final List<List<Integer>> self;
	int x;
	int y;

	private transient List<List<Integer>> tempSelf = new ArrayList<>();

	Matrix() {
		self = tempSelf;
		x = 0;
		y = 0;
	}

	@SafeVarargs
	Matrix(List<Integer>... lists) {
		List<List<Integer>> tempSelf = new ArrayList<>();
		y = lists[0].size();

		for (List<Integer> list : lists) {
			if (list.size() != y) {
				throw new IllegalArgumentException(
						"Illegal Arguments: Arrays of varying sizes");
			}
			tempSelf.add(list);
		}

		self = tempSelf;
		x = self.size();
	}

	Matrix(Matrix m) {

		for (List<Integer> outer : m.self) {
			List<Integer> newOuter = new ArrayList<Integer>();
			for (Integer inner : outer) {
				newOuter.add(inner);
			}
			tempSelf.add(newOuter);
		}
		self = tempSelf;
		x = self.size();
		y = self.get(0).size();
	}

	public void append(List<Integer> l) {
		// remove empty list if present
		if (!self.isEmpty() && self.get(self.size() - 1).isEmpty()) {
			self.remove(self.size() - 1);
		}
		self.add(l);
		x++;
	}

	public void append(Integer... ints) {
		List<Integer> outer = new ArrayList<>();
		for (Integer i : ints) {
			outer.add(i);
		}
		append(outer);
	}

	public void add(int i) {
		for (int h = 0; h < x; h++) {
			List<Integer> current = self.get(h);
			for (int j = 0; j < y; j++) {
				current.set(j, current.get(j) + i);
			}
		}
	}

	public void add(Matrix m) {
		// check dimensions are equal
		if (m.x == x && m.y == y) {
			for (int i = 0; i < x; i++) {
				List<Integer> current = self.get(i);
				List<Integer> newCurrent = m.self.get(i);
				for (int j = 0; j < y; j++) {
					current.set(j, current.get(j) + newCurrent.get(j));
				}
			}
		} else {
			System.out.println("Illegal arguments: Dimensions do not match.");
		}
	}

	public void subtract(int i) {
		add(-i);
	}

	public void subtract(Matrix m) {
		// got to be a better way than copy-pasting
		if (m.x == x && m.y == y) {
			for (int i = 0; i < x; i++) {
				List<Integer> current = self.get(i);
				List<Integer> newCurrent = m.self.get(i);
				for (int j = 0; j < y; j++) {
					current.set(j, current.get(j) - newCurrent.get(j));
				}
			}
		} else {
			System.out.println("Illegal arguments: Dimensions do not match.");
		}
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		for (List<Integer> l : self) {
			for (Integer i : l) {
				result.append(i);
				result.append(' ');
			}
			result.append('\n');
		}
		return result.toString();
	}
}
