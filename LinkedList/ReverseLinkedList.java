package LinkedList;

/**
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
    // iteratively
    //
    // before:  1->2->3->4->null
    // after:   null<-1<-2<-3<-4
    //
    // While you are traversing the list, change the current node's next pointer to point to its previous element.
    // Since a node does not have reference to its previous node, you must store its previous element beforehand.
    // You also need another pointer to store the next node before changing the reference.
    // Do not forget to return the new head reference at the end!
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tempNext = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tempNext;
        }
        return pre;
    }

    // recursively
    // The recursive version is slightly trickier and the key is to work backwards.
    // Assume that the rest of the list had already been reversed, now how do I reverse the front part?
    // Let's assume the list is: n1 → … → nk-1 → nk → nk+1 → … → nm → Ø
    // Assume from node nk+1 to nm had been reversed and you are at node nk.
    // n1 → … → nk-1 → nk → nk+1 ← … ← nm
    // We want nk+1’s next node to point to nk.
    // So,
    //
    // nk.next.next = nk;
    // Be very careful that n1's next must point to Ø.
    // If you forget about this, your linked list has a cycle in it.
    // This bug could be caught if you test your code with a linked list of size 2

    public ListNode reverse1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverse1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
