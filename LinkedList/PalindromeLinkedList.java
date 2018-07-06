package LinkedList;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */

/**
 * This can be solved by reversing the 2nd half and compare the two halves.
 * Let's start with an example [1, 1, 2, 1].
 *
 * In the beginning, set two pointers fast and slow starting at the head.
 *
 * 1 -> 1 -> 2 -> 1 -> null
 * s    f
 * (1) Move: fast pointer goes to the end, and slow goes to the middle.
 *
 * 1 -> 1 -> 2 -> 1 -> null
 *      s         f
 * (2) Cut: Move slow one more step, let the right half smaller
 * 1 -> 1 -> 2 -> 1 -> null
 *           s    f
 * (3) Reverse: the right half is reversed, and slow pointer becomes the 2nd head.
 *
 * 1 -> 1    null <- 2 <- 1
 * h                      s
 * (4) Compare: run the two pointers head and slow together and compare.
 *
 * 1 -> 1    null <- 2 <- 1
 *      h            s
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow at the mid or left to the mid
        slow = slow.next;   // let the right half smaller

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
