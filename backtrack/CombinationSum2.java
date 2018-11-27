package backtrack;
import java.util.*;
/**
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * Notice
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        helper(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] nums, int target, int start, List<Integer> prefix, List<List<Integer>> res) {
        // 错，start == nums.length 为 start 的 最大值，仍需进入函数检查是否 target 为 0
        // if (start == nums.length) {
        //     return;
        // }
        if (target == 0) {
            res.add(new ArrayList<>(prefix));
            //return;  不能 return，考虑负数
        }

        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > target) {
                break;
            }
            prefix.add(nums[i]);
            helper(nums, target - nums[i], i + 1, prefix, res);
            prefix.remove(prefix.size() - 1);
        }
    }
}
