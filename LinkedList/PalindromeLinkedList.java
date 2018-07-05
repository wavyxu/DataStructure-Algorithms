package LinkedList;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) { // odd nodes; let right half smaller
            slow = slow.next;
        }

        slow = reverse(slow);

        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;

        while (head != null) {
            ListNode tempNext = head.next;
            head.next = pre;
            pre = head;
            head = tempNext;
        }

        return pre;
    }
}
