package LinkedList;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Note:
 *
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class SwapNodesInPairs {
    // dummy->1->2->3->4->5...
    //     |  |     |
    //     p  h     t
    //---------------------
    //  dummy->2->1->3->4->5...
    //            |  |     |
    //            p  h     t
    //---------------------
    //  dummy->2->1->4->3->5...
    //                  |  |     |
    //                  p  h     t
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null && head.next != null) {
            ListNode temp = head.next.next;
            pre.next = head.next;
            head.next.next = head;
            head.next = temp;
            head = temp;
            pre = pre.next.next;
        }
        return dummy.next;
    }

}
