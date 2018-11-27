package array;

/**
 * @author: Vivian Xu
 */

/**
 * Given a positive integer n, generate a square matrix filled with elements
 * from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        if (n < 1) {
            return new int[0][0];
        }
        int[][] res = new int[n][n];
        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;
        int curr = 1;
        while (up <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                res[up][i] = curr++;
            }
            up++;
            for (int j = up; j <= down; j++) {
                res[j][right] = curr++;
            }
            right--;
            if (up <= down && left <= right) {
                for (int i = right; i >= left; i--) {
                    res[down][i] = curr++;
                }
                down--;
                for (int j = down; j >= up; j--) {
                    res[j][left] = curr++;
                }
                left++;
            }
        }
        return res;
    }
}
