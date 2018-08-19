package trie;
import java.util.*;

/**
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list,
 * so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 *
 * Example 1:
 *
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * Example 2:
 *
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 */

/**
 *   There are several cases to be considered that isPalindrome(s1 + s2):
 *
 * Case1: If s1 is a blank string, then for any string that is palindrome s2, s1+s2 and s2+s1 are palindrome.
 *
 * Case 2: If s2 is the reversing string of s1, then s1+s2 and s2+s1 are palindrome.
 *
 * Case 3: If s1[0:cut] is palindrome and there exists s2 is the reversing string of s1[cut+1:] , then s2+s1 is palindrome.
 *
 * Case 4: Similiar to case3. If s1[cut+1: ] is palindrome and there exists s2 is the reversing string of s1[0:cut] , then s1+s2 is palindrome.
 */

/**
 *  *   Search twice in the trie, the second time reverse the string.
 *  *   Keep in mind that: The info in the trie is always equal or shorter than the matching string.
 *  *   We deal with the case that info in the trie is longer than matching str in the reverse pass.
 *  *
 */
public class PalindromePairs {
    class TrieNode {
        public TrieNode[] children;
        public String word;
        public int idx;
        public TrieNode() {
            children = new TrieNode[26];
            word = null;
            idx = -1;
        }
    }
    class Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        public void add(String word, int idx) {
            TrieNode curr = root;
            for (Character c : word.toCharArray()) {
                int i = c - 'a';
                if (curr.children[i] == null) {
                    curr.children[i] = new TrieNode();
                }
                curr = curr.children[i];
            }
            curr.word = word;
            curr.idx = idx;
        }
        // To find all s', which make s's is palindrome
        // So, s'.length() <=  s.length()
        public List<List<Integer>> find(String s, int idx) {
            List<List<Integer>> ans = new ArrayList<>();
            char[] A = s.toCharArray();
            TrieNode d = root;
            // deal with empty string as input
            if (d.word != null && d.idx != idx && isPalin(A, 0, A.length - 1)) {
                ans.add(reverse ? Arrays.asList(idx, d.idx) : Arrays.asList(d.idx, idx));
            }
            for (int i = A.length - 1; i >= 0; i--) {
                // find a palindrome
                d = d.children[A[i] - 'a'];
                if (d == null) {
                    break;
                }
                if (d.word != null && d.idx != idx && isPalin(A, 0, i - 1)) {
                    // found a word, how check whether the remainder of str is palindrome
                    ans.add(reverse ? Arrays.asList(idx, d.idx) : Arrays.asList(d.idx, idx));
                }
            }
            return ans;
        }
    }
    private boolean reverse = false;
    private boolean isPalin(char[] A, int l, int r) {
        if (reverse && l > r) {
            return false;
        }
        while (l < r) {
            if (A[l++] != A[r--]) {
                return false;
            }
        }
        return true;
    }
    public List<List<Integer>> palindromePairs(String[] words) {

        // create a trie to find palindromePairs
        List<List<Integer>> ans = helper(words);
        for (int i = 0; i < words.length; i++) {
            words[i] = new StringBuilder(words[i]).reverse().toString();
        }
        reverse = true;
        // create another trie with reversed words
        ans.addAll(helper(words));
        return ans;
    }
    private List<List<Integer>> helper(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.add(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            ans.addAll(trie.find(words[i], i));
        }
        return ans;
    }
}
