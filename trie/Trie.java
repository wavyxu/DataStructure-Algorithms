package trie;
import tree.TreeNode;

import java.util.*;

/**
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

class TrieNode {
    public TrieNode[] children;
    public boolean hasWord;
    public TrieNode() {
        children = new TrieNode[26];
        hasWord = false;
    }
}

public class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {

        root = new TrieNode();
    }

    public Trie(String[] words) {
        root = new TrieNode();
        for(String word : words) {
            TrieNode curr = root;
            for(char ch : word.toCharArray()) {
                int index = ch - 'a';
                if(curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.hasWord = true;
        }
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.hasWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                return false;
            } else {
                curr = curr.children[index];
            }
        }
        return curr.hasWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (curr.children[index] == null) {
                return false;
            }

            curr = curr.children[index];
        }
        return true;
    }
}
