package dp;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int[] f = new int[n];   // f[i] represent the largest profit sell at day i
        int[] g = new int[n];   // g[i] represent the lowest price before day i, including day i

        f[0] = 0;
        g[0] = prices[0];

        int profit = 0;

        for (int i = 1; i < n ; i++) {
            g[i] = Math.min(g[i - 1] , prices[i]);
            f[i] = prices[i] - g[i];
            profit = Math.max(profit, f[i]);
        }
        return profit;
    }

    // solution 2 : space optimized
    public int maxProfit2(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0){
            return 0;
        }
        int n = prices.length;

        int profit = 0;
        int lowestPrice = prices[0];

        for (int i = 1; i < n ; i++) {
            lowestPrice = Math.min(lowestPrice , prices[i]);
            profit = Math.max(profit, prices[i] - lowestPrice);
        }
        return profit;
    }
}
