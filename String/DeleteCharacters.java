package String;

/**
 * Description
 * Input two strings s and t，determine if s can get t after deleting some characters.
 *
 * 1 \leq |s|, |t| \leq 10^51≤∣s∣,∣t∣≤10
 * ​5
 * ​​
 * String contains only lowercase letters
 * Example
 * Given s="abc", t="c" , return True.
 *
 * Explanation:
 * s delete 'a' and 'b' to get t.
 * Given s="a", t="c" , return False.
 *
 * Explanation:
 * s cannot get t after deleting some characters.
 */
public class DeleteCharacters {
    private int hasChar(String s, char target, int start) {
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == target) {
                return i;
            }
        }

        return -1;
    }
    public boolean canGetString(String s, String t) {
        // Write your code here
        int begin = 0;
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            index = hasChar(s, t.charAt(i), begin);
            if (index == -1) {
                return false;
            } else {
                begin = index + 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DeleteCharacters test = new DeleteCharacters();
        System.out.println(test.canGetString("342asdg12", "2s2"));
    }
}
