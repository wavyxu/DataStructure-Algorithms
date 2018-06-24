package String;
import java.util.*;
/**
 *Description
 * Our normal words do not have more than two consecutive letters.
 * If there are three or more consecutive letters, this is a tics.
 * Now give a word, from left to right, to find out the starting point and ending point of all tics.
 *
 * The input string length is n, n <= 100000.
 * Have you met this question in a real interview?
 * Example
 * Given str = "whaaaaatttsup", return [[2,6],[7,9]].
 *
 * Explanation:
 * "aaaa" and "ttt" are twitching letters, and output their starting and ending points.
 * Given str = "whooooisssbesssst", return [[2,5],[7,9],[12,15]].
 *
 * Explanation:
 * "ooo", "sss" and "ssss" are twitching letters, and output their starting and ending points.
 */
public class TwitchWords {
    class Pair {
        public int left;
        public int right;
        public Pair(int l, int r) {
            this.left = l;
            this.right = r;
        }

    }

    public int[][] twitchWords(String str) {
        // Write your code here
        List<Pair> res = new ArrayList<>();
        int start = 0;
        int i = 0;
        while (i < str.length() - 2) {
            if (str.charAt(i) == str.charAt(i + 1) && str.charAt(i + 1) == str.charAt(i + 2)) {
                start = i;
                while (i < str.length() && str.charAt(i) == str.charAt(start)) {
                    i++;
                }
                res.add(new Pair(start, i - 1));
            } else {
                i++;
            }
        }

        int[][] ans = new int[res.size()][2];
        int k = 0;
        for (Pair curr : res) {
            ans[k][0] = curr.left;
            ans[k][1] = curr.right;
            k++;
        }

        return ans;
    }

    public static void main(String[] args) {
        TwitchWords mytest = new TwitchWords();
        int[][] res = mytest.twitchWords("whooooisssbesssst");
        for (int i = 0 ; i < res.length; i++) {
                System.out.println(res[i][0] + "," + res[i][1]);
        }
    }
}
