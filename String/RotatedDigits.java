package String;

/**
 * Description
 * X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X. Each digit must be rotated - we cannot choose to leave it alone.
 *
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.
 *
 * Now given a positive number N, how many numbers X from 1 to N are good?
 *
 * N will be in range [1, 10000].
 * Example
 * Example:
 *
 * Input: 10
 * Output: 4
 * Explanation:
 * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 * Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 */
public class RotatedDigits {
    private boolean isGood(int n) {
        boolean res = false;
        while (n > 0) {
            int digit = n % 10;

            switch(digit) {
                case 9 : res = true; break;
                case 6 : res = true; break;
                case 5 : res = true; break;
                case 2 : res = true; break;
                case 3 : return false;
                case 4 : return false;
                case 7 : return false;
            }
            n /= 10;
        }
        return  res;

    }
    public int rotatedDigits(int N) {
        // write your code here
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if(isGood(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        RotatedDigits test = new RotatedDigits();
        int res = test.rotatedDigits(10);
        System.out.println(res);
    }

}
