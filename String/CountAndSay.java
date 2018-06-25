package String;
/**
 *
Description
        The count-and-say sequence is the sequence of integers beginning as follows:

        1, 11, 21, 1211, 111221, ...

        1 is read off as "one 1" or 11.

        11 is read off as "two 1s" or 21.

        21 is read off as "one 2, then one 1" or 1211.

        Given an integer n, generate the nth sequence.

        The sequence of integers will be represented as a string.

        Example
        Given n = 5, return "111221".
 */


public class CountAndSay {
    private String countString(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                count++;
            }
            res.append(count);
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    public String countAndSay(int n) {
        String res = new String("1");
        for(int i = 0; i < n - 1; i++) {
            res = countString(res);
        }
        return res;
    }
}
