package twopointers;

/**
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a contiguous subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while (r < nums.length) {
           if (sum < s) {
               sum += nums[r++];
           }
           while (sum >= s) { //  如果此处用 if， 那么 r 到达最右， l 就不能往右了
               res = Math.min(res, r - l);
               sum -= nums[l++];
           }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum mytest = new MinimumSizeSubarraySum();
        int[] src = new int[] {2,3,1,2,4,3};
        System.out.println(mytest.minSubArrayLen(7, src));
    }
}
