package trie;
import java.util.*;

/**
 * Given a matrix of lower alphabets and a dictionary.
 * Find all words in the dictionary that can be found in the matrix.
 * A word can start from any position in the matrix and go left/right/up/down to the adjacent position.
 * One character only be used once in one word.
 *
 * Example
 * Given matrix:
 *
 * doaf
 * agai
 * dcan
 * and dictionary:
 *
 * {"dog", "dad", "dgdg", "can", "again"}
 *
 * return {"dog", "dad", "can", "again"}
 */
public class WordSearch2 {
    class TrieNode {
        public TrieNode[] children;
        public String word;
        public TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }
    class Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        public void add(String word) {
            TrieNode curr = root;
            for(char c : word.toCharArray()) {
                int index = c - 'a';
                if(curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.word = word;
        }
        public TrieNode getRoot() {
            return root;
        }
    }
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0
                || words == null || words.size() == 0) {
            return res;
        }

        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                search(board, i, j, trie.getRoot(), res);
            }
        }

        return res;

    }

    private void search(char[][] board,
                        int i,
                        int j,
                        TrieNode node,
                        List<String> res) {
        char c = board[i][j];

        // pruning
        if (c == '#' || node.children[c - 'a'] == null) {
            return;
        }

        node = node.children[c - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';
        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if(isValid(board, x, y)) {
                search(board, x, y, node, res);
            }
        }
        board[i][j] = c;

    }
    private boolean isValid(char[][] board, int i, int j) {
        return i >=0 && i < board.length && j >=0 && j < board[0].length;
    }
}
