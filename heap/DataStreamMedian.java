package heap;
import java.util.*;

/**
 *
 * Description
 * Numbers keep coming, return the median of numbers at every time a new number added.
 *
 * Clarification
 * What's the definition of Median?
 *
 * Median is the number that in the middle of a sorted array.
 * If there are n numbers in a sorted array A, the median is A[(n - 1) / 2].
 * For example, if A=[1,2,3], median is 2. If A=[1,19], median is 1.
 *
 * Example
 * For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].
 *
 * For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].
 *
 * For numbers coming list: [2, 20, 100], return [2, 2, 20].
 *
 * Challenge
 * Total run time in O(nlogn).
 *
 */
public class DataStreamMedian {
    public Comparator<Integer> comparatorMax = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    };
    private Queue<Integer> minHeap = new PriorityQueue<>();
    private Queue<Integer> maxHeap = new PriorityQueue<>(comparatorMax);
    private int numOfElement = 0;
    public int[] medianII(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            add(nums[i]);
            res[i] = getMedian();
        }
        return res;
    }

    private void add(int value) {
        maxHeap.offer(value);
        if ((numOfElement & 1) == 0) {
            if (minHeap.isEmpty()) {
                numOfElement++;
                return;
            }
            if (minHeap.peek() < maxHeap.peek()) {
                int minRoot = minHeap.poll();
                int maxRoot = maxHeap.poll();
                minHeap.offer(maxRoot);
                maxHeap.offer(minRoot);
            }
        } else {
          minHeap.offer(maxHeap.poll());
        }
        numOfElement++;
    }

    private int getMedian() {
        return maxHeap.peek();
    }

}
