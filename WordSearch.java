package backtrack;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch {
    // solution 1 DFS
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, word, 1, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int index, int i, int j) {
        if (index == word.length()) {
            return true;
        }

        boolean res = false;
        int[] dx = new int[] {0, 0, 1, -1};
        int[] dy = new int[] {1, -1, 0, 0};

        board[i][j] = '#';
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (!inBoundary(board, x, y)) {
                continue;
            }
            if (board[x][y] == word.charAt(index)) {
                 if (helper(board, word, index + 1, x, y) ){
                     return true;
                }
            }
        }
        board[i][j] = word.charAt(index - 1);
        return false;
    }

    private boolean inBoundary(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

    // solution 2 DFS
    public boolean exist1(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (helper1(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper1(char[][] board, String word, int index, int i, int j) {
        if (index == word.length()) {
            return true;
        }

        if (!inBoundary(board, i, j)) {
            return false;
        }

        if (board[i][j] != word.charAt(index)) {
            return false;
        }


        boolean res = false;
        int[] dx = new int[] {0, 0, 1, -1};
        int[] dy = new int[] {1, -1, 0, 0};

        board[i][j] = '#';
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (helper1(board, word, index + 1, x, y) ){
                return true;
            }
        }
        board[i][j] = word.charAt(index);
        return false;
    }

}
