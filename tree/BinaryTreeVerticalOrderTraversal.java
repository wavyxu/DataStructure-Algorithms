package tree;
import java.util.*;

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 *
 * If two nodes are in the same row and column, the order should be from left to right.
 *
 * Examples 1:
 *
 * Input: [3,9,20,null,null,15,7]
 *
 *    3
 *   /\
 *  /  \
 *  9  20
 *     /\
 *    /  \
 *   15   7
 *
 * Output:
 *
 * [
 *   [9],
 *   [3,15],
 *   [20],
 *   [7]
 * ]
 * Examples 2:
 *
 * Input: [3,9,8,4,0,1,7]
 *
 *      3
 *     /\
 *    /  \
 *    9   8
 *   /\  /\
 *  /  \/  \
 *  4  01   7
 *
 * Output:
 *
 * [
 *   [4],
 *   [9],
 *   [3,0,1],
 *   [8],
 *   [7]
 * ]
 */
public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();

        if (root == null) {
            return res;
        }

        queue.offer(root);
        cols.offer(0);

        int min = 0, max = 0;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int col = cols.poll();
            mapping(map, col, curr.val);

            if (curr.left != null) {
                queue.offer(curr.left);
                cols.offer(col - 1);
                min = Math.min(min, col - 1);
            }

            if (curr.right != null) {
                queue.offer(curr.right);
                cols.offer(col + 1);
                max = Math.max(max, col + 1);
            }
        }


        // wrong, this way cannot guarantee the ascending order
        //for (Integer i : map.keySet()) {

        // for (int i = Collections.min(hash.keySet()); i <= Collections.max(hash.keySet()); i++) {
        //            ans.add(hash.get(i));
        //        }
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }

    private void mapping(Map<Integer, List<Integer>> map, int key, int value) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<Integer>());
            map.get(key).add(value);
        } else {
            map.get(key).add(value);
        }
    }
}
