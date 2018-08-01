package binarysearch;
import java.util.*;

/**
 * Let's take the following BST as an example, it may help you understand the problem better:
 *
 *
 *
 *
 *
 *  We want to transform this BST into a circular doubly linked list.
 *  Each node in a doubly linked list has a predecessor and successor.
 *  For a circular doubly linked list, the predecessor of the first element is the last element,
 *  and the successor of the last element is the first element.
 *
 *  The figure below shows the circular doubly linked list for the BST above.
 *  The "head" symbol means the node it points to is the smallest element of the linked list.
 *
 *
 *
 *
 *
 *  Specifically, we want to do the transformation in place.
 *  After the transformation, the left pointer of the tree node should point to its predecessor,
 *  and the right pointer should point to its successor.
 *  We should return the pointer to the first element of the linked list.
 *
 *  The figure below shows the transformed BST.
 *  The solid line indicates the successor relationship,
 *  while the dashed line means the predecessor relationship.
 */
public class ConvertBSTToSortedDoublyLinkedList {
    // solution 1 iteratively
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> stack = new ArrayDeque<>();
        Node dummy = new Node(-1, null , null);
        Node curr = root;
        Node pre = dummy;

        while(!stack.isEmpty() || curr != null) {
            while(curr != null) {
                stack.offerFirst(curr);
                curr = curr.left;
            }
            curr = stack.pollFirst();
            pre.right = curr;
            curr.left = pre;
            pre = curr;
            curr = curr.right;
        }

        pre.right = dummy.right;
        dummy.right.left = pre;
        return pre.right;
    }

    // solution 2 recursive
    public Node treeToDoublyList2(Node root) {
        if (root == null) {
            return null;
        }
        Node dummy = new Node(-1, null , null);
        Node previous = dummy;
        helper(root);

        // connect head to tail
        previous.right = dummy.right;
        dummy.right.left = previous;
        return dummy.right;
    }

    private void helper(Node root) {
        if (root == null) {
            return;
        }
        previous.right = helper(root.left);
        previous.right = root;
        root.left = previous;
        previous = root;
        helper(root.right);

    }
}
