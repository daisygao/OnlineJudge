public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = prices.length, i = 0, j = 0, ans = 0;
        while (j < len) {
            while (j + 1 < len && prices[j + 1] <= prices[j]) j++;
            i = j;
            while (j + 1 < len && prices[j + 1] >=prices[j]) j++;
            ans += prices[j++] - prices[i];
        }
        return ans;
    }
}
