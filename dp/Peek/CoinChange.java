package dp;
import java.util.*;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // f[0], f[1] .. f[amount]
        int[] f = new int[amount + 1];
        // initialization
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;

        // f[1] f[2] ... f[amount]
        for (int i = 1; i <= amount; i++) {
            // last coin coins[0], coins[1] , ..
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && f[i - coins[j]] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i], f[i - coins[j]] + 1);
                }
            }
        }

        return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
    }
}
