package trie;
import java.util.*;
/**
 * Given a set of words without duplicates, find all word squares you can build from them.
 *
 * A sequence of words forms a valid word square if the kth row and column read the exact same string,
 * where 0 ≤ k < max(numRows, numColumns).
 *
 * For example, the word sequence ["ball","area","lead","lady"] forms a word square
 * because each word reads the same both horizontally and vertically.
 *
 * b a l l
 * a r e a
 * l e a d
 * l a d y
 * There are at least 1 and at most 1000 words.
 * All words will have the exact same length.
 * Word length is at least 1 and at most 5.
 * Each word contains only lowercase English alphabet a-z.
 *
 * Example
 * Given a set ["area","lead","wall","lady","ball"]
 * return [["wall","area","lead","lady"],["ball","area","lead","lady"]]
 * Explanation:
 * The output consists of two word squares.
 * The order of output does not matter (just the order of words in each word square matters).
 *
 * Given a set ["abat","baba","atan","atal"]
 * return [["baba","abat","baba","atan"],["baba","abat","baba","atal"]]
 * Explanation:
 * The output consists of two word squares.
 * The order of output does not matter (just the order of words in each word square matters).
 */

/**
 * Symmetric
 * DFS , find all possible paths
 * find possible word with given prefix
 *
 *
 * This question could use hashmap or trie. The same time complexity
 * If use hashmap, code will much more simple
 *
 */
public class WordSquares {
    class TrieNode {
        public TrieNode[] children;
        public List<String> wordList;
        public boolean hasWord;
        public TrieNode() {
            children = new TrieNode[26];
            wordList = new ArrayList<>();
            hasWord = false;
        }
    }
    class Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        public Trie(String[] words) {
            root = new TrieNode();
            for (String word : words) {
                TrieNode curr = root;
                for (char ch : word.toCharArray()) {
                    int index = ch - 'a';
                    if (curr.children[index] == null) {
                        curr.children[index] = new TrieNode();
                    }
                    curr = curr.children[index];
                    curr.wordList.add(word);
                }
                curr.hasWord = true;
            }
        }
        public boolean find(String word) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (curr.children[index] == null) {
                    return false;
                }
            }
            return curr.hasWord;
        }
        public List<String> findByPrefix(String prefix) {
            List<String> res = new ArrayList<>();
            TrieNode curr = root;
            for (char ch : prefix.toCharArray()) {
                int index = ch - 'a';
                if (curr.children[index] == null) {
                    return res;
                }
                curr = curr.children[index];
            }
            return curr.wordList;
        }

    }
    public List<List<String>> wordSquares(String[] words) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        int len = words[0].length();
        Trie trie = new Trie(words);
        List<String> resBuilder = new ArrayList<>();
        // DFS
        // Try / Enumerate all possibility for the first word
        for (String w : words) {
            resBuilder.add(w);
            search(len, trie, res, resBuilder);
            resBuilder.remove(resBuilder.size() - 1);
        }
        return res;
    }

    private void search(int len,
                         Trie tr,
                         List<List<String>> res,
                         List<String> resBuilder) {
        // Because of symmetric, the number of words equals to the length of first word
        // Exit condition
        if (resBuilder.size() == len) {
            res.add(new ArrayList<>(resBuilder));
            return;
        }


        // the index represent the column which the target prefix should match
        // for example ,the index = 2, the target prefix is "le"
        // b a l l
        // a r e a
        int index = resBuilder.size();
        StringBuilder prefixBuilder = new StringBuilder();
        for (String s : resBuilder) {
            prefixBuilder.append(s.charAt(index));
        }
        List<String> wordList = tr.findByPrefix(prefixBuilder.toString());
        // DFS
        // Try / Enumerate all possibility for the next word from the found wordList
        // The wordList contains all words with the target prefix
        for (String nextW : wordList) {
            resBuilder.add(nextW);
            search(len, tr, res, resBuilder);
            resBuilder.remove(resBuilder.size() - 1);
        }
    }

    // with pruning
    private void search2(int len,
                        Trie tr,
                        List<List<String>> res,
                        List<String> resBuilder) {
        // Because of symmetric, the number of words equals to the length of first word
        // Exit condition
        if (resBuilder.size() == len) {
            res.add(new ArrayList<>(resBuilder));
            return;
        }


        // the index represent the column which the target prefix should match
        // for example ,the index = 2, the target prefix is "le"
        // b a l l
        // a r e a
        int index = resBuilder.size();
        // pruning
        for(int i = index; i < len; i++) {
            StringBuilder tempPrefixBuilder = new StringBuilder();
            for(String s : resBuilder) {
                tempPrefixBuilder.append(s.charAt(i));
            }
            if (tr.findByPrefix(tempPrefixBuilder.toString()).size() == 0) {
                return;
            }
        }
        StringBuilder prefixBuilder = new StringBuilder();
        for (String s : resBuilder) {
            prefixBuilder.append(s.charAt(index));
        }
        List<String> wordList = tr.findByPrefix(prefixBuilder.toString());
        // DFS
        // Try / Enumerate all possibility for the next word from the found wordList
        // The wordList contains all words with the target prefix
        for (String nextW : wordList) {
            resBuilder.add(nextW);
            search(len, tr, res, resBuilder);
            resBuilder.remove(resBuilder.size() - 1);
        }
    }
}
