/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Solutions:
left[i] maximum profit up to index i under one transaction
*/
public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = prices.length, left[] = new int[len], ans = 0, 
        min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(i == 0 ? 0 : left[i - 1], prices[i] - min);
        }
        for (int i = len - 1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            ans = Math.max(ans, left[i] + max - prices[i]);
        }
        return ans;
    }
}