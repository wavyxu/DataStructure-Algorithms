package tree;
import java.util.*;

/**
 * Given a Binary Search Tree and a target number,
 * return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * Example 1:
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * Output: True
 * Example 2:
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * Output: False
 */
public class TwoSumIV {
    // solution 1 BFS + hash
    public boolean findTarget1(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        Set<Integer> hash = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (hash.contains(k - node.val)) {
                return true;
            } else {
                hash.add(node.val);
            }
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return false;
    }
//    private boolean find(TreeNode root, int k, Set<Integer> hash) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (hash.contains(k - node.val)) {
//                return true;
//            } else {
//                hash.add(node.val);
//            }
//            if (node.left != null) queue.offer(node.left);
//            if (node.right != null) queue.offer(node.right);
//        }
//        return false;
//    }
public boolean findTarget(TreeNode root, int k) {
    List < Integer > list = new ArrayList();
    inorder(root, list);
    int l = 0, r = list.size() - 1;
    while (l < r) {
        int sum = list.get(l) + list.get(r);
        if (sum == k)
            return true;
        if (sum < k)
            l++;
        else
            r--;
    }
    return false;
}
    public void inorder(TreeNode root, List < Integer > list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
