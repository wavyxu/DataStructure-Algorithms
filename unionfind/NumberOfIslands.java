package unionfind;
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
class UnionFind {
    private int[] father;
    private int count = 0;

    public UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    public void setCout(int c) {
        this.count = c;
    }

    public int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            father[rootA] = rootB;
            this.count--;
        }
    }

    public int query() {
        return count;
    }
}
public class NumberOfIslands {


    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;

        UnionFind uf = new UnionFind( n * m);
        int count = 0;
        for (int i = 0; i < n; i++ ) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == true) {
                    count++;
                }
            }
        }
        uf.setCout(count);

        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};

        for (int i = 0; i < n; i++ ) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == true) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == true) {
                            uf.union(i * m + j, x * m + y);
                        }
                    }
                }
            }
        }
        return uf.query();
    }
}
