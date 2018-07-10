package twopointers;

/**
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {
    public void moveZeroesBest(int[] nums) {
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if (nums[l] == 0 && nums[r] != 0) {
                swap(nums, l, r);
                l++;
                r++;
            } else if (nums[r] == 0) {
                r++;
                if (nums[l] != 0) {
                    l++;
                }
            } else {          // nums[r]!=0 && nums[l] != 0
                r++;
                l++;
            }
        }
    }

    public void moveZeroes(int[] nums) {
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if(nums[r] != 0) {
                swap(nums, l, r);
                l++;
                r++;
            } else {
                r++;
            }
        }
    }

    public void swap(int[] nums, int x, int y) {
        int temp = nums[y];
        nums[y] = nums[x];
        nums[x] = temp;
    }

    // space O(1)
    // time O(n). However, the total number of operations are still sub-optimal.
    // The total operations (array writes) that code does is n (total number of elements)
    public void moveZeroes_(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        while (r < n) {
            if(nums[r] != 0) {
                nums[l++] = nums[r++];
            } else {
                r++;
            }
        }
        while (l < n) {
            nums[l++] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes mytest = new MoveZeroes();
        int[] src = new int[] {1,2,3,4,5};
        mytest.moveZeroesBest(src);
        System.out.println(src);
    }
}
