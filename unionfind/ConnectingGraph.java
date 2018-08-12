package unionfind;
import java.util.*;

/**
 * Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.
 *
 * You need to support the following method:
 *
 * connect(a, b), add an edge to connect node a and node b`.
 * query(a, b), check if two nodes are connected
 * Have you met this question in a real interview?
 * Example
 * 5 // n = 5
 * query(1, 2) return false
 * connect(1, 2)
 * query(1, 3) return false
 * connect(2, 4)
 * query(1, 4) return true
 */
public class ConnectingGraph {
    private int[] father;
    public ConnectingGraph(int n) {
        // do intialization if necessar
        father = new int[n + 1];
        for (int i = 0 ; i <= n ; i++) {
            father[i] = i;
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
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: A boolean
     */
    public boolean query(int a, int b) {
        // write your code here
        return find(a) == find(b);
    }
}
