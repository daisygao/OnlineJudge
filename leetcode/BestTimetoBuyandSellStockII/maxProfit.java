public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = prices.length, idx = 0, min, max, profit = 0;
        while (idx < len) {
            while (idx + 1 < len && prices[idx + 1] <= prices[idx]) idx++;
            min = prices[idx];
            while (idx + 1 < len && prices[idx + 1] >= prices[idx]) idx++;
            max = prices[idx];
            if (max == min) break;
            profit += max - min;
        }
        return profit;
    }
}