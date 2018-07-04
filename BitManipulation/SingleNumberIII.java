package BitManipulation;

/**
 *Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
 * Find the two elements that appear only once.
 *
 * Example:
 *
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * Note:
 *
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        //In the first pass, get the XOR of the two numbers we need to find
        for (int num : nums) {
            xor ^= num;
        }

        /**
         *  The diff &= -diff is just an abbreviation with the knowledge of ~(diff - 1) = - (diff - 1) - 1 = -diff.
         *
         *  xor &= -xor;
         */
        // Find out an arbitrary set bit (for example, the rightmost set bit)
        xor = xor - (xor & (xor - 1));

        // Store the two numbers we will return
        int[] res = new int[] {0, 0};

        for (int num : nums) {
            if ((num & xor) == 0) {       // the test bit is not set
                res[0] ^= num;
            } else {          // the test bit is set
                res[1] ^= num;
            }
        }
        return res;
    }
}
