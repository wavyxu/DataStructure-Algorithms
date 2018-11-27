package backtrack;
import java.util.*;
/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations
 * that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 *
 *
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsOfAPhoneNumber {

    // solution 1 dfs recursive
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        String[] map = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder prefix = new StringBuilder();
        helper(digits, map, 0, prefix, res);
        return res;

    }

    private void helper(String digits, String[] map, int index, StringBuilder prefix, List<String> res) {
        if (index == digits.length()) {
            res.add(prefix.toString());
            return;
        }
        int currIndex = digits.charAt(index) - '0';
        for (int i = 0; i < map[currIndex].length(); i++) {
            prefix.append(map[currIndex].charAt(i));
            helper(digits, map, index + 1, prefix, res);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    // solution 2 bfs FIFO queue
    public List<String> letterCombinationsBFS(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] map = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //Deque<string> queue = new ArrayDeque<>();

        //queue.addFirst(new string (""));

        res.add(new String(""));

        for (int i = 0; i < digits.length(); i++) {
            int index = digits.charAt(i) - '0';
            while (res.peek().length() == i) {
                String curr = res.removeFirst();
                for (Character c : map[index].toCharArray()) {
                    res.add(curr + c);
                }
            }
        }

        return res;
    }

}
