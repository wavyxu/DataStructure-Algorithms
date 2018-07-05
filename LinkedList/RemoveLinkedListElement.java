package LinkedList;

/**
 * Description
 * Remove all elements from a linked list of integers that have value val.
 *
 *
 * Example
 * Given 1->2->3->3->4->5->3, val = 3, you should return the list as 1->2->4->5
 */
public class RemoveLinkedListElement {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;

        while (curr != null && curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
