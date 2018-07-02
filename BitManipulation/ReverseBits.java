package BitManipulation;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * Example:
 *
 * Input: 43261596
 * Output: 964176192
 * Explanation: 43261596 represented in binary as 00000010100101000001111010011100,
 *              return 964176192 represented in binary as 00111001011110000010100101000000.
 * Follow up:
 * If this function is called many times, how would you optimize it?
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                res |= (1 << (31 - i));
            }
        }
        return res;
    }

    public int reverseBits1(int n) {
        int res = 0;
        for(int i=0; i<32; i++){
            res = (res << 1) | ( n & 1);
            n = (n >> 1);
        }

        return res;
    }

    public static void main(String[] args) {
        ReverseBits test = new ReverseBits();
        System.out.println(test.reverseBits1(1));
    }
}
