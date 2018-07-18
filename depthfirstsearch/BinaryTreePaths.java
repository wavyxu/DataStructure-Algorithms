package depthfirstsearch;
import java.util.*;

public class BinaryTreePaths {
    // Solution 1 : Divide Conquer
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res.add(new String("" + root.val));
            return res;
        }

        List<String> resLeft = binaryTreePaths(root.left);
        List<String> resRight = binaryTreePaths(root.right);

        for (String s : resLeft) {
            res.add(root.val+"->"+s);
        }

        for (String s : resRight) {
            res.add(root.val+"->"+s);
        }

        return res;
    }

    // solution 2: Traversal
    public List<String> binaryTreePathsTraversal(TreeNode root) {
        // write your code here

        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        helper(root, String.valueOf(root.val), result);
        return result;
    }

    private void helper(TreeNode root, String path, List<String> result) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        if (root.left != null) {
            helper(root.left, path + "->" + String.valueOf(root.left.val), result);
        }

        if (root.right != null) {
            helper(root.right, path + "->" + String.valueOf(root.right.val), result);
        }
    }
}
