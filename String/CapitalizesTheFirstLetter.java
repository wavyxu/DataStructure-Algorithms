package String;

/**
 * Description
 * Given a sentence of English, update the first letter of each word to uppercase.
 *
 * The given sentence may not be a grammatical sentence.
 * The length of the sentence does not exceed 100.

 * Example
 * Given s = "i want to get an accepted", return "I Want To Get An Accepted".
 */
public class CapitalizesTheFirstLetter {
    public String capitalizesFirst(String s) {
        // Write your code here
        char[] chars = s.toCharArray();

        if (chars[0] != ' ') {
            chars[0] = Character.toUpperCase(chars[0]);
        }

        for (int i = 1; i < s.length(); i++) {

            if (chars[i - 1] == ' ' && chars[i] != ' ') {
                chars[i] = Character.toUpperCase(chars[i]);
            }

        }

        return new String(chars);
    }

    public static void main(String[] args) {
        CapitalizesTheFirstLetter mytest = new CapitalizesTheFirstLetter();
        System.out.println(mytest.capitalizesFirst("i want to get an accepted"));
    }
}
