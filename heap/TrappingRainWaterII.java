package heap;
import java.util.*;
/**
 * Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.
 *
 * Note:
 * Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.
 *
 * Example:
 *
 * Given the following 3x6 height map:
 * [
 *   [1,4,3,1,3,2],
 *   [3,2,1,3,2,4],
 *   [2,3,3,2,3,1]
 * ]
 *
 * Return 4.
 */
public class TrappingRainWaterII {
    class Cell {
        public int x;
        public int y;
        public int height;
        public Cell(int x, int y, int heigth) {
            this.x = x;
            this.y = y;
            this.height = heigth;
        }
    }
    private Comparator<Cell> comparator = new Comparator<Cell>() {
        @Override
        public int compare(Cell o1, Cell o2) {
            return o1.height - o2.height;
        }
    };
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length;
        int n = heightMap[0].length;

        Queue<Cell> minHeap = new PriorityQueue<Cell>(comparator);
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            minHeap.offer(new Cell(i, 0, heightMap[i][0]));
            minHeap.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }

        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            minHeap.offer(new Cell(0, i, heightMap[0][i]));
            minHeap.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
        }

        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};

        int res = 0;
        while (!minHeap.isEmpty()) {
            Cell curr = minHeap.poll();

            for (int k = 0; k < 4; k++) {
                int x = curr.x + dx[k];
                int y = curr.y + dy[k];
                if (x >= 0 && x < m && y >= 0 && y < n && visited[x][y] == false) {
                    minHeap.offer(new Cell(x, y, Math.max(curr.height,heightMap[x][y])));
                    visited[x][y] = true;
                    res += Math.max(0, curr.height - heightMap[x][y]);
                }
            }
        }
        return res;
    }
}
