package LinkedList;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 *
 * For example, the following two linked lists:
 *
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 *
 *
 * Notes:
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */

/**
 * We can use two iterations to do that.
 * In the first iteration, we will reset the pointer of one linkedlist to the head of another linkedlist after it reaches the tail node.
 * In the second iteration, we will move two pointers until they points to the same node.
 * Our operations in first iteration will help us counteract the difference.
 * So if two linkedlist intersects, the meeting point in second iteration must be the intersection point.
 * If the two linked lists have no intersection at all,
 * then the meeting pointer in second iteration must be the tail node of both lists, which is null
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}
