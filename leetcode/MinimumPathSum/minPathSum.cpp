class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int m = grid.size();
        if (m == 0) return 0;
        int n = grid[0].size();
        vector<int> sol(n, 0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = !i && !j ? 0 : (!i ? sol[j - 1] : (!j ? sol[j] : min(sol[j], sol[j - 1])));
                sol[j] = val + grid[i][j];
            }
        }
        return sol[n - 1];
    }
};
