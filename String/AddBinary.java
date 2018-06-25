package String;

/**
 * Description
 * Given two binary strings, return their sum (also a binary string).
 *
 * Have you met this question in a real interview?
 * Example
 * a = 11
 *
 * b = 1
 *
 * Return 100
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        // write your code here
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        String sum = new String("");
        while (i >= 0 || j >= 0) {
            char aChar = i < 0 ? '0' : a.charAt(i--);
            char bChar = j < 0 ? '0' : b.charAt(j--);

            int tempSum = aChar - '0' + bChar - '0' + carry;
            sum = tempSum % 2 + sum;
            carry = tempSum / 2;

        }
        sum = carry == 0 ? sum : carry + sum;
        return sum.toString();
    }

    public String addBinary1(String a, String b) {
        // write your code here
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sum = new StringBuilder();
        while (i >= 0 || j >= 0) {
            char aChar = i < 0 ? '0' : a.charAt(i--);
            char bChar = j < 0 ? '0' : b.charAt(j--);

            int tempSum = aChar - '0' + bChar - '0' + carry;
            sum.append(tempSum % 2);
            carry = tempSum / 2;

        }
        sum = carry == 0 ? sum : sum.append(carry);
        return sum.reverse().toString();
    }
}
