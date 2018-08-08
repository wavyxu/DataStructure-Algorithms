package unionfind;
import java.util.*;

/**
 * Given a list accounts, each element accounts[i] is a list of strings,
 * where the first element accounts[i][0] is a name,
 * and the rest of the elements are emails representing emails of the account.
 *
 * Now, we would like to merge these accounts.
 * Two accounts definitely belong to the same person if there is some email
 * that is common to both accounts. Note that even if two accounts have the same name,
 * they may belong to different people as people could have the same name.
 * A person can have any number of accounts initially,
 * but all of their accounts definitely have the same name.
 *
 * After merging the accounts, return the accounts in the following format:
 * the first element of each account is the name,
 * and the rest of the elements are emails in sorted order.
 * The accounts themselves can be returned in any order.
 *
 * Example 1:
 * Input:
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"],
 * ["John", "johnnybravo@mail.com"],
 * ["John", "johnsmith@mail.com", "john_newyork@mail.com"],
 * ["Mary", "mary@mail.com"]]
 *
 * Output:
 * [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],
 * ["John", "johnnybravo@mail.com"],
 * ["Mary", "mary@mail.com"]]
 *
 * Note:
 *
 * The length of accounts will be in the range [1, 1000].
 * The length of accounts[i] will be in the range [1, 10].
 * The length of accounts[i][j] will be in the range [1, 30].
 */
public class AccountsMerge {
    class UnionFind {
        // son - father mapping
        private Map<String, String> father;

        public UnionFind(Set<String> src) {
            father = new HashMap<>();
            //count = n;
            for (String s : src) {
                father.put(s, s);
            }
        }

        public String find(String s) {
            if (father.get(s).equals(s)) {
                return s;
            }

            // put(K,V) 可以重复对已经存在的 K 操作，将 V 改成新的，但返回的是 旧 V
            // 所以此处不能直接 return father(s, find(father.get(s)))
            father.put(s, find(father.get(s)));
            return father.get(s);
        }

        public void union(String a, String b) {
            String rootA = find(a);
            String rootB = find(b);
            if (rootA != rootB) {
                father.put(rootA, rootB);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        if (accounts == null || accounts.size() == 0) {
            return new ArrayList<>();
        }

        // read all unique email address
        Set<String> emails = new HashSet<>();
        Map<String, String> emailToOwner = new HashMap<>();
        for (List<String> acc : accounts) {
            String owner = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                emails.add(acc.get(i));
                emailToOwner.putIfAbsent(acc.get(i), owner);
            }
        }

        UnionFind uf = new UnionFind(emails);

        // 合并 一个账号下的所有 email， 第一个 email 为代表节点
        for (List<String> account : accounts) {
            String father = account.get(1);
            for (int i = 2; i < account.size(); i++) {
                String email = account.get(i);
                uf.union(email, father);
            }
        }

        // 基于合并后的数据集，建立 components，即 father，children mapping
        Map<String, List<String>> newAccount = new HashMap<>();
        // fill up the result list
        for (String email : emails) {
            String father = uf.find(email);
            if (!newAccount.containsKey(father)) {
                newAccount.put(father, new ArrayList<>());
            }
            newAccount.get(father).add(email);
        }

        List<List<String>> res = new ArrayList(newAccount.values());
        for (List<String> account : res ) {
            Collections.sort(account);
            account.add(0, emailToOwner.get(account.get(0)));
        }

        return res;
    }
}
