package LinkedList;
import java.util.*;
/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        int k = lists.length;

        Queue<ListNode> queue = new PriorityQueue<ListNode>(k, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode A, ListNode B) {
                if (A.val < B.val) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        for(ListNode head : lists) {
            if (head != null) {
                queue.offer(head);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (!queue.isEmpty()) {
            ListNode currHead = queue.poll();
            curr.next = currHead;
            curr = curr.next;
            if (currHead.next != null) {
                queue.offer(currHead.next);
            }
        }
        return dummy.next;
    }
}
