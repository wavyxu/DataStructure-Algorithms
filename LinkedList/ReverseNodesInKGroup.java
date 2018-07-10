package LinkedList;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 */

/**
 * Given this linked list: dummy---->1---->2---->3---->4---->5
 *                            |      |     |     |
 *                            p      h    tail   temp
 *
 *  * For k = 2, you should return: dummy---->2---->1---->4---->3---->5
 *                                                  |     |     |     |
 *                                                  p     h    tail  temp
 *
 *    For k = 2, you should return: null<----1<----2<---dummy  ---->4---->3---->5
 *                                                         |        |     |     |
 *                                                         p        h    tail  temp
 *
 *  * For k = 3, you should return: dummy---->3---->2---->1---->4---->5
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        head = dummy;

        while (head.next != null) {
            head = reverse(head, k);
        }
        return dummy.next;
    }

    // input head -> 1 -> 2 - > 3
    // output head -> 2 -> 1 -> 3  : return ListNode : 1
    private ListNode reverse(ListNode head, int k) {
        // check there is enough nodes to reverse
        ListNode next = head;   // next.next point to the next head n(k+1)
        for (int i = 0; i < k; i++) {
            if (next.next == null) {
                return next;
            }
            next = next.next;
        }

        // reverse
        ListNode n1 = head.next;
        ListNode pre = head, curr = n1;

        for (int i = 0; i < k; i++) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }

        n1.next = curr;   // right now, curr is n(k+1), and will be the next new n1
        head.next = pre;  // right now, pre is the nk

        return n1;   // n1 will be the next new head
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup mytest = new ReverseNodesInKGroup();
        MyLinkedList myLinkedList =  new MyLinkedList();
        myLinkedList.add(0,1);
        myLinkedList.add(1,2);
        myLinkedList.add(2,3);
        myLinkedList.add(3,4);
        myLinkedList.add(4,5);
        System.out.println(mytest.reverseKGroup(myLinkedList.dummy.next, 2));
    }

}
