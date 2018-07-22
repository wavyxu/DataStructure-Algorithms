package depthfirstsearch;
import java.util.*;
/**
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.
 *
 * Example 1:
 *
 * Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
 * Output: true
 * Example 2:
 *
 * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
 * Output: false
 * Note: you can assume that no duplicate edges will appear in edges.
 * Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.
 */

/**
 *  If graph is a tree
 *
 *  1. The number of edges is exactly n - 1, n is the number of nodes
 *  2. All of the nodes are connected. Start from any node, could reach any other nodes. BFS / DFS traversal
 *  3. Or there is no cycle in the graph
 *
 *  conditions 1 & 2, or 1 & 3 could decide a graph is tree or not.
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (n == 0 || edges == null) {
            return false;
        }
        if (edges.length != n - 1) {
            return false;
        }

        Map<Integer, Set<Integer>> graph = initialGraph(n, edges);

        Queue<Integer> queue = new LinkedList<>();  // store the node in waiting list
        Set<Integer> hash = new HashSet<>();  // store the nodes visited or in waiting list

        queue.add(0);
        hash.add(0); // visited

        // BFS traversal
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (Integer nei : graph.get(curr)) {
                if (!hash.contains(nei)) {
                    queue.add(nei);
                    hash.add(nei);
                }
            }
        }

        return hash.size() == n;
    }

    public boolean validTreeDFS(int n , int[][] edges) {
        if (n == 0 || edges == null) {
            return false;
        }
        if (edges.length != n - 1) {
            return false;
        }

        Map<Integer, Set<Integer>> graph = initialGraph(n, edges);

        Deque<Integer> stack = new LinkedList<>();  // store the node in waiting list
        Set<Integer> hash = new HashSet<>();  // store the nodes visited or in waiting list

        stack.add(0);
        hash.add(0); // visited

        // DFS traversal
        while (!stack.isEmpty()) {
            int curr = stack.removeFirst();
            for (Integer nei : graph.get(curr)) {
                if (!hash.contains(nei)) {
                    stack.addFirst(nei);
                    hash.add(nei);
                }
            }
        }

        return hash.size() == n;
    }

    private Map<Integer, Set<Integer>> initialGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
}
