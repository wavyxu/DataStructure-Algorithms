package array;
import java.util.*;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * Your algorithm should run in O(n) complexity.
 *
 * Clarification
 * Your algorithm should run in O(n) complexity.
 *
 * Example
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        Set<Integer> hash = new HashSet<>();
        for (int n : num) {
            hash.add(n);
        }

        int currLength = 0;
        int maxLength = 0;

        // 当 hash 不包含 n - 1 才开始重新计算，避免了重复计算，所以时间复杂度为 O(n)
        for (int n : num) {
            if (!hash.contains(n - 1)) {
                currLength = 1;
                while (hash.contains(n + 1)) {
                    currLength++;
                    n++;
                }
                maxLength = Math.max(currLength, maxLength);
            }
        }
        return maxLength;
    }
}
