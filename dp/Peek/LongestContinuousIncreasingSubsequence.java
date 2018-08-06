package dp.Peek;

/**
 * Give an integer array，find the longest increasing continuous subsequence in this array.
 *
 * An increasing continuous subsequence:
 *
 * Can be from right to left or from left to right.
 * Indices of the integers in the subsequence should be continuous.
 *
 * Example
 * For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.
 *
 * For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.
 */
public class LongestContinuousIncreasingSubsequence {
    // space optimized DP
    public int longestIncreasingContinuousSubsequence2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;

        int incL = 1;
        int decL = 1;
        int res = 1;
        for (int i = 1; i < n ; i++) {
            if (nums[i] > nums[i - 1])
            {
                incL = incL + 1;
                decL = 1;
            }
            else {
                incL = 1;
                decL = decL + 1;
            }
            res = Math.max(res, incL);
            res = Math.max(res, decL);
        }
        return res;
    }

    public int longestIncreasingContinuousSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] f = new int[n];  // longest increasing sub end with nums[i];
        int[] d = new int[n];
        f[0] = 1;
        d[0] = 1;
        int res = 1;
        for (int i = 1; i < n ; i++) {
            if (nums[i] > nums[i - 1])
            {
                f[i] = f[i - 1] + 1;
                d[i] = 1;
            }
            else {
                f[i] = 1;
                d[i] = d[i - 1] + 1;
            }
            res = Math.max(res, f[i]);
            res = Math.max(res, d[i]);
        }
        return res;
    }

}
