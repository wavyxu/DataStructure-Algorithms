package backtrack;
import java.util.*;
/**
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create.
 *
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 *
 * Input: S = "12345"
 * Output: ["12345"]
 * Note:
 *
 * S will be a string with length at most 12.
 * S will consist only of letters or digits.
 */
public class LetterCasePermutationBFS {
    public List<String > letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            res.add(new String(""));
            return res;
        }

        helper(s, 0, new String(""), res);
        return res;
    }

    private void helper(String s, int index, String prefix, List<String> res) {
        if (index == s.length()) {
            res.add(new String(prefix));
            return;
        }

        Character c = s.charAt(index);

        if (Character.isLetter(c)) {
            helper(s, index + 1, prefix + Character.toLowerCase(c), res);
            helper(s, index + 1, prefix + Character.toUpperCase(c), res );
        } else {
            helper(s, index + 1, prefix + c, res);
        }

    }

    // solution 2 : bfs FIFO queue
    public List<String> letterCasePermutationBFS(String s) {
        LinkedList<String> res = new LinkedList<>();
        res.add(new String(""));

        if (s == null || s.length() == 0) {
            return res;
        }

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            while (res.peek().length() == i) {
                String curr = res.pollFirst();
                if (Character.isLetter(c)) {
                    res.offerLast(curr + Character.toLowerCase(c));
                    res.offerLast(curr + Character.toUpperCase(c));
                } else {
                    res.offerLast(curr + c);
                }
            }
        }

        return res;
    }
}
