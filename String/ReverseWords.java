package String;

/**
 * Description
 * Given an input string, reverse the string word by word.
 *
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 * Have you met this question in a real interview?
 * Clarification
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 */
public class ReverseWords {
//    public String reverseWords(String s) {
//        // write your code here
//        if (s == null || s.length() == 0) {
//            return s;
//        }
//
//        String[] res = s.split(" ");
//
//        for (int i = 0, j = res.length - 1; i < j; i++,j--) {
//            String temp =  res[j];
//            res[j] = res[i];
//            res[i] = temp;
//        }
//
//        //return res.toString();
//        return  String.valueOf(res); // wrong
//    }
    public String reverseWords1(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return s;
        }

        String[] res = s.split(" ");
        StringBuilder ans = new StringBuilder();

        for (int i = res.length - 1; i >= 0; i--) {
            ans.append(res[i] + " ");
        }

        return ans.toString().trim();
    }

    public String reverseWords(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        char[] c = s.toCharArray();
        reverse(c, 0, c.length - 1);
        int start = 0;

        for (int i = 0; i < c.length; i++) {
            if (i == 0 || c[i] != ' ' && c[i - 1] == ' ') {
                start = i;
            }
            if (i == c.length - 1 || c[i] != ' ' && c[i + 1] == ' ') {
                reverse(c, start, i);
                start = i + 1;
            }
        }
        return cleanSpace(c);
    }


    public String reverseWords2(String input) {
        if (input == null) {
            return input;
        }
        char[] c = input.toCharArray();
        reverse(c, 0, c.length - 1);
        int left = 0;
        for (int right = 0; right <= c.length; right++) {
            if (right == c.length || c[right] == ' ') {
                reverse(c, left, right - 1);
                left = right + 1;
            }
        }
        return new String(c);
    }

    private void reverse(char[] c, int start, int end) {
        while (start < end) {
            swap(c, start++, end--);
        }
    }

    private void swap(char[] c, int left, int right) {
        char temp = c[right];
        c[right] = c[left];
        c[left] = temp;
    }

    private String cleanSpace(char[] c) {
        int i = 0, j = 0;
        while (j < c.length) {
            while (j < c.length && c[j] == ' ') {
                j++;
            }
            while(j < c.length && c[j] != ' ') {
                c[i++] = c[j++];
            }
            while (j < c.length && c[j] == ' ') {
                j++;
            }
            if (j < c.length) {
                c[i++] = ' ';
            }
        }
        return new String(c, 0, i);
    }

    private void reverseWords(char[] c, int n) {
        int start = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0 || c[i] != ' ' && c[i - 1] == ' ') {
                start = i;
            }
            if (i == n - 1 || c[i] != ' ' && c[i + 1] == ' ') {
                reverse(c, start, i);
                start = i + 1;
            }
        }

    }

    public String reverseWords3(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] c = s.toCharArray();

        // step 1. reverse the whole string
        reverse(c, 0, s.length() - 1);

        // step 2. reverse each word
        reverseWords(c, s.length() - 1);

        // step 3. clean up spaces
        return cleanSpace(c);
    }

    public static void main(String[] args) {
        ReverseWords test = new ReverseWords();
        //System.out.println(test.reverseWords(" the sky is bule "));
        System.out.println(test.reverseWords(" the sky is bule "));
        System.out.println(test.reverseWords2(" the sky is bule "));
        System.out.println(test.reverseWords3(" the sky is bule "));
    }
}
