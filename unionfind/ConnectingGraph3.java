package unionfind;
import java.util.*;

/**
 * Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.
 *
 * You need to support the following method:
 *
 * connect(a, b), an edge to connect node a and node b
 * query(), Returns the number of connected component in the graph
 *
 * Example
 * 5 // n = 5
 * query() return 5
 * connect(1, 2)
 * query() return 4
 * connect(2, 4)
 * query() return 3
 * connect(1, 4)
 * query() return 3
 */
public class ConnectingGraph3 {
    private int[] father;
    private int count;
    public ConnectingGraph3(int n) {
        // do intialization if necessar
        father = new int[n + 1];
        for (int i = 0 ; i <= n ; i++) {
            father[i] = i;
        }
        count = n;
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
            count--;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: A boolean
     */
    public int query() {
        // write your code here
        return count;
    }
}
