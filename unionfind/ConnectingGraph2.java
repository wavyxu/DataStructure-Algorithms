package unionfind;
import java.util.*;

/**
 * Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.
 *
 * You need to support the following method:
 *
 * connect(a, b), an edge to connect node a and node b
 * query(a), Returns the number of connected component nodes which include node a.
 * Example
 * 5 // n = 5
 * query(1) return 1
 * connect(1, 2)
 * query(1) return 2
 * connect(2, 4)
 * query(1) return 3
 * connect(1, 4)
 * query(1) return 3
 */
public class ConnectingGraph2 {
    private int[] father;
    private int[] count;
    /*
     * @param n: An integer
     */
    public ConnectingGraph2(int n) {
        father = new int[n + 1];
        count = new int[n + 1];
        for (int i = 0 ; i <= n ; i++) {
            father[i] = i;
            count[i] = 1;
        }
    }
    public int find(int x) {
        Set<Integer> path = new HashSet<>();
        while (father[x] != x) {
            x = father[x];
            path.add(x);
        }
        for (Integer p : path) {
            father[p] = x;
        }
        return x;
    }
    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            father[rootA] = rootB;
            count[rootB] += count[rootA];
        }
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int query(int a) {
        // write your code here
        return count[find(a)];
    }
}
