public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length, sols[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) sols[i][j] = 0;
                else if (i == 0 && j == 0) sols[i][j] = 1;
                else {
                    sols[i][j] = (j == 0 ? 0 : sols[i][j - 1]) + (i == 0 ? 0 : sols[i - 1][j]);
                }
            }
        }
        return sols[m - 1][n - 1];
    }
}