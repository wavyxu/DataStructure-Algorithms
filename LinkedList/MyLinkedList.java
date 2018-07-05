package LinkedList;
//import LinkedList.*;
import java.util.*;
public class MyLinkedList {
    public ListNode dummy;
    public MyLinkedList() {
        dummy = new ListNode(-1);
    }

    public int get(int location) {
        ListNode head = dummy.next;
        for (int i = 0; i < location; i++) {
            head = head.next;
        }
        return head.val;
    }

    public boolean contains(int val) {
        ListNode node = dummy.next;
        while (node != null) {
            if (node.val == val) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void add(int location, int val) {
        ListNode pre = dummy;
        for (int i = 0; i < location; i++) {
            pre = pre.next;
        }

        ListNode node = new ListNode(val);
        node.next = pre.next;
        pre.next = node;

    }

    public void remove(int location) {
        ListNode pre = dummy;
        for (int i = 0; i < location; i++) {
            pre = pre.next;
        }

        pre.next = pre.next.next;
    }

    public void print() {
        ListNode node = dummy.next;
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("null");
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode curr3 = dummy;

        while ((l1 != null) && (l2 != null)) {
            if (l1.val < l2.val) {
                curr3.next = l1;
                l1 = l1.next;
            } else {
                curr3.next = l2;
                l2 = l2.next;
            }
            curr3 = curr3.next;
        }

        curr3.next = l1 == null ? l2 : l1;

        return dummy.next;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList =  new MyLinkedList();
        myLinkedList.add(0,10);
        myLinkedList.add(1,20);
        myLinkedList.add(0,5);

        myLinkedList.print();
    }
}
