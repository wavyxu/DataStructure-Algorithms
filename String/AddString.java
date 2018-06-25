package String;

/**
 * Description
 * Given two non-negative integers num1 and num2 represented as string,
 * return the sum of num1 and num2.
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.

 * Example
 * Given num1 = "123", num2 = "45"
 * return "168"
 */
public class AddString {
    public String addStrings(String num1, String num2) {
        // write your code here
        int len1 = num1.length();
        int len2 = num2.length();

        int i = len1 - 1;
        int j = len2 - 1;
        String res = "";
        int carry = 0;
        while (i >= 0 || j >=0) {
            int a, b;
            if (i >= 0) {
                a = num1.charAt(i--) - '0';
            } else {
                a = 0;
            }

            if (j >= 0 ) {
                b = num2.charAt(j--) - '0';
            } else {
                b = 0;
            }

            int sum = a + b + carry;
            //res = (sum % 10 ) + res;
            res = (char)(sum % 10 + '0') + res;
            carry = sum / 10;
        }

        return carry == 1 ? 1 + res : res;
    }
    public static void main(String[] args) {
        AddString test = new AddString();
        System.out.println(test.addStrings("123", "45"));
    }
}
