package backtrack;
import java.util.ArrayList;
import java.util.List;
/**
 * @author: Vivian Xu
 */

/**
 *  * Description
 *  * Your are given a binary tree in which each node contains a value.
 *  * Design an algorithm to get all paths which sum to a given value.
 *  * The path does not need to start or end at the root or a leaf, but it must go in a straight line down.
 *  *
 *  * Have you met this question in a real interview?
 *  * Example
 *  * Given a binary tree:
 *  *
 *  *     1
 *  *    / \
 *  *   2   3
 *  *  /   /
 *  * 4   2
 *  * for target = 6, return
 *  *
 *  * [
 *  *   [2, 4],
 *  *   [1, 3, 2]
 *  * ]
 */
public class PathSum3 {
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(root, target, cur, res);
        return res;
    }
    public void helper(TreeNode root, int target, List<Integer>cur, List<List<Integer>> res) {
        if(root == null) {
            return;
        }
        cur.add(root.val);
        addValid(target, cur, res);

        helper(root.left, target, cur, res);
        helper(root.right, target, cur, res);
        cur.remove(cur.size() - 1);
    }
    public void addValid(int target, List<Integer> cur, List<List<Integer>> res) {
        int sum = 0;
        for(int i = cur.size() - 1 ; i >= 0; i--) {
            sum += cur.get(i);
            if(sum == target) {
                List<Integer> temp = new ArrayList<>(cur.subList(i, cur.size()));
                res.add(temp);
            }
        }
    }


    //solution 2 not pass
    public List<List<Integer>> binaryTreePathSum2_2(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        pathSum(root, target, res);
        return  res;
    }
    private void pathSum(TreeNode root, int target, List<List<Integer>> res) {
        if(root == null) {
            return;
        }
        sumHelper(root, target, new ArrayList<Integer>(), res);
        pathSum(root.left, target, res);
        pathSum(root.right, target, res);
    }
    // 以 node 为起点的 paths
    public void sumHelper(TreeNode node, int sum, List<Integer> temp, List<List<Integer>> res) {
        if(node == null) {
            return;
        }
        temp.add(node.val);
        if (node.val == sum) {
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            return;
        }
        sumHelper(node.left, sum - node.val, temp, res);
        sumHelper(node.right, sum - node.val, temp, res);
        temp.remove(temp.size() - 1);
    }
}
