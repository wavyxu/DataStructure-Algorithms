package BitManipulation;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Note:
 * 0 ≤ x, y < 231.
 *
 * Example:
 *
 * Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * The above arrows point to positions where the corresponding bits are different.
 */
public class HammingDistance {

    // solution 1
    public int hammingDistance(int x, int y) {
        int diff = x ^ y;
        int hamming = 0;
        for (int i = 0; i < 32; i++) {
            if ((diff & (1 << i)) > 0) {
                hamming++;
            }
        }
        return hamming;
    }

    // solution 2
    public int hammingDistance2(int x, int y) {
        return bitCount2(x ^ y);
    }

    private int bitCount(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) > 0) {
                count++;
            }
        }
        return count;

    }

    private int bitCount2(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    // solution 3
    public int hammingDistance3(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        HammingDistance test = new HammingDistance();
        System.out.println(test.hammingDistance(10, 9));
        System.out.println(test.hammingDistance2(10, 9));
        System.out.println(test.hammingDistance3(10, 9));
    }
}
