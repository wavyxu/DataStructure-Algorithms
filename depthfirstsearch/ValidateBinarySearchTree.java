package depthfirstsearch;
import java.util.*;
/**
 * Description
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * A single node tree is a BST
 *
 * Example
 * An example:
 *
 *   2
 *  / \
 * 1   4
 *    / \
 *   3   5
 * The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).
 *
 * Example:
 *
 *      10
 *     /  \
 *    5   15
 *       /  \
 *      6   20
 *
 * answer: false
 */

class ResultType {
    boolean is_bst;
    int maxValue, minValue;

    ResultType(boolean is_bst, int maxValue, int minValue) {
        this.is_bst = is_bst;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }
}

public class ValidateBinarySearchTree {

    // solution 1: DFS non-recursion
    public boolean isValidBSTDFSNonrecursion (TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.addFirst(root);
                root = root.left;
            }
            root = stack.removeFirst();
            if (pre != null && root.val <= pre.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }



    // solution 2 : DFS Traversal recursion
    private int lastVal = Integer.MIN_VALUE;
    private boolean firstNode = true;
    public boolean isValidBSTDFS(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (!firstNode && lastVal >= root.val) {
            return false;
        }
        firstNode = false;
        lastVal = root.val;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }

    // solution 3: divide and conquer
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        long max = Long.MAX_VALUE;
        long min = Long.MIN_VALUE;

        return helper(root, min, max);
    }


    private boolean helper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        // both correct
        //return helper(root.left, min, Math.min(max, root.val)) && helper(root.right, Math.max(min, root.val), max);
        return helper(root.left, min, root.val)  // the max of left subtree is less and less
                && helper(root.right, root.val, max);  // the min of right subtree is bigger and bigger
    }

    /**
     * Example 2:
     *    10
     *    / \
     *   5   15
     *      / \
     *     6   20
     * Output: false
     *
     * node == null
     * ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE)
     * node.val == 20
     * return ResultType(true, 20, 20)
     * node.val == 6
     * return ResultType(true, 6, 6)
     * node.val == 15
     * return ResultType(true, 6, 20)
     * node.val == 5
     * return ResultType(true, 5, 5)
     * node.val == 10
     * return ResultType(false, 0, 0)
     * Stack
     *
     */

    // solution 2 : use result type
    public boolean isValidBST2(TreeNode root) {
        ResultType r = validateHelper(root);
        return r.is_bst;
    }

    private ResultType validateHelper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        ResultType left = validateHelper(root.left);
        ResultType right = validateHelper(root.right);

        if (!left.is_bst || !right.is_bst) {
            // if is_bst is false then minValue and maxValue are useless
            return new ResultType(false, 0, 0);
        }

        if (root.left != null && left.maxValue >= root.val ||
                root.right != null && right.minValue <= root.val) {
            return new ResultType(false, 0, 0);
        }

        return new ResultType(true,
                Math.max(root.val, right.maxValue),
                Math.min(root.val, left.minValue));
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(20);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        ValidateBinarySearchTree mytest = new ValidateBinarySearchTree();
//        System.out.println(mytest.isValidBST2(n1));
        System.out.println(mytest.isValidBSTDFS(n1));
    }

}
