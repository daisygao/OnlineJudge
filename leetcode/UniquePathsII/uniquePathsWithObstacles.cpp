class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size(), n = m ? obstacleGrid[0].size() : 0;
        vector<int> ans(n, 0);
        ans[0] = 1;
        for (auto row : obstacleGrid) {
            for (int i = 0; i < n; i++) {
                if (!row[i]) ans[i] += i == 0 ? 0 : ans[i - 1];
                else ans[i] = 0;
            }
        }
        return ans[n - 1];
    }
};
