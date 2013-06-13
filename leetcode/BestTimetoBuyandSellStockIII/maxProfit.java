public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = prices.length, result = 0;
        if (len == 0) return result;
        int sell[] = new int[len], buy[] = new int[len];
        int min = prices[0], max = prices[len - 1];
        for (int i = 1; i < len; i++) {
            min = Math.min(prices[i], min);
            sell[i] = Math.max(prices[i] - min, sell[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            max = Math.max(prices[i], max);
            buy[i] = Math.max(max - prices[i], buy[i + 1]);
            result = Math.max(sell[i] + buy[i], result);
        }
        return result;
    }
}