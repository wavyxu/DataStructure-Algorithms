package tree;
import java.util.*;

/**
 *
 * Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.
 *
 * A node is deepest if it has the largest depth possible among any node in the entire tree.
 *
 * The subtree of a node is that node, plus the set of all descendants of that node.
 *
 * Return the node with the largest depth such that it contains all the deepest nodes in its subtree.
 *
 *
 *
 * Example 1:
 *
 * Input: [3,5,1,6,2,0,8,null,null,7,4]
 * Output: [2,7,4]
 *
 * Explanation:
 *                   3
 *                /     \
 *               /       \
 *              /         \
 *             5          1
 *            / \        / \
 *           6  2       0  8
 *             / \
 *            7  4
 *
 * We return the node with value 2, colored in yellow in the diagram.
 * The nodes colored in blue are the deepest nodes of the tree.
 * The input "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" is a serialization of the given tree.
 * The output "[2, 7, 4]" is a serialization of the subtree rooted at the node with value 2.
 * Both the input and output have TreeNode type.
 *
 * Example 2
 *
 *        1
 *      /   \
 *     2    3
 *    /
 *   4
 *
 * Return : 4
 */


class ResultType {
    public TreeNode node;
    public int dis;
    public ResultType(TreeNode node, int dis) {
        this.node = node;
        this.dis = dis;
    }
}

public class SmallestSubtreeWithAllTheDeepestNodes {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return helper(root).node;

    }
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(null, 0);
        }

        ResultType l = helper(root.left);
        ResultType r = helper(root.right);

        if (l.dis > r.dis) {
            return new ResultType(l.node, l.dis + 1);
        }

        if (r.dis > l.dis) {
            return new ResultType(r.node, r.dis + 1);
        }

        // r.dis == l.dis
        // 当左右子树高度一样，返回该节点
        // 从 下 往 上 找
        return new ResultType(root, l.dis + 1);

    }
}
