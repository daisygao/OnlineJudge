public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int profit = 0, min = Integer.MAX_VALUE;
        for (int x : prices) {
            if (x < min) min = x;
            profit = Math.max(x - min, profit);
        }
        return profit;
    }
}