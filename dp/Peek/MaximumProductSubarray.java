package dp;
import java.util.*;

/**
 * Description
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 *
 *
 * Example
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        long[] f = new long[n];  // f[i] represent the max product which is end with nums[i];
        long[] g = new long[n]; // g[i] represent the min product which is end with nums[i];

        long res = nums[0];
        f[0] = nums[0];
        g[0] = nums[0];

        for (int j = 1; j < n; j++) {
            f[j] = Math.max(nums[j], Math.max(f[j - 1] * nums[j], g[j - 1] * nums[j]));
            g[j] = Math.min(nums[j], Math.min(f[j - 1] * nums[j], g[j - 1] * nums[j]));
            res = Math.max(res, f[j]);
        }

        return  (int)res;

    }
}
