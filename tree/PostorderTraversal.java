package tree;
import java.util.*;
/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
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
 * Output: [3,2,1]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        // create Linked List for insert to head.
        // So, we could reverse the order of result
        // left - right - root  ---->  root - right - left
        LinkedList<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                res.addFirst(root.val);
                if (root.left != null) {
                    stack.offerFirst(root.left);
                }
                root = root.right;
            }

            root = stack.pollFirst();
        }
        return res;
    }

    // another implementation method
    // left - right - root  ---->  root - right - left
    public List<Integer> postorderTraversal1(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pollFirst();
            res.addFirst(curr.val);
            if (curr.left != null) {
                stack.offerFirst(curr.left);
            }
            if (curr.right != null) {
                stack.offerFirst(curr.right);
            }
        }
        return res;
    }
}
