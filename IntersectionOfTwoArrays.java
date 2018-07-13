package HashMap;
import java.util.*;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 *
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Set<Integer> hash = new HashSet<>();
        Set<Integer> res = new HashSet<>();

        for (int num : nums1) {
            hash.add(num);
        }

        for (int num : nums2) {
            if (hash.contains(num)) {
                res.add(num);
            }
        }

        int[] result = new int[res.size()];
        int i = 0;
        for (Integer num : res) {
            result[i++] = num;
        }

        return result;
    }
}
