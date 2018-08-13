package unionfind;
import java.util.*;

/**
 * Given a list of Connections, which is the Connection class (the city name at both ends of the edge and a cost between them),
 * find some edges, connect all the cities and spend the least amount.
 * Return the connects if can connect all the cities, otherwise return empty list.
 *
 * Return the connections sorted by the cost, or sorted city1 name if their cost is same,
 * or sorted city2 if their city1 name is also same.
 *
 * Have you met this question in a real interview?
 * Example
 * Gievn the connections = ["Acity","Bcity",1], ["Acity","Ccity",2], ["Bcity","Ccity",3]
 *
 * Return ["Acity","Bcity",1], ["Acity","Ccity",2]
 */
class Connection {
    public String city1, city2;
    public int cost;
    public Connection(String city1, String city2, int cost) {
        this.city1 = city1;
        this.city2 = city2;
        this.cost = cost;
    }
  }

  public class MinimumSpanningTree {
      class UnionFind {
          private Map<String, String> father;
          private int count;
          public UnionFind(Set<String> cities) {
               father = new HashMap<>();
               for (String city : cities) {
                   father.put(city, city);
               }
               count = cities.size();
          }
          public String find(String s) {
              Set<String> paths = new HashSet<>();
              String curr = s;
              while (!father.get(curr).equals(curr)) {
                  curr = father.get(curr);
                  paths.add(curr);
              }
              for (String path : paths) {
                  father.put(path, curr);
              }
              return curr;
          }
          public void union(String s1, String s2) {
              String root1 = find(s1);
              String root2 = find(s2);
              if (root1 != root2) {
                  father.put(root1, root2);
                  count--;
              }
          }
          public boolean isConnected(String s1, String s2) {
              return find(s1).equals(find(s2));
          }
          public int query() {
              return count;
          }
      }

    public static Comparator<Connection> comparetor = new Comparator<Connection>() {
        @Override
        public int compare(Connection o1, Connection o2) {
            if(o1.cost != o2.cost) {
                return o1.cost - o2.cost;
            }
            if(o1.city1.equals(o2.city1)) {
                // String.compareTo(s1, s2)，return c1 - c2, 即 s1 小于 s2 时，返回负数
                // 即 s1, s2 按升序排列
                return o1.city2.compareTo(o2.city2);
            }
            return o1.city1.compareTo(o2.city1);
        }
    };
    public List<Connection> lowestCost(List<Connection> connections) {
        // Write your code here
        List<Connection> res = new ArrayList<>();
        Collections.sort(connections, comparetor);
        Set<String> cities = new HashSet<>();
        for(Connection conn :  connections) {
            cities.add(conn.city1);
            cities.add(conn.city2);
        }
        UnionFind uf = new UnionFind(cities);
        for(int i = 0; i < connections.size(); i++) {
            String city1 = connections.get(i).city1;
            String city2 = connections.get(i).city2;
            if (!uf.isConnected(city1, city2)) {
                uf.union(city1, city2);
                res.add(connections.get(i));
            }
        }
        if (uf.query() != 1) {
            return new ArrayList<>();
        }
        return res;
    }
}
