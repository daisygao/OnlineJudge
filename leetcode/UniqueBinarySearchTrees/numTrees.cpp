class Solution {
public:
    int numTrees(int n) {
        vector<int> dp(n + 1);
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] += dp[j - 1] * dp[i - j] * 2;
            }
            if (i % 2) dp[i] += dp[i / 2] * dp[i / 2];
        }
        return dp[n];
    }
};
