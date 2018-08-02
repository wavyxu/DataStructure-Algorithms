package tree;
import java.util.*;
public class PreOrderTraverse {
    // iteratively, only put right nodes into stack
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode node = root;

        // only store right nodes
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);

                if (node.right != null) {
                    // 为什么 preorder 可以只进栈右子节点，而不需要进栈右子树所有节点？
                    // 因为 从 stack pop 出右子节点后，会循环所有该点的 左子节点 并放入 result
                    // 而 inorder 则不能只进栈右子节点，它需要进栈所有子节点
                    stack.offerFirst(node.right);
                }
                node = node.left;
            }

            node = stack.pollFirst();
        }
        return res;
    }

    // iterative put all nodes into stack
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pollFirst();
            res.add(curr.val);

            if (curr.right != null) {
                stack.offerFirst(curr.right);
            }
            if (curr.left != null) {
                stack.offerFirst(curr.left);
            }
        }
        return res;
    }

    // recursive
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }
}
