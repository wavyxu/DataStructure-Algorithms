package String;

/**
 * Given a string, determine if it is a palindrome,
 * considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (Character.isLetterOrDigit(s.charAt(l)) &&
                    Character.isLetterOrDigit(s.charAt(r)) &&
                    Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            } else if (Character.isLetterOrDigit(s.charAt(l)) &&
                    Character.isLetterOrDigit(s.charAt(r)) &&
                    Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r))) {
                l++;
                r--;
            }
        }
        return true;
    }
}
