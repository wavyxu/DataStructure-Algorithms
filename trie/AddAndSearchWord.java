package trie;
import java.util.*;

/**
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or ..
 * A . means it can represent any one letter.
 *
 * Example:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */
public class AddAndSearchWord {
    class TrieNode {
        public TrieNode[] children;
        public boolean hasWord;
        public TrieNode() {
            children = new TrieNode[26];
            hasWord = false;
        }
    }
    class WordDictionary {
        private TrieNode root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode curr = root;
            for(int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if(curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.hasWord = true;
        }

        /** Returns if the word is in the data structure.
         * A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {

            return searchHelper(root, word, 0);
        }

        // DFS
        // the depth of recursion depends on the length of word,
        // so don't worry about stack overflow
        public boolean searchHelper(TrieNode root, String word, int index) {
            if (root == null) {
                return false;
            }
            if(index == word.length()) {
                return root.hasWord;
            }

            TrieNode curr = root;
            if(word.charAt(index) != '.') {
                int pos = word.charAt(index) - 'a';
                return searchHelper(curr.children[pos], word, index + 1);
            } else {
                for(int i = 0; i < root.children.length; i++) {
                    if(searchHelper(root.children[i], word, index + 1)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
