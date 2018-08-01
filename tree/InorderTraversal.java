package tree;
import java.util.*;
/**
 *Given a binary tree, return the inorder traversal of its nodes' values.
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
 *
 * Example:
 * the value represent the order of putting into stack
 *               1
 *             /   \
 *            /     \
 *            2     11
 *         /     \
 *        3       7
 *         \    /  \
 *         4   8   10
 *        /   /
 *       5   9
 *      /
 *     6
 *
 *
 *
 *
 *
 */

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.offerFirst(node);
                node = node.left;
            }

            node = stack.pollFirst();
            res.add(node.val);

            node = node.right;

            // 下面有错。所有节点都需要入栈，只有从栈里pop出的节点才写进了result

//            if (curr.right != null) {
//                stack.offerFirst(curr.right);
//            }
        }
        return res;
    }

    public  List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }
}
