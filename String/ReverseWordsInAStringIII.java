/**
 *Description
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 * In the string, each word is separated by single space and there will not be any extra space in the string.
 *
 * Example
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 */

package String;

public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        // Write your code here
        StringBuilder res = new StringBuilder();
        String[] strings = s.split(" ");
        for (String curr : strings) {
            res.append(new StringBuffer(curr).reverse().toString() + ' ');
        }
        return res.toString().trim();
    }


    public static void main(String[] args) {
        ReverseWordsInAStringIII rev = new ReverseWordsInAStringIII();
        String ans = rev.reverseWords("Hello Word! I'm Wei Xu");
        System.out.println(ans);
    }
}
