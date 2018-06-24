package String;

/**
 * Description
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2
 *
 * Example
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class MutiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int len3 = len1 + len2 + 1;

        int[] num3 = new int[len3 + 3];

        int i, j, carry = 0;
        for (i = len1; i >= 0; i--) {
            int x = Character.valueOf(num1.charAt(i)) - '0';
            carry = 0;
            for (j = len2; j >= 0; j--) {
                int y = Character.valueOf(num2.charAt(j)) - '0';
                int product = x * y + carry + num3[i + j + 1];
                num3[i + j + 1] = product % 10;
                carry = product / 10;
            }
            num3[i + j + 1] = carry;
        }

        StringBuilder res = new StringBuilder();
        res = num3[0] == 0 ? res : res.append(num3[0]);
        for (int k = 1; k <= len3; k++ ) {
            res.append(num3[k]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        MutiplyStrings test = new MutiplyStrings();
        System.out.println(test.multiply("123", "45"));
    }


}
