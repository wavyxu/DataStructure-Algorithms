package depthfirstsearch;
import java.util.*;
/**
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name,
 * and the rest of the elements are emails representing emails of the account.
 *
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email
 * that is common to both accounts. Note that even if two accounts have the same name,
 * they may belong to different people as people could have the same name.
 * A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 *
 * After merging the accounts, return the accounts in the following format: the first element of each account is the name,
 * and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 *
 * Example 1:
 * Input:
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * Explanation:
 * The first and third John's are the same person as they have the common email "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 */
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
     if (accounts == null || accounts.size() < 2) {
         return accounts;
     }

     List<List<String>> res = new ArrayList<>();
     Deque<String> stack = new ArrayDeque<>();

     for (int i = 0; i < accounts.size(); i++) {
         Set<String> visited = new HashSet<>();
         for (String email : getAllEmail(accounts, i)) {
             stack.addFirst(email);
             visited.add(email);
         }

         List<String> newAccount  = new ArrayList<>();
         String username = accounts.get(i).get(0);

         while (!stack.isEmpty()) {
             String email = stack.poll();
             newAccount.add(email);
             for (int j = i + 1; j < accounts.size(); j++) {
                 if (username.equals(accounts.get(j).get(0)) && accounts.get(j).contains(email)) {
                     for (String emailOfJ : getAllEmail(accounts, j)) {
                         if (!visited.contains(emailOfJ)) {
                             stack.add(emailOfJ);
                             visited.add(emailOfJ);
                         }
                     }
                     accounts.remove(j);
                 }
             }
         }

         Collections.sort(newAccount);
         removeDuplicates(newAccount);
         newAccount.add(0,username);


         res.add(newAccount);
     }
     return res;
    }

    private void removeDuplicates(List<String> emails) {
        if (emails.size() < 2) {
            return;
        }
        int i = 1;
        while (i < emails.size()) {
            if (emails.get(i).equals(emails.get(i - 1))) {
                emails.remove(i);
                i--;
            }
            i++;
        }
    }


    private List<String> getAllEmail(List<List<String>> accounts, int index) {
        List<String> res = new LinkedList<>();
        for (int i = 1; i < accounts.get(index).size(); i++) {
            res.add(accounts.get(index).get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(new ArrayList<>());
        accounts.add(new ArrayList<>());
        accounts.add(new ArrayList<>());
        accounts.add(new ArrayList<>());

        accounts.get(0).add("Wei");
        accounts.get(0).add("1");
        accounts.get(0).add("1");
        accounts.get(0).add("1");
        accounts.get(0).add("2");

        accounts.get(1).add("Wei");
        accounts.get(1).add("1");
        accounts.get(1).add("3");

        accounts.get(2).add("Wei");
        accounts.get(2).add("4");

        accounts.get(3).add("keqing");
        accounts.get(3).add("5");


        AccountsMerge mytest = new AccountsMerge();

        System.out.println(mytest.accountsMerge(accounts));
//        System.out.println(mytest.accountsMerge1(accounts));

    }
}
