package String;

/**
 * Description
 * Write a method anagram(s,t) to decide if two strings are anagrams or not.
 *
 * Have you met this question in a real interview?
 * Clarification
 * What is Anagram?
 *
 * Two strings are anagram if they can be the same after change the order of characters.
 * Example
 * Given s = "abcd", t = "dcab", return true.
 * Given s = "ab", t = "ab", return true.
 * Given s = "ab", t = "ac", return false.
 *
 * Challenge
 * O(n) time, O(1) extra space
 */
public class ValidAnagram {
    public boolean anagram(String s, String t) {
        // write your code here
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] map = new int[256];
        for (char c : s.toCharArray()) {
            map[c]++;
        }

        for (char c : t.toCharArray()) {
            map[c]--;
        }

        for (int i : map) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
