package BitManipulation;

/**
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 *
 * Example 1:
 *
 * Input: 11
 * Output: 3
 * Explanation: Integer 11 has binary representation 00000000000000000000000000001011
 * Example 2:
 *
 * Input: 128
 * Output: 1
 * Explanation: Integer 128 has binary representation 00000000000000000000000010000000
 */
public class NumberOf1Bits {
    // the best solution; the numbers of loop just equals the number of 1 bits
    public int hammingWeight(int n) {
        int weight = 0;
        while (n != 0) {
            n = n & (n - 1);
            weight ++;
        }
        return weight;
    }
    public int hammingWeight1(int n) {
        int weight = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                weight++;
            }
            n >>>= 1;
        }
        return weight;
    }
}
