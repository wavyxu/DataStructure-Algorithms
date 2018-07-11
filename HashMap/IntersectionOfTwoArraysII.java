package HashMap;
import java.util.*;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 *
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *
 *
 * Answer for follow up 3:
 * If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap,
 * read chunks of array that fit into the memory, and record the intersections.
 *
 * If both nums1 and nums2 are so huge that neither fit into the memory,
 * sort them individually (external sort),
 * then read 2 elements from each array at a time in memory, record intersections.
 *
 *
 **/
public class IntersectionOfTwoArraysII {
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                res.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        int[] result = new int[res.size()];
        int i = 0;
        for (Integer num : res) {
            result[i++] = num.intValue();
        }

        return result;
    }
}
