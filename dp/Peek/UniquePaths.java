package dp;
import java.util.*;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 *
 * Input: m = 7, n = 3
 * Output: 28
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];

        // initialization
        f[0][0] = 1;

        for (int i = 0; i < m; i++) {  // row  from up to down
            for (int j = 0; j < n; j++) {  // column  from left to right
                if (i == 0 || j == 0) {
                    f[i][j] = 1;
                    continue;         // initialization
                }
                f[i][j] = f[i - 1][j] + f[i][j - 1];   // transfer function
            }
        }

        return f[m - 1][n - 1];
    }
}
