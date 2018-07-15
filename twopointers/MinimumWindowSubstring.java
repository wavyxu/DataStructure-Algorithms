package twopointers;
import java.util.*;
/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0) {
            return new String("");
        }
        int l = 0;
        int r = 1;
        int len = Integer.MAX_VALUE;
        String res = new String("");
        while (l < r && r <= s.length()) {
            String temp = s.substring(l, r);
            if (!contains(temp, t)) {
                r++;
            } else {
                if (r - l < len) {
                    len = r - l;
                    res = temp;
                }
                l++;
            }
        }

        return res;
    }

    private boolean contains(String s, String t) {
        Map<Character, Integer> hash = new HashMap();

        for (Character c : s.toCharArray()) {
            if (hash.containsKey(c)) {
                hash.put(c, hash.get(c) + 1);
            } else {
                hash.put(c, 1);
            }
        }

        for (Character c : t.toCharArray()) {
            if (!hash.containsKey(c) || hash.get(c) == 0) {
                return false;
            } else {
                hash.put(c, hash.get(c) - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring mytest = new MinimumWindowSubstring();
        System.out.println(mytest.minWindow("ADOBECODEBANC", "ABC"));
    }
}
