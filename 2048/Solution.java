import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
  final int rows;
  final int lastRow;
  final int columns;
  final int lastColumn;
  final int numberOfMoves;
  final char moveDirection;
  final List<List<Integer>> board;

  Solution(int numberOfMoves2, char moveDirection2, int rows2, int columns2, List<List<Integer>> board2) {
    this.rows = rows2;
    this.lastRow = rows - 1;
    this.columns = columns2;
    this.lastColumn = columns - 1;
    this.numberOfMoves = numberOfMoves2;
    this.moveDirection = moveDirection2;
    this.board = board2;
  }

  String getSolution() {
    for (int i = 0; i < numberOfMoves; i++) {
      switch (moveDirection) {
      case 'D': // down
        moveColumnsDown();
        break;
      case 'U': // up
        moveColumnsUp();
        break;
      case 'L': // left
        moveRowsLeft();
        break;
      case 'R': // right
        moveRowsRight();
        break;
      }
    }

    return toString();
  }

  @Override
  public String toString() {
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

  void moveRowsRight() {
    boolean[] moved;
    for (List<Integer> row : board) {
      moved = new boolean[columns]; // all false by default

      // start at end, don't move last column
      for (int currentColumn = lastColumn - 1; currentColumn >= 0; currentColumn--) {
        int movingColumn = currentColumn; // move each tile one column at a time
        int nextColumn = movingColumn + 1;

        while (movingColumn < lastColumn && row.get(nextColumn) == 0) {
          row.set(nextColumn, row.get(movingColumn)); // move current tile right one
          row.set(movingColumn, 0);
          movingColumn++;
          nextColumn++;
        }
        // if not at end and next tile can be combined with current and next tile has not been moved
        if (movingColumn < lastColumn && row.get(nextColumn) == row.get(movingColumn) && !moved[nextColumn]) {
          row.set(movingColumn, 0);
          // double next tile in column
          row.set(nextColumn, row.get(nextColumn) * 2);
          moved[nextColumn] = true;
        }
      }
    }
  }

  // all the rest of these methods are basically the same
  void moveRowsLeft() {
    boolean[] moved;
    for (List<Integer> row : board) {
      // track if tile has been moved
      moved = new boolean[columns];

      // starting at left and moving right; don't move first column
      for (int currentColumn = 1; currentColumn < columns; currentColumn++) {

        int movingColumn = currentColumn;
        int nextColumn = movingColumn - 1;

        while (movingColumn > 0 && row.get(nextColumn) == 0) {
          row.set(nextColumn, row.get(movingColumn));
          row.set(movingColumn, 0);
          movingColumn--;
          nextColumn--;
        }
        if (movingColumn > 0 && row.get(nextColumn) == row.get(movingColumn) && !moved[nextColumn]) {
          row.set(movingColumn, 0);
          row.set(nextColumn, row.get(nextColumn) * 2);
          moved[nextColumn] = true;
        }
      }
    }
  }

  void moveColumnsUp() {
    boolean[] moved;
    for (int column = 0; column < columns; column++) { // for column : columns
      moved = new boolean[rows];
      for (int row = 1; row < rows; row++) { // don't move first row

        int movingRow = row;
        int nextRow = movingRow - 1;

        while (movingRow > 0 && getColumn(nextRow, column) == 0) {
          board.get(nextRow).set(column, getColumn(movingRow, column));
          board.get(movingRow).set(column, 0);
          movingRow--;
          nextRow--;
        }
        if (movingRow > 0 && getColumn(nextRow, column) == getColumn(movingRow, column) && !moved[nextRow]) {
          board.get(movingRow).set(column, 0);
          board.get(nextRow).set(column, getColumn(nextRow, column) * 2);
          moved[nextRow] = true;
        }
      }
    }
  }

  int getColumn(int x, int y) {
    return board.get(x).get(y);
  }

  void moveColumnsDown() {
    boolean[] moved;
    for (int column = 0; column < columns; column++) { // for column : columns, order doesn't matter
      moved = new boolean[rows];
      for (int row = lastRow - 1; row >= 0; row--) { // don't move last row

        int movingRow = row;
        int nextRow = movingRow + 1;

        while (movingRow < lastRow && getColumn(nextRow, column) == 0) {
          board.get(nextRow).set(column, getColumn(movingRow, column));
          board.get(movingRow).set(column, 0);
          movingRow++;
          nextRow++;
        }
        if (movingRow < lastRow && getColumn(nextRow, column) == getColumn(movingRow, column) && !moved[nextRow]) {
          board.get(movingRow).set(column, 0);
          board.get(nextRow).set(column, getColumn(nextRow, column) * 2);
          moved[nextRow] = true;
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String[] splitMove = input.nextLine().split(" ");

    int numberOfMoves = Integer.parseInt(splitMove[0]);
    char moveDirection = splitMove[1].charAt(0);

    int rows = input.nextInt();
    input.nextLine();
    int columns = input.nextInt();
    input.nextLine();
    List<List<Integer>> board = new ArrayList<List<Integer>>();

    for (int x = 0; x < rows; x++) {
      List<Integer> row = new ArrayList<>();
      for (String s : input.nextLine().split(" ")) {
        if (Integer.parseInt(s) != Long.parseLong(s)) {
          throw new IllegalStateException();
        }
        row.add(Integer.parseInt(s));
      }
      board.add(row);
    }

    input.close();

    System.out.println(new Solution(numberOfMoves, moveDirection, rows, columns, board).getSolution());
  }
}