package dp;
import java.util.*;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution,
 * try coding another solution using the divide and conquer approach,
 * which is more subtle.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        long[] f = new long[n];  // f[i] represent the max subArray which is end with nums[i]
        long max = nums[0];
        f[0] = nums[0];

        for (int i = 1; i < n ; i++) {
            // if the length of max subArray (f[i]) is more than 1, it must include f[i - 1];
            f[i] = f[i - 1] > 0 ? f[i - 1] + nums[i] : nums[i];
            max = Math.max(max, f[i]);
        }
        return (int)max;
    }
}
