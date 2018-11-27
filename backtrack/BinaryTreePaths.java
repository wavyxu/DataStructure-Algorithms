package backtrack;
import java.util.List;
import java.util.ArrayList;
/**
 * @author: Vivian Xu
 */

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class BinaryTreePaths {
    // general DFS recursive solution
    public List<String> binaryTreePaths(TreeNode root) {
        List<List<String>> res =  new ArrayList<>();
        List<String> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        helper(root, new ArrayList<String>(), res);
        addConnection(res, ans);
        return ans;
    }
    private void helper(TreeNode root, List<String> temp, List<List<String>> res) {
        if (root == null) {
            return;
        }
        temp.add("" + root.val);
        if (root.left == null && root.right == null) {
            res.add(new ArrayList<>(temp));
        }
        helper(root.left, temp, res);
        helper(root.right, temp, res);
        temp.remove(temp.size() - 1);
    }
    private void addConnection(List<List<String>> res, List<String> ans) {
        for (List<String> path : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i));
                sb.append("->");
            }
            sb.append(path.get(path.size() - 1));
            ans.add(sb.toString());
        }
    }

    // solution 2
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> res =  new ArrayList<String>();
        if (root == null) {
            return res;
        }

        helper(root, String.valueOf(root.val), res);
        return res;
    }

    private void helper(TreeNode root, String temp, List<String> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(temp);
            return;
        }
        if (root.left != null) {
            helper(root.left, temp + "->" + root.left.val, res);
        }
        if (root.right != null) {
            helper(root.right, temp + "->" + root.right.val, res);
        }
    }
}
