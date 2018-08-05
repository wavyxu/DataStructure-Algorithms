package array;
import java.util.*;

/**
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 *
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 * Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
 *
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2], its length is 1.
 * Note: Length of the array will not exceed 10,000.
 *
 */
public class LongestContinuousIncreaseingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int increase = longestIncreasing(nums);
        int decrease = longestDecreasing(nums);
        return Math.max(increase, decrease);
    }

    private int longestIncreasing(int[] nums) {
        int res = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                res = Math.max(res, count);
                count = 1;
            }
        }
        return Math.max(res, count);
    }

    private int longestDecreasing(int[] nums) {
        int res = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
            } else {
                res = Math.max(res, count);
                count = 1;
            }
        }
        return Math.max(res, count);
    }

    public static void main(String[] args) {
        int[] src = new int[] {1, 3, 5, 4, 7};
        LongestContinuousIncreaseingSubsequence mytest = new LongestContinuousIncreaseingSubsequence();
        System.out.println(mytest.findLengthOfLCIS(src));
    }
}
