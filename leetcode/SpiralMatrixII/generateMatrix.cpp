Spiral Matrix II
class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        int v = 1;
        vector<vector<int>> ans(n, vector<int>(n));
        for (int i = 0; i <= (n - 1) / 2; i++) {
            int len = n - 2 * i;
            for (int j = 0; j < len - 1; j++, v++) {
                ans[i][i + j] = v;
                ans[i + j][n - 1 - i] = (len - 1) + v;
                ans[n - 1 - i][n - 1 - i - j] = (len - 1) * 2 + v;
                ans[n - 1 - i - j][i] = (len - 1) * 3 + v;
            }
            if (len == 1) ans[i][i] = v;
            v += (len - 1) * 3;
        }
        return ans;
    }
};
