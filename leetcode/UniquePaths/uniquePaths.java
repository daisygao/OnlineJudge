/*
sols[i][j] = sols[i - 1][j] + sols[i][j - 1];
*/
public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sols[] = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sols[j] += (j == 0 ? (i == 0 ? 1 : 0) : sols[j - 1]);
            }
        }
        return sols[n - 1];
    }
}