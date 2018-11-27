package backtrack;
import java.util.List;
import java.util.ArrayList;
/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that
 * no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * Example
 * There exist two distinct solutions to the 4-queens puzzle:
 *
 * [
 *   // Solution 1
 *   [".Q..",
 *    "...Q",
 *    "Q...",
 *    "..Q."
 *   ],
 *   // Solution 2
 *   ["..Q.",
 *    "Q...",
 *    "...Q",
 *    ".Q.."
 *   ]
 * ]
 */

/**
 * @author: Vivian Xu
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        helper(n, new ArrayList<Integer>(), res);
        return res;
    }

    private void helper(int n, List<Integer> usedCols, List<List<String>> res) {
        if (usedCols.size() == n) {
            res.add(drawChessBoard(usedCols));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(usedCols, i)) {
                continue;
            }
            usedCols.add(i);
            helper(n, usedCols, res);
            usedCols.remove(usedCols.size() - 1);
        }
    }

    private List<String> drawChessBoard(List<Integer> cols) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                sb.append(j == cols.get(i) ? 'Q' : '.');
            }
            res.add(sb.toString());
        }
        return res;
    }

    private boolean isValid(List<Integer> cols, int column) {
        int row = cols.size();
        for (int rowIndex = 0; rowIndex < cols.size(); rowIndex++) {
            if (cols.get(rowIndex) == column) {
                return false;
            }
            if (rowIndex + cols.get(rowIndex) == row + column) {
                return false;
            }
            if (rowIndex - cols.get(rowIndex) == row - column) {
                return false;
            }
        }
        return true;
    }
}
