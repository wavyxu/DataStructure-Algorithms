package LinkedList;

import java.util.List;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        while(head != null && head.next != null) {
            if(head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
}
