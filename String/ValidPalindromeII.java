package String;

/**
 * Description
 * Given a non-empty string s, you may delete at most one character.
 * Judge whether you can make it a palindrome.
 *
 * The string will only contain lowercase characters a-z.
 * The maximum length of the string is 50000.
 *
 * Example
 * Given s = "aba" return true
 * Given s = "abca" return true // delete c
 */
public class ValidPalindromeII {
    private boolean isPalindrome(String s, int start, int end) {
        if (end - start < 2) {
            return true;
        }

        int l = start;
        int r = end;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    private int deleteChar(String s, int l, int r) {
        if (s.charAt(l + 1) != s.charAt(r) && s.charAt(l) != s.charAt(r - 1)) {
            return -1; //cannot make palindrome
        }
        if (s.charAt(l + 1) == s.charAt(r)) {
            return 1; // delete l
        }
        if (s.charAt(l) == s.charAt(r - 1)) {
            return 0; // delete r
        }
        return -1;
    }

    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            }
            l++;
            r--;
        }

        return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
    }

    public static void main(String[] args) {
        ValidPalindromeII test = new ValidPalindromeII();
        System.out.println(test.validPalindrome("abca"));
    }
}
