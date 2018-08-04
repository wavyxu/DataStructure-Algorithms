package binarysearch;

/**
 *Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *
 * Note:
 *
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 * Example:
 *
 * Input: root = [4,2,5,1,3], target = 3.714286
 *
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 *
 * Output: 4
 */
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;

        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(res - target)) {
                res = root.val;
            }

            root = root.val > target ? root.left : root.right;
        }

        return res;
    }

    // 利用二分法找出左右子树 中 最有可能 出现结果的子树，设定为目标子树
    // 找出子树中最接近 target 的值
    // 对比子树返回的结果，和自身 root.val 相比，谁更接近 target
    // exit condition ： 碰到目标子树为空， 返回自己的 value
    public int closestValueRecurive(TreeNode root, double target) {
        int currVaule = root.val;
        TreeNode nextRoot = currVaule > target ? root.left : root.right;
        if (nextRoot == null) {
            return root.val;
        }
        int nextValue = closestValueRecurive(nextRoot, target);
        return Math.abs(currVaule - target) > Math.abs(nextValue - target) ? nextValue : currVaule;
    }
}
