package unionfind;
import java.util.*;
/**
 *A 2d grid map of m rows and n columns is initially filled with water.
 * We may perform an addLand operation which turns the water at position (row, col) into a land.
 * Given a list of positions to operate, count the number of islands after each addLand operation.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example:
 *
 * Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
 * Output: [1,1,2,3]
 * Explanation:
 *
 * Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
 *
 * 0 0 0
 * 0 0 0
 * 0 0 0
 * Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
 *
 * 1 0 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
 *
 * 1 1 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
 *
 * 1 1 0
 * 0 0 1   Number of islands = 2
 * 0 0 0
 * Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
 *
 * 1 1 0
 * 0 0 1   Number of islands = 3
 * 0 1 0
 * Follow up:
 *
 * Can you do it in time complexity O(k log mn), where k is the length of the positions?
 */
public class NumberOfIslandII {
    class UnionFind {
        private int[] father;
        public int count;
        public UnionFind (int n) {
            father = new int[n];
            for (int i = 0 ; i < n ; i++) {
                father[i] = i;
            }
            count = 0;
        }

        public void setCount(int n) {
            count = n;
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
                count--;
            }
        }

        public int query() {
            return count;
        }
     }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (positions == null || positions[0].length == 0) {
            return res;
        }
        UnionFind uf = new UnionFind(m * n);
        int[] dx = new int[] {1, -1, 0, 0} ;
        int[] dy = new int[] {0, 0, 1, -1} ;
        int[][] grid = new int[m][n];
        for(int[] oper : positions) {
            grid[oper[0]][oper[1]] = 1;
            uf.count++;

            for (int i = 0 ; i < 4;  i++) {
                int x = oper[0] + dx[i];
                int y = oper[1] + dy[i];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                    uf.union(oper[0] * n + oper[1], x * n + y);
                }
            }
            res.add(uf.query());
        }
        return res;
    }
}
