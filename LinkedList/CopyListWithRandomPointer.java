package LinkedList;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 */

/**
 * step 1: copy next，先建立 copy 节点 1->1`->2->2`->3->3`->4->4`,
 * step 2: copy random，建立 copy 节点的 random
 * step 3: split. 一边扫描一边拆成两个链表. 第一个链表变回  1->2->3 , 然后第二变成 1`->2`->3`
 */
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode (int x) {
        this.label = x;
    }
}
public class CopyListWithRandomPointer {
    private void copyNext(RandomListNode head) {
        while (head != null) {
            RandomListNode currCopy = new RandomListNode(head.label);
            currCopy.next = head.next;
            currCopy.random = head.random;
            head.next = currCopy;
            head = head.next.next;
        }
    }

    private void copyRandom(RandomListNode head) {
        while (head != null) {
            RandomListNode currCopy = head.next;
            if (head.random != null) {
                currCopy.random = head.random.next;
            }
            head = head.next.next;
        }
    }

    private RandomListNode split(RandomListNode head) {
        RandomListNode newHead = head.next;
        while (head != null) {
            RandomListNode currCopy = head.next;
            head.next = currCopy.next;
            head = currCopy.next;
            if (currCopy.next != null) {
                currCopy.next = currCopy.next.next;
            }
        }
        return newHead;
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        copyNext(head);
        copyRandom(head);
        return split(head);
    }
}
