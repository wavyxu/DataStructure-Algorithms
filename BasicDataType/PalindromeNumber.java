package BasicDataType;

/**
 * Description
 * Check a positive number is a palindrome or not.
 *
 * A palindrome number is that if you reverse the whole number you will get exactly the same number.
 *
 * It's guaranteed the input number is a 32-bit integer, but after reversion, the number may exceed the 32-bit integer.
 *
 * Example
 * 11, 121, 1, 12321 are palindrome numbers.
 *
 * 23, 32, 1232 are not palindrome numbers.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int num) {
        // write your code here
        long rev = 0;
        int curr = num;
        while (curr > 0) {
            int mod = curr % 10;
            rev = rev * 10 + mod;
            curr /= 10;
        }

        return num == rev;
    }
}
