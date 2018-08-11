package unionfind;
import java.util.*;
/**
 *Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class SurroundedRegions {
    class UnionFind {
        private int[] father;
        private int count;
        public UnionFind(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
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

    public void solve1(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int n = board.length;
        int m = board[0].length;

        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};

        UnionFind uf = new UnionFind(n * m + 1);
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if (board[i][j] == 'O') {
                    if (isBorder(board, i, j))
                    uf.union(i * m + j , m * n);   // create a dummy node : m * n

                    for (int k = 0 ; k < 4; k ++) {
                        int x  = i + dx[k];
                        int y = j + dy[k];
                        if (inBoundary(board, x, y) && board[x][y] == 'O') {
                            uf.union(i * m + j, x * m + y);
                        }
                    }
                }
            }
        }

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if (board[i][j] == 'O' && uf.find(i * m + j) != uf.find(m * n)) {
                    board[i][j] = 'X';
                }
            }

        }
    }



    private boolean isBorder(char[][] board, int x, int y) {
        int n = board.length;
        int m = board[0].length;
        return x == 0 || x == n - 1 || y == 0 || y == m - 1;
    }

    private boolean inBoundary(char[][] board, int x, int y) {
        int n = board.length;
        int m = board[0].length;
        return x >= 0 && x < n && y >=0 && y < m;
    }

}
