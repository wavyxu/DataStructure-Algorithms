package array;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * @author: Vivian Xu
 */
public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
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
            result[i++] = num;
        }

        return result;
    }
}
