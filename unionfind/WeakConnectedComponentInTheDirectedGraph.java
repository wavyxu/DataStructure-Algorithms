package unionfind;
import java.util.*;

/**
 * Description
 * Find the number Weak Connected Component in the directed graph.
 * Each node in the graph contains a label and a list of its neighbors.
 * (a connected set of a directed graph is a subgraph in which
 * any two vertices are connected by direct edge path.)
 *
 * Sort the element in the set in increasing order
 *
 * Have you met this question in a real interview?
 * Example
 * Given graph:
 *
 * A----->B  C
 *  \     |  |
 *   \    |  |
 *    \   |  |
 *     \  v  v
 *      ->D  E <- F
 * Return {A,B,D}, {C,E,F}. Since there are two connected component which are {A,B,D} and {C,E,F}
 *
 * Challenge
 * 将原素升序排列。
 */
  class DirectedGraphNode {
      int label;
      ArrayList<DirectedGraphNode> neighbors;
      DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 }
public class WeakConnectedComponentInTheDirectedGraph {
    class UnionFind {
        private HashMap<Integer, Integer> father;
        public UnionFind(Set<Integer> nodes) {
            father = new HashMap<>(nodes.size());

            for (Integer node  : nodes) {
                father.put(node, node);
            }

        }
        public Integer find(Integer node) {
            Set<Integer> path = new HashSet<>();
            Integer fa = node;
            while(father.get(fa) !=fa ) {
                fa = father.get(fa);
                path.add(fa);
            }
            for (Integer curr : path) {
                father.put(curr, fa);
            }

            return fa;
        }
        public void union(Integer a, Integer b) {
            Integer rootA = find(a);
            Integer rootB = find(b);
            if (rootA != rootB) {
                father.put(rootA, rootB);
            }
        }
    }
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // write your code here
        Set<Integer> lables = new HashSet<>();
        for (DirectedGraphNode node : nodes) {
            lables.add(node.label);
        }
        UnionFind uf = new UnionFind(lables);

        for (DirectedGraphNode node : nodes) {
            for (DirectedGraphNode nei : node.neighbors) {
                uf.union(node.label, nei.label);
            }
        }

        Map<Integer, List<Integer>> hash = new HashMap<>();
        for (DirectedGraphNode node : nodes) {
            int f = uf.find(node.label);
            if (!hash.containsKey(f)) {
                hash.put(f, new ArrayList<>());
            }
            hash.get(f).add(node.label);
        }
        return new ArrayList<>(hash.values());
    }
}
