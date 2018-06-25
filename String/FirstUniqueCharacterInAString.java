package String;
import java.util.*;

/**
 * Description
 * Find the first unique character in a given string.
 * You can assume that there is at least one unique character in the string.
 *
 * Example
 * For "abaccdeff", return 'b'.
 */
public class FirstUniqueCharacterInAString {
    public char firstUniqChar(String str) {
        // Write your code here
        Set<Character> letters = new HashSet<>();
        Set<Character> discard = new HashSet<>();

        char[] chs = str.toCharArray();
        for (char ch : chs) {
            if (letters.contains(ch)) {
                discard.add(ch);
            } else {
                letters.add(ch);
            }
        }

        for (char ch : chs) {
            if (!discard.contains(ch)) {
                return ch;
            }
        }

        return '0';
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInAString test = new FirstUniqueCharacterInAString();
        System.out.println(test.firstUniqChar("abaccdeff"));
    }
}
