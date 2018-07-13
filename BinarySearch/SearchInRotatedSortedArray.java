package BinarySearch;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;

        while (l < r - 1) {
            int mid = l + (r - l ) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[r] < nums[mid]  ) {
                // both ok.
                // if (target >= nums[l] && target <= nums[mid]) {
                if (target > nums[r] && target <= nums[mid]) {
                    r = mid;
                } else {
                    l = mid;
                }
            } else {
                if ((target <= nums[r]) && (target >= nums[mid])) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
        }
        if (nums[l] == target) return l;
        if (nums[r] == target) return r;
        return -1;
    }
}
