package backtrack;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * @author: Vivian Xu
 */

/**
 * Given a collection of numbers that might contain duplicates,
 * return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * solution
 * Use an extra boolean array " boolean[] used" to indicate whether the value is added to list.
 *
 * Sort the array "int[] nums" to make sure we can skip the same value.
 *
 * when a number has the same value with its previous, we can use this number only if his previous is used
 */
public class Permutation2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        boolean[] added = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, added, new ArrayList<Integer>(), res);
        return res;
    }

    private void helper(int[] nums, boolean[] added, List<Integer> prefix, List<List<Integer>> res) {
        if (prefix.size() == nums.length) {
            res.add(new ArrayList<>(prefix));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (added[i]) {
                continue;
            }
            if (i != 0 && nums[i] == nums[i - 1] && !added[i - 1]) {
                continue;
            }
            prefix.add(nums[i]);
            added[i] = true;
            helper(nums, added, prefix, res);
            prefix.remove(prefix.size() - 1);
            added[i] = false;
        }
    }
}
