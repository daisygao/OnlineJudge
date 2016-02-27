class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int sell = 0, buy = INT_MIN, prevSell = 0, prevBuy = 0;
        for (int i = 0; i < prices.size(); i++) {
            prevBuy = buy;
            buy = max(prevSell - prices[i], prevBuy);
            prevSell = sell;
            sell = max(prevBuy + prices[i], prevSell);
        }
        return sell;
    }
};
