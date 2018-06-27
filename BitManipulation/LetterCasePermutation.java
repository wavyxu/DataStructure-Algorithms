package BitManipulation;
import java.util.*;

/**
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
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
public class LetterCasePermutation {
//
//                1
//        /               \
//        1a              1A
//        |                |
//        1a2             1A2
//    /        \       /       \
//   1a2b     1a2B    1A2b    1A2B
//

    public List<String> letterCasePermutation(String s) {
        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder());

        // s = "1a2b"
        for (char c : s.toCharArray()) {
            // loop 1: n = 1;
            int n = ans.size();
            // each time read a letter, double previous strings
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; ++i) {
                    // loop 1: ans.get(0)
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n + i).append((Character.toUpperCase(c)));
                }
            }
                else {
                    for (int i = 0; i < n; i++) {
                        ans.get(i).append(c);
                    }
                }
            }
        List<String> finalans = new ArrayList<>();
        for (StringBuilder sb : ans) {
            finalans.add(sb.toString());
        }
        return finalans;
        }

    public List<String> letterCasePermutation2(String s) {
        int B = 0;
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                B++;
            }
        }

        List<String> ans = new ArrayList<>();
        // B: the number of letters
        // 1<<B : 2^B
        // bits : 0 <= bits < 2^B
        // loop1 : bits = 0: --- 00 --- 1A2B
        // loop2 : bits = 1: --- 01 --- 1a2B
        // loop3 : bits = 2: --- 10 --- 1A2b
        // loop4 : bits = 3: --- 11 --- 1a2b

        for (int bits = 0; bits < 1<<B; bits++) {
            int b = 0;
            StringBuilder word = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (Character.isLetter(c)) {
                    // ((bits >> b) & 1) == 1  represent bth bit set is 1.
                    if (((bits >> b++) & 1) == 1) {
                        // when bth bit set of bits is 1, set the bth letter of the word to lowerCase
                        word.append(Character.toLowerCase(c));
                    } else
                    {
                        // when bth bit set of bits is 0, set the bth letter of the word to upperCase
                        word.append(Character.toUpperCase(c));
                    }
                } else {
                    word.append(c);
                }
            }
            ans.add(word.toString());
        }
        return ans;
    }

    public static void main(String[] args) {
        LetterCasePermutation test = new LetterCasePermutation();
        System.out.println(test.letterCasePermutation("1a2b"));
        System.out.println(test.letterCasePermutation2("1a2b"));
    }
}

