package tree;
import java.util.*;
/**
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class SumOfLeftLeaves {
    private int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        sum(root);
        return sum;
    }

    private void sum (TreeNode root) {
        if (root == null) {
            return;
        }
        if (isLeaf(root.left)) {
            sum += root.left.val;
        }

        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
    }

    private boolean isLeaf (TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }
}
