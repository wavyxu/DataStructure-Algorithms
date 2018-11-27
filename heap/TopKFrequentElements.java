package heap;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
/**
 * @author: Vivian Xu
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> A, Map.Entry<Integer, Integer> B) {
                return A.getValue() - B.getValue();
            }
        });
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> res = new ArrayList<>();
        while (pq.size() > 0) {
            res.add(pq.poll().getKey());
        }
        return res;
    }
}
