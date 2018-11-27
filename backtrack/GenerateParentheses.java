package backtrack;
import java.util.List;
import java.util.ArrayList;
/**
 * @author: Vivian Xu
 */

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n, n, new StringBuilder(), res);
        return res;
    }
    private void helper(int open, int close, StringBuilder prefix, List<String> res) {
        if (open == 0 && close == 0) {
            res.add(prefix.toString());
            return;
        }
        if (open > 0) {
            prefix.append('(');
            helper(open - 1, close, prefix, res);
            prefix.deleteCharAt(prefix.length() - 1);
        }
        if (close > open) {
            prefix.append(')');
            helper(open, close - 1, prefix, res);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}
