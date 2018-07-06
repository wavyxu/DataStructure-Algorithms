package LinkedList;

import java.util.List;

/**
 * Given a linked list and a value x,
 * partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyS = new ListNode(-1);
        ListNode s = dummyS;
        ListNode dummyL = new ListNode(-1);
        ListNode l = dummyL;
        while (head != null) {
            if (head.val < x) {
                s.next = head;
                s = s.next;
            } else {
                l.next = head;
                l = l.next;
            }
            head = head.next;
        }

        l.next = null;
        s.next = dummyL.next;
        return dummyS.next;
    }
}
