package array;
import java.util.Set;
import java.util.HashSet;
/**
 * @author: Vivian Xu
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }

        Set<Integer> hash = new HashSet<>();
        for (int i : nums1) {
            hash.add(i);
        }

        Set<Integer> res = new HashSet<>();
        for (int i : nums2) {
            if (hash.contains(i)) {
                res.add(i);
            }
        }

        int[] ans = new int[res.size()];
        int i = 0;
        for (Integer x : res) {
            ans[i++] = x;
        }

        return ans;
    }
}
