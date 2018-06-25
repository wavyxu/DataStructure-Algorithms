package BasicDataType;

/**
 * Description
 * Reverse digits of an integer. Returns 0 when the reversed integer overflows (signed 32-bit integer).
 *

 * Example
 * Given x = 123, return 321
 *
 * Given x = -123, return -321
 */
public class ReverseInteger {
    public int reverseInteger(int n) {
        // write your code here
        // -123 % 10 = -3; -123 / 10 = -12; -1 / 10 = 0;
        // res = 0; n = -123;
        // res = -3; n = -12
        // res = -32; n = -1;
        // res = -321; n = 0;
        int result = 0;
        while (n != 0) {
            int digit = n % 10;
            int newResult = result * 10 + digit;
            if (newResult / 10 == result && newResult % 10 == digit) {
                result = newResult;
                n /= 10;
            } else {
                result = 0;
                n /= 10;
            }
//            System.out.println("result: " + result);
//            System.out.println("n: " + n);
//            System.out.println("---------- ");
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseInteger test = new ReverseInteger();
        System.out.println(test.reverseInteger(1234));
        System.out.println(test.reverseInteger(-1234));
    }
}
