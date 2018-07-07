package LinkedList;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * Example 2:
 *
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 */

/**
 * 创建两个子链：奇链和偶链。
 * 逐一遍历所有的节点，用一个mark位来标志当前节点是奇还是偶，将节点接到奇链或偶链上。
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        int flag = 0;
        ListNode dummyOdd = new ListNode(-1);
        ListNode odd = dummyOdd;
        ListNode dummyEven = new ListNode(-1);
        ListNode even = dummyEven;
        while (head != null) {
            flag++;
            if ((flag & 1) != 0) {  // odd
                odd.next = head;
                odd = odd.next;
            } else {              // even
                even.next = head;
                even = even.next;
            }
            head = head.next;
        }
        odd.next = dummyEven.next;
        even.next = null;
        return dummyOdd.next;
    }
}
