package tree;
import java.util.*;

/**
 * Description
 * Given a binary search tree and a node in it, find the in-order predecessor of that node in the BST.
 *
 * If the given node has no in-order predecessor in the tree, return null
 *
 * Have you met this question in a real interview?
 * Example
 * Given root = {2,1,3}, p = 1, return null.
 */
public class InorderPredecessorInBST {
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null) {
            return null;
        }

        // 丢掉 >= p.val 的部分，因为所求的 为 小于 p.val 的最大值
        if (root.val >= p.val) {
            return inorderPredecessor(root.left, p);
        } else {
            TreeNode right = inorderPredecessor(root.right, p);
            return right != null ? right : root;
        }
    }
}
