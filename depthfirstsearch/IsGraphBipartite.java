package depthfirstsearch;
import java.util.*;
/**
 * Given an undirected graph, return true if and only if it is bipartite.
 *
 * Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.
 *
 * The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.
 *
 * Example 1:
 * Input: [[1,3], [0,2], [1,3], [0,2]]
 * Output: true
 * Explanation:
 * The graph looks like this:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * We can divide the vertices into two groups: {0, 2} and {1, 3}.
 * Example 2:
 * Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * Output: false
 * Explanation:
 * The graph looks like this:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * We cannot find a way to divide the set of nodes into two independent subsets.
 */
public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] colors = new int[n];
        // -1 : uncolor
        // 0 : red
        // 1 : blue
        Arrays.fill(colors, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                stack.addFirst(i);
                colors[i] = 0;
            }

            while (!stack.isEmpty()) {
                int node = stack.pollFirst();
                for (Integer nei : graph[node]) {
                    if (colors[nei] == -1) {
                        stack.addFirst(nei);
                        colors[nei] = colors[node] ^ 1;
                    } else if (colors[nei] == colors[node]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean isBipartiteBFS(int[][] graph) {
        int n = graph.length;
        Queue<Integer> queue = new LinkedList<>();

        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                queue.offer(i);
                colors[i] = 0;
            }

            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (Integer nei : graph[node]) {
                    if (colors[nei] == -1) {
                        queue.offer(nei);
                        colors[nei] = colors[node] ^ 1;
                    } else if (colors[nei] == colors[node]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
