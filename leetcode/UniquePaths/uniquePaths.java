public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sols[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) sols[i][j] = 1;
                else sols[i][j] = (j == 0 ? 0 : sols[i][j - 1]) + (i == 0 ? 0 : sols[i - 1][j]);
            }
        }
        return sols[m - 1][n - 1];
    }
}