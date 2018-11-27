package backtrack;
import java.util.*;
/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> prefix = new ArrayList<>();

        Arrays.sort(nums);
        // example: input [1, 2, 3]
        helper(nums, 0, prefix, res);
        return res;

    }

    // solution 1 general DFS
    // 1、递归的定义
    // 在 nums[start]...nums[end] 中找到所有以 prefix 开头的集合，并放到 res 中
    // 例如，以 2 开头的，只需从 3。。。n 中找后续候选元素，不需要找 1 作为后续，
    // 因为 【1,2,...】已经作为以 1 开头的的子集了
    private void helper(int[] nums, int start, List<Integer> prefix, List<List<Integer>> res) {

        // 2. 递归的拆解
        // prefix 自身是一个所求子集合
        res.add(new ArrayList<>(prefix));

        // example : prefix = [1] , start = 1
        for (int i = start; i < nums.length; i++) {

            // [1] -> [1, 2]
            prefix.add(nums[i]);

            // prepare for [1, 2] -> [1, 2, 3]
            helper(nums, i + 1, prefix, res);

            // prepare for [1] -> [1, 3]
            prefix.remove(prefix.size() - 1);

        }

        // 3、递归的出口
        // return;
    }

    // solution 2 combination based DFS
    // 1、递归的定义
    // 类似位操作解法，拆解成 逐位判断 加 与 不加 对应的 nums[start] 字符
    private void helper2(int[] nums, int start, List<Integer> prefix, List<List<Integer>> res) {
        // 3、递归的出口
        // went throughout the nums[], then stop
        if (start == nums.length) {
            res.add(new ArrayList<>(prefix));
            return;
        }

        // 2. 递归的拆解 （如何进入下一层）

        // 第 start 位 加入 nums[start]
        prefix.add(nums[start]);
        helper(nums, start + 1, prefix, res);

        // 第 start 位 不加 nums[start]
        prefix.remove(prefix.size() - 1);
        helper(nums, start + 1, prefix, res);
    }
}
