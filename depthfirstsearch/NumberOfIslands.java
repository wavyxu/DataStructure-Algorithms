package depthfirstsearch;
import java.util.*;
/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */

class Coordinates {
    public int x;
    public int y;
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    markByBFS(grid, i, j);
                }
            }
        }
        return count;
    }

    private void markByBFS(char[][] grid, int x, int y) {
        int[] dx = new int[] {0, 0, 1, -1};
        int[] dy = new int[] {1, -1, 0, 0};

        Queue<Coordinates> queue = new LinkedList<>();
        queue.add(new Coordinates(x, y));
        grid[x][y] = '0';

        while (!queue.isEmpty()) {
            Coordinates curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int neiX = curr.x + dx[i];
                int neiY = curr.y + dy[i];

                if (inBoundary(grid, neiX, neiY) && grid[neiX][neiY] == '1') {
                    queue.add(new Coordinates(neiX, neiY));
                    grid[neiX][neiY] = '0';
                }
            }
        }

    }

    private boolean inBoundary(char[][] grid, int x, int y) {
        return (x >= 0) && (x < grid.length) && (y >= 0) && (y < grid[0].length);
    }

    public static void main(String[] args) {
        NumberOfIslands mytest = new NumberOfIslands();
        char[][] grid = new char[][] {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(mytest.numIslands(grid));
    }

}
