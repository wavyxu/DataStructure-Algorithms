package backtrack;

import java.util.*;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void helper(int[] nums, int start, List<Integer> prefix, List<List<Integer>> res) {
        res.add(new ArrayList<>(prefix));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            prefix.add(nums[i]);
            helper(nums, i + 1, prefix, res);
            prefix.remove(prefix.size() - 1);
        }
    }
}
