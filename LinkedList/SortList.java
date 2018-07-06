package LinkedList;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class SortList {
    // solution 1 : merge sort
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMiddle(head);

        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return merger(left, right);

    }

    // the exactly mid or the left one of mid
    // 1->2->3 return 2
    // 1->2 return 1
    private ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merger(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode l3 = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }

        l3.next = l1 == null ? l2 : l1;

        return dummy.next;
    }



    // solution 2 : quick sort
    public ListNode quickSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyLeft = new ListNode(0), currLeft = dummyLeft;
        ListNode dummyRight = new ListNode(0), currRight = dummyRight;
        ListNode dummyMid = new ListNode(0), currMid = dummyMid;

        ListNode mid = findMiddle(head);

        while (head != null) {
            if (head.val < mid.val) {
                currLeft.next = head;
                currLeft = currLeft.next;
            } else if (head.val > mid.val){
                currRight.next = head;
                currRight = currRight.next;
            } else {
                currMid.next = head;
                currMid = currMid.next;
            }
            head = head.next;
        }

        currLeft.next = null;
        currMid.next = null;
        currRight.next = null;

        ListNode left = quickSort(dummyLeft.next);
        ListNode right = quickSort(dummyRight.next);

        return concat(left, dummyMid.next, right);
    }

    private ListNode concat(ListNode left, ListNode mid, ListNode right) {
        ListNode dummy = new ListNode(0), head = dummy;
        head.next = left;
        head = getTail(left);
        head.next = mid;
        head = getTail(mid);
        head.next = right;
        return  dummy.next;
    }

    private ListNode getTail(ListNode head) {
        if (head == null) {
            return null;
        }
        while(head.next != null ) {
            head = head.next;
        }
        return head;
    }
    private ListNode partition(ListNode head, int x) {
        ListNode dummyS = new ListNode(0);
        ListNode dummyL = new ListNode(0);

        ListNode currS = dummyS;
        ListNode currL = dummyL;

        while (head != null) {
            if (head.val < x) {
                currS.next = head;
                currS = currS.next;
            } else {
                currL.next = head;
                currL = currL.next;
            }

            head = head.next;
        }

        currL.next = null;
        currS.next = dummyL.next;
        return dummyS.next;
    }

    public static void main(String[] args) {
        SortList mytest = new SortList();
        MyLinkedList list = new MyLinkedList();
        list.add(0,4);
        list.add(1,2);
        list.add(2,1);
        list.add(3,3);
        list.print();
        ListNode res = mytest.sortList(list.dummy.next);
        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.println("null");

    }
}
