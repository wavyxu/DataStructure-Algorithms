package depthfirstsearch;
import java.util.*;
/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid.
 * Return all possible results.
 *
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Example 1:
 *
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * Example 2:
 *
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * Example 3:
 *
 * Input: ")("
 * Output: [""]
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        int[] count = getLeftRightCount(s);
        remove(s, 0, count[0], count[1], res);
        return res;
    }

    private void remove(String s, int start, int leftCount, int rightCount, List<String> res) {
        // why here need to call isValid(s) ?
        // consider that when s = "()(", the second call of remove is remove(")(", 0, 0, 0, res)
        if (leftCount == 0 && rightCount == 0 && isValid(s)) {
            res.add(s);
            return;
        }


        for (int i = start; i < s.length(); i++) {
            // restrict just to remove the first ')' in a series of consecutive ')'s
            // if we remove any one, we will generate duplicate results.
            // for example s = ()), we can remove s[1] or s[2], but the result is the same ()
            if (i > start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }


            if (leftCount > 0 && s.charAt(i) == '(') {
                remove(s.substring(0, i) + s.substring(i + 1), i, leftCount - 1, rightCount, res);
            }

            if (rightCount > 0 && s.charAt(i) == ')') {
                remove(s.substring(0, i) + s.substring(i + 1), i, leftCount, rightCount - 1, res);
            }
        }
    }

    private int[] getLeftRightCount(String s) {
        int left = 0;
        int right = 0;

        for (Character c : s.toCharArray()) {
            if (c == '(') {
                left++;
            }
            if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        return new int[] {left, right};
    }

    private boolean isValid(String s) {
        int[] count = getLeftRightCount(s);
        return count[0] == 0 && count[1] == 0;
    }
}
