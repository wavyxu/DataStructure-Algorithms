package backtrack;
import java.util.*;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 一共 n！种 permutation
 */
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] nums, List<Integer> prefix, List<List<Integer>> res) {
        if (prefix.size() == nums.length) {
            res.add(new ArrayList<>(prefix));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (prefix.contains(nums[i])) {
                continue;
            }
            prefix.add(nums[i]);
            helper(nums, prefix, res);
            prefix.remove(prefix.size() - 1);
        }
    }
}

