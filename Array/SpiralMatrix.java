package array;
import java.util.List;
import java.util.ArrayList;
/**
 * @author: Vivian Xu
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (up <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            up++;
            for (int j = up; j <= down; j++) {
                res.add(matrix[j][right]);
            }
            right--;
            if (up <= down && left <= right) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[down][i]);
                }
                down--;
                for (int j = down; j >= up; j--) {
                    res.add(matrix[j][left]);
                }
                left++;
            }
        }
        return res;
    }
}
