package backtrack;

import java.util.List;
import java.util.ArrayList;
/**
 * @author: Vivian Xu
 */

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> temp = new ArrayList<Integer>();

        helper(root, sum, temp, res);
        return res;
    }

    private void helper(TreeNode root, int target, List<Integer> temp, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        if (root.left == null && root.right == null && target == root.val) {
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            return;
        } else {
            helper(root.left, target - root.val, temp, res);
            helper(root.right, target - root.val, temp, res);
            temp.remove(temp.size() - 1);
        }

    }

    private void helper2(TreeNode root, int target, List<Integer> temp, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        if (root.left == null && root.right == null && target == root.val) {
            res.add(new ArrayList<>(temp));
        }

        helper(root.left, target - root.val, temp, res);
        helper(root.right, target - root.val, temp, res);

        temp.remove(temp.size() - 1);
    }

    private void helper3(TreeNode root, int target, List<Integer> temp, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        if (root.left == null && root.right == null && target == root.val) {
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            return;
        }

        helper(root.left, target - root.val, temp, res);
        helper(root.right, target - root.val, temp, res);
        temp.remove(temp.size() - 1);
    }
}

