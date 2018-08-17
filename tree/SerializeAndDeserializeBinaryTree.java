package tree;
import java.util.*;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that
 * it can be stored in a file or memory buffer, or transmitted across a network connection link to be
 * reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can
 * be deserialized to the original tree structure.
 *
 * Example:
 *
 * You may serialize the following tree:
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * as "[1,2,3,null,null,4,5]"
 * Clarification: The above format is the same as how LeetCode serializes a binary tree.
 * You do not necessarily need to follow this format,
 * so please be creative and come up with different approaches yourself.
 *
 * Note: Do not use class member/global/static variables to store states.
 * Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeAndDeserializeBinaryTree {

    // solution 1 : iteratively
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return new String("");
        }
        StringBuilder res = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();

        // 必须在进 queue 之前 build string，
        // 因为 queue 中没有加入 # 占位符，丢失了节点之间的 父子 关系
        queue.offerLast(root);
        res.append(root.val);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.pollFirst();

            if (curr.left != null) {
                queue.offerLast(curr.left);
                res.append("," + curr.left.val);
            } else {
                res.append(",#");
            }

            if (curr.right != null) {
                queue.offerLast(curr.right);
                res.append("," + curr.right.val);
            } else {
                res.append(",#");
            }
        }
        String ans = res.toString();
        while(ans.charAt(ans.length() - 1) == '#' || ans.charAt(ans.length() - 1) == ',') {
            ans = ans.substring(0, ans.length() - 1);
        }
        return ans;
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] s = data.split(",");

        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(s[0]));
        queue.offerLast(root);

        int end = s.length;
        int index = 0;
        while (index < end) {
            TreeNode curr = queue.pollFirst();
            if (index + 1 < end && !s[index + 1].equals("#")) {
                curr.left = new TreeNode(Integer.valueOf(s[index + 1]));
                queue.offerLast(curr.left);
            }
            if (index + 2 < end && !s[index + 2].equals("#")) {
                curr.right = new TreeNode(Integer.valueOf(s[index + 2]));
                queue.offerLast(curr.right);
            }

            index += 2;
        }
        return root;
    }




    // solution 2 : recursive
    // print the tree in pre-order traversal and use "#" to denote null node and split node with ",".
    // [1,2] -->[1,2,#,#,#]   all null children filled with "#", including leaves.
    // We can use a StringBuilder for building the string on the fly.
    // For deserialize, we use a Queue to store the pre-order traversal and since we have "#" as null node,


    private static final String spliter = ",";
    private static final String NN = "#";

    public String serialize2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(root.val).append(spliter);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    public TreeNode deserialize2(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) {
            return null;
        }
        TreeNode newNode = new TreeNode(Integer.valueOf(val));
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }


    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree mytest = new SerializeAndDeserializeBinaryTree();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        n1.left = n2;

        String seri = mytest.serialize(n1);
        //System.out.println(seri);

        String seri2= mytest.serialize2(n1);
        System.out.println(seri2);


        TreeNode dese = mytest.deserialize(seri);
        TreeNode dese2 = mytest.deserialize(seri2);

        System.out.println(dese.val);
        System.out.println(dese.left.val);
    }
}
