package tree;
import java.util.*;

/**
 * Description
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
 *
 * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 *
 * Assume two nodes are exist in tree.
 *
 * Have you met this question in a real interview?
 * Example
 * For the following binary tree:
 *
 *   4
 *  / \
 * 3   7
 *    / \
 *   5   6
 * LCA(3, 5) = 4
 *
 * LCA(5, 6) = 7
 *
 * LCA(6, 7) = 7
 */
public class LowestCommonAncestorOfBT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null) {
            return null;
        }

        if (root.val == A.val || root.val == B.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        // Left has a target node, and right has another one
        if (left != null && right != null) {
            return root;
        }

        // When a left / subtree  has any target, return null
        return left == null ? right : left;
    }
}
