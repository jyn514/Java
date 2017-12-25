import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class SolutionTest {

  private List<List<Integer>> makeEmptyBoard(int columns, int rows) {
    List<List<Integer>> board = new ArrayList<>();
    for (int x = 0; x < rows; x++) {
      List<Integer> row = new ArrayList<>();
      for (int y = 0; y < columns; y++) {
        row.add(0);
      }
      board.add(row);
    }
    return board;
  }

  private String printBoard(List<List<Integer>> board) {
    StringBuilder result = new StringBuilder();
    for (List<Integer> row : board) {
      for (int i1 : row) {
        result.append(i1);
        result.append(' ');
      }
      result.deleteCharAt(result.length() - 1); // no trailing whitespace
      result.append('\n');
    }
    return result.toString();
  }

  @Test
  public void testInitialiser() {
    Solution solution;
    for (int n = 0; n < 10000; n++) {
      List<List<Integer>> board = makeEmptyBoard(n, n);
      solution = new Solution(0, 'x', n, n, board);
      assertEquals(n, solution.columns);
      assertEquals(n, solution.rows);
      assertEquals(n - 1, solution.lastColumn);
      assertEquals(n - 1, solution.lastRow);
      assertEquals(printBoard(board), solution.toString());
    }
  }

  @Test
  public void sanityTest() {
    List<List<Integer>> oneByOne = makeEmptyBoard(1, 1);
    Solution solution = new Solution(0, 'x', 1, 1, oneByOne);
    assertEquals(printBoard(oneByOne), solution.toString());
  }

  @Ignore
  public void testMoveRowsRight() {
    fail("Not yet implemented");
  }

  @Ignore
  public void testMoveRowsLeft() {
    fail("Not yet implemented");
  }

  @Ignore
  public void testMoveColumnsUp() {
    fail("Not yet implemented");
  }

  @Ignore
  public void testGetColumn() {
    fail("Not yet implemented");
  }

  @Ignore
  public void testMoveColumnsDown() {
    fail("Not yet implemented");
  }

}
