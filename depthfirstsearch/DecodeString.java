package depthfirstsearch;
import java.util.*;
/**
 * Given an encoded string, return it's decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets
 * is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets
 * are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and
 * that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return new String("");
        }
        Deque<Character> stack = new ArrayDeque<>();
        int i = 0;
        String res = new String("");
        stack.addFirst(s.charAt(i++));

        while (!stack.isEmpty()) {
            while (i < s.length() && s.charAt(i) != ']') {
                stack.addFirst(s.charAt(i++));
            }
            i++;
            String temp = new String("");
            while (!stack.isEmpty() && stack.peekFirst() != '[') {
                temp = stack.removeFirst() + temp;
            }
            if (stack.isEmpty()) {
                return temp;
            } else {

                if (stack.peekFirst() == '[') {
                    stack.removeFirst();
                }
                int k = 0;
                int flag = 0;
                while (!stack.isEmpty() && Character.isDigit(stack.peekFirst())) {
                    k = k + (stack.removeFirst() - '0') *(int) Math.pow(10.0,flag++);
                }

                for (int j = 0; j < k; j++) {
                    for (Character c : temp.toCharArray()) {
                        stack.addFirst(c);
                    }
                }
            }
        }
        return res;
    }

    public String decodeString2(String s) {
        if (s == null || s.length() == 0) {
            return new String("");
        }
        Deque<Character> stack = new ArrayDeque<>();
        int i = 0;
        String res = new String("");
        stack.addFirst(s.charAt(i++));

        while (!stack.isEmpty()) {
            while (i < s.length() && s.charAt(i) != ']') {
                stack.addFirst(s.charAt(i++));
            }
            i++;
            String temp = new String("");
            while (!stack.isEmpty() && stack.peekFirst() != '[') {
                temp = stack.removeFirst() + temp;
            }
            if (stack.isEmpty()) {
                return temp;
            } else {

                if (stack.peekFirst() == '[') {
                    stack.removeFirst();
                }

                String count = new String("");
                while (!stack.isEmpty() && Character.isDigit(stack.peekFirst())) {
                    count = stack.removeFirst() + count;
                }

                int k = convertToInt(count);

                for (int j = 0; j < k; j++) {
                    for (Character c : temp.toCharArray()) {
                        stack.addFirst(c);
                    }
                }
            }
        }
        return res;
    }

    // the best solution

    public String decodeString3(String s) {
        if (s == null || s.length() == 0) {
            return new String("");
        }
        Deque<Character> stack = new ArrayDeque<>();
        int i = 0;
        stack.addFirst(s.charAt(i++));

        while (!stack.isEmpty()) {
            while (i < s.length() && s.charAt(i) != ']') {
                stack.addFirst(s.charAt(i++));
            }
            i++;


            String temp = new String("");
            while (!stack.isEmpty() && stack.peekFirst() != '[') {
                temp = stack.removeFirst() + temp;
            }

            if (stack.isEmpty()) {
                return temp;
            }
            if (stack.peekFirst() == '[') {
                stack.removeFirst();
            }


            String count = new String("");
            while (!stack.isEmpty() && Character.isDigit(stack.peekFirst())) {
                count = stack.removeFirst() + count;
            }

            int k = Integer.valueOf(count);  // Integer.valueOf() 只能转换int string，不能是 character
            for (int j = 0; j < k; j++) {
                for (Character c : temp.toCharArray()) {
                    stack.addFirst(c);
                }
            }
        }
        return new String("");
    }
    private int convertToInt (String s) {
        int res = 0;
        for (Character c : s.toCharArray()) {
            res = res * 10 + (c - '0');
        }
        return res;
    }

    public static void main(String[] args) {
        DecodeString mytest = new DecodeString();
        System.out.println(mytest.decodeString3("3[a]4[b]"));
    }
}
