package depthfirstsearch;
import java.util.*;
/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {
    // solution 1 : iteratively
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.addFirst(root);
                root = root.left;
            }
            root = stack.removeFirst();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    // solution 2: recursive

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        helper (root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;

        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }
}
