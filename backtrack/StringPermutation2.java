package backtrack;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * @author: Vivian Xu
 */
public class StringPermutation2 {
    public List<String> stringPermutation2(String str) {
        // write your code here
        List<String> res = new ArrayList<>();
        char[] ch = str.toCharArray();
        boolean[] added = new boolean[ch.length];
        Arrays.sort(ch);
        StringBuilder prefix = new StringBuilder();
        helper(ch, added, prefix, res);
        return res;
    }

    private void helper(char[] ch, boolean[] added, StringBuilder prefix, List<String> res) {
        if (prefix.length() == ch.length) {
            res.add(prefix.toString());
            return;
        }

        for (int i = 0; i < ch.length; i++) {
            if (added[i] == true) {
                continue;
            }
            if (i != 0 && ch[i] == ch[i - 1] && !added[i - 1]) {
                continue;
            }
            prefix.append(ch[i]);
            added[i] = true;
            helper(ch, added, prefix, res);
            prefix.deleteCharAt(prefix.length() - 1);
            added[i] = false;
        }

    }
}
