class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<int> sol(n, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sol[j] += sol[j - 1];
            }
        }
        return sol[n - 1];
    }
};
