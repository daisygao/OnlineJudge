class Solution {
public:
    int integerBreak(int n) {
        vector<int> ans(n + 1, 1);
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                ans[i] = max(ans[i], max(j, ans[j]) * max(i - j, ans[i - j]));
            }
        }
        return ans[n];
    }
};
