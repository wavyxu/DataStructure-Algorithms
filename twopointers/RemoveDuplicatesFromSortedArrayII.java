package twopointers;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 *
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDulpicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        if (nums.length <= 2 ) {
            return nums.length;
        }

        int l = 2;
        int r = 2;

        for(; r < nums.length; r++) {
            //if (nums[r] != nums[l - 1] || nums[r] != nums[l - 2]) {
            if (nums[r] != nums[l - 2]) {
                swap(nums, l, r);
                l++;
            }
        }
//        while(r < nums.length) {
//             if (nums[r] == nums[l - 1] && nums[r] == nums[l - 2]) {
//                 r++;
//
//             } else if (nums[r] != nums[l - 1] || nums[r] != nums[l - 2]) {
//                 swap(nums, l, r);
//                 l++;
//                 r++;
//             }
//         }
        return l;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
    public static void main(String[] args) {
        int[] src = new int[] {1,1,1,2,2,3};
        RemoveDuplicatesFromSortedArrayII mytest = new RemoveDuplicatesFromSortedArrayII();
        int res = mytest.removeDulpicates(src);
        for (int num : src) {
            System.out.print(num );
            System.out.print(",");
        }
        System.out.println();

        System.out.println(res);

    }
}
