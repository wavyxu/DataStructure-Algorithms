package tree;


import java.util.*;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 *
 * Note: If the given node has no in-order successor in the tree, return null.
 *
 * Example 1:
 *
 * Input: root = [2,1,3], p = 1
 *
 *   2
 *  / \
 * 1   3
 *
 * Output: 2
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * Output: null
 */

/**
 *  Inorder Successor of an input node can also be defined as the node with the smallest key
 *  greater than the key of input node.
 *  So, it is sometimes important to find next node in sorted order.
 */
public class InorderSuccessorInBST {

    // best solution : Binary Search , Time: O(n), h is the height of the tree

    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        // 丢掉 <= p.val 的部分，因为所求的 为 大于 p.val 的最小值
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return left != null ? left : root;
        }
    }
    private Deque<tree.TreeNode> stack = new ArrayDeque<>();

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        if (root == null) {
            return null;
        }
        pushAllLeft(root);
        while (!stack.isEmpty() || root != null) {

            root = stack.pollFirst();
            pushAllLeft(root.right);
            if (root == p) {
                return stack.pollFirst();
            }
            root = root.right;
        }

        return null;
    }

    private void pushAllLeft(tree.TreeNode root) {
        tree.TreeNode node = root;
        while (node != null) {
            stack.offerFirst(node);
            node = node.left;
        }
    }


}
