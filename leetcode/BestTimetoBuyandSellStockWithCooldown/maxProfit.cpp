class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int size = prices.size();
        if (!size) return 0;
        vector<int> sol(size, 0);
        for (int i = size - 2; i >= 0; i--) {
            int minPrice = 0;
            for (int j = i; j < size; j++) {
                if (j == i) minPrice = prices[j];
                else {
                    if (prices[j] > minPrice) {
                        sol[i] = max(sol[i], prices[j] - minPrice + (j + 2 < size ? sol[j + 2] : 0));
                    }
                    minPrice = min(minPrice, prices[j]);
                }
            }
        }
        return sol[0];
    }
};
