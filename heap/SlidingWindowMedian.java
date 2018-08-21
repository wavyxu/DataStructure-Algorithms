package heap;
import java.util.*;

/**
 * Median is the middle value in an ordered integer list.
 * If the size of the list is even, there is no middle value.
 * So the median is the mean of the two middle value.
 *
 * Examples:
 * [2,3,4] , the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Your job is to output the median array for each window in the original array.
 *
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 *
 * Window position                Median
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 *  1 [3  -1  -3] 5  3  6  7       -1
 *  1  3 [-1  -3  5] 3  6  7       -1
 *  1  3  -1 [-3  5  3] 6  7       3
 *  1  3  -1  -3 [5  3  6] 7       5
 *  1  3  -1  -3  5 [3  6  7]      6
 * Therefore, return the median sliding window as [1,-1,-1,3,5,6].
 *
 * Note:
 * You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.
 */

class Node {
    public int id;
    public int val;
    public Node(int id, int val) {
        this.id = id;
        this.val = val;
    }
}
public class SlidingWindowMedian {
    private Comparator<Node> comparator  = new Comparator<Node>() {
        @Override
        public int compare(Node A, Node B) {
            if (A.val == B.val) {
                return A.id - B.id;
            }
            return A.val - B.val;
        }
    };

    // minHeap store left half
    // maxHeap store right half
    private TreeSet<Node> minHeap = new TreeSet<>(comparator);
    private TreeSet<Node> maxHeap = new TreeSet<>(comparator);
    public List<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        int n = nums.length;

        // initialize the heaps, prepare for first window
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        for (int i = 0; i < k - 1; i++) {
            add(new Node(i, nums[i]));
        }
        // sliding the window
        for (int i = k - 1;  i < n; i++ ) {

            add(new Node(i, nums[i]));
            res.add(findMedian());
            remove(new Node(i - k + 1, nums[i - k + 1]));
        }
        return res;
    }
    private void add(Node node) {
        if (minHeap.size() <= maxHeap.size()) {
                minHeap.add(node);
            } else {
                maxHeap.add(node);
            }

        if (maxHeap.size() > 0 && minHeap.last().val > maxHeap.first().val) {
            Node minRoot = minHeap.pollLast();
            Node maxRoot = maxHeap.pollFirst();
            maxHeap.add(minRoot);
            minHeap.add(maxRoot);
        }
    }
    private int findMedian() {
        return minHeap.last().val;
    }

    // remove takes O(logn)
    private void remove(Node node) {
        if (maxHeap.contains(node)) {
            maxHeap.remove(node);
        } else {
            minHeap.remove(node);
        }
    }
    public double[] medianSlidingWindowDouble(int[] nums, int k) {
        // write your code here
        int n = nums.length;

        // initialize the heaps, prepare for first window
        double[] res = new double[n - k + 1];
        if (nums == null || nums.length == 0) {
            return res;
        }
        for (int i = 0; i < k - 1; i++) {
            add(new Node(i, nums[i]));
        }
        // sliding the window
        for (int i = k - 1;  i < n; i++ ) {

            add(new Node(i, nums[i]));
            res[i - k + 1] = findMedianDouble();
            remove(new Node(i - k + 1, nums[i - k + 1]));
        }
        return res;
    }
    private double findMedianDouble() {
        if (minHeap.size() == maxHeap.size()) {
            return (double)minHeap.last().val * 0.5  + (double)maxHeap.first().val * 0.5;
        } else {
            return (double)minHeap.last().val;
        }
    }

    public static void main(String[] args) {
        SlidingWindowMedian mytest = new SlidingWindowMedian();
        int[] src = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE,
                Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
                Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE};
        System.out.println(mytest.medianSlidingWindow(src, 3));
        double[] res = mytest.medianSlidingWindowDouble(src, 3);
        for (double d : res) {
            System.out.print(d + ",");
        }
    }
}
