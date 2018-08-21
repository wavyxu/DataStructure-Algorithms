package heap;
import java.util.*;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array
 * to the very right. You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 *
 * Follow up:
 * Could you solve it in linear time?
 */

public class SlidingWindowMaximum {
    class Node {
        public int id;
        public int val;
        public Node(int id, int val) {
            this.id = id;
            this.val = val;
        }
    }
    private Comparator<Node> comparator = new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            if (o1.val == o2.val) {
                return o1.id - o2.id;
            }
            return o1.val - o2.val;
        }
    };

    // solution1 TreeSet, Time: O(nlogk)
    private TreeSet<Node> tree = new TreeSet<>(comparator);
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < k - 1; i++) {
            tree.add(new Node(i, nums[i]));
        }
        // 先添加新节点，再查找 maximum，再删除
        // 这样才能保证顺利完成最后一轮的添加，查找，删除
        for (int i = k - 1; i < n; i++) {
            tree.add(new Node(i, nums[i]));
            res[i - k + 1] = tree.last().val;
            tree.remove(new Node(i - k + 1, nums[i - k + 1]));
        }
        return res;
    }
    private void add(Node node) {
        tree.add(node);
    }
    private void remove(Node node) {
        tree.remove(node);
    }

    public static void main(String[] args) {
        SlidingWindowMaximum mytest = new SlidingWindowMaximum();
        int[] src = new int[] {1, 2, 3, 2, 1, 3};
        int[] res = mytest.maxSlidingWindow(src, 3);
        for (int i : res) {
            System.out.print(i + ",");
        }
    }
}
