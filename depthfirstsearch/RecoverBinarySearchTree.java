package depthfirstsearch;
import apple.laf.JRSUIUtils;

import java.util.*;
/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Example 1:
 *
 * Input: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * Output: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 * Example 2:
 *
 * Input: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * Output: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 * Follow up:
 *
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 * **/

/**
 * Explanation:
 *
 * 通过中序遍历，只不过，不需要存储每个节点，只需要存一个前驱即可。
 * 例如1,4,3,2,5,6
 * 1.当我们读到4的时候，发现是正序的，不做处理
 * 2.但是遇到3时，发现逆序，将4存为第一个错误节点，3存为第二个错误节点
 * 3.继续往后，发现3，2又是逆序了，那么将第2个错误节点更新为2
 *
 * 为什么要替换第二个节点而不是第一个节点：
 * Find the place which the order is wrong.
 *         Wrong order: 1 3 8 6 7 4 10 13 14
 *         FIND:                    8 6
 *         Then we find:             7 4
 *         8, 6 是错误的序列, 但是，7，4也是错误的序列。
 *         因为8，6前面的序列是正确的，所以8，6一定是后面的序列交换来的。
 *         而后面的是比较大的数字，也就是说8一定是被交换过来的。而7，4
 *         中也应该是小的数字4是前面交换过来的。
 *
 */
public class RecoverBinarySearchTree {
    private TreeNode firstElement = null;
    private TreeNode secondElement = null;
    private TreeNode pre = new TreeNode(Integer.MIN_VALUE);

    // iterative inorder
    public void recoverTree(TreeNode root) {
        // inorder traversal
        iterativeTraversal(root);

        // swap the found two elements
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private void iterativeTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.addFirst(root);
                root = root.left;
            }
            root = stack.pollFirst();
            // If first element has not been found, assign it to prevElement
            if (firstElement == null && root.val < pre.val) {
                firstElement = pre;

            }
            // If first element is found, assign the second element to the root
            if (firstElement != null && root.val < pre.val) {
                secondElement = root;
            }

            pre = root;
            root = root.right;

        }
    }

    // recursive inorder
    public void recoverTreeRecursive(TreeNode root) {

        helper(root);

        int temp = secondElement.val;
        secondElement.val = firstElement.val;
        firstElement.val = temp;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }       helper(root.left);

        // If first element has not been found, assign it to prevElement
        if (firstElement == null && root.val < pre.val) {
            firstElement = pre;
            //secondElement = root;   // could merge to the next for loop
        }

        // If first element is found, assign the second element to the root
        if (firstElement != null && root.val < pre.val) {
            secondElement = root;
        }

        pre = root;
        helper(root.right);
    }

}
