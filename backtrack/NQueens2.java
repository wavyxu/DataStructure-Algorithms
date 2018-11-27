package backtrack;
import java.util.List;
import java.util.ArrayList;
/**
 * Follow up for N-Queens problem.
 *
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 *
 * Example
 * For n=4, there are 2 distinct solutions.
 */

/**
 * @author: Vivian Xu
 */
public class NQueens2 {
    private int sum = 0;
    public int totalNQueens(int n) {
        helper(n, new ArrayList<Integer>());
        return sum;
    }

    private void helper(int n, List<Integer> usedColumns) {
        if (usedColumns.size() == n) {
            sum++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(usedColumns, i)) {
                continue;
            }
            usedColumns.add(i);
            helper(n, usedColumns);
            usedColumns.remove(usedColumns.size() - 1);
        }
    }

    private boolean isValid(List<Integer> usedColumns, int column) {
        int row = usedColumns.size();
        for (int rowIndex = 0; rowIndex < usedColumns.size(); rowIndex++) {
            if (usedColumns.get(rowIndex) == column) {
                return false;
            }
            if (rowIndex + usedColumns.get(rowIndex) == row + column) {
                return false;
            }
            if (rowIndex - usedColumns.get(rowIndex) == row - column) {
                return false;
            }
        }
        return true;
    }
}
