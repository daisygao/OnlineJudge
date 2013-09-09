public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = obstacleGrid.length, n = obstacleGrid[0].length, sols[] = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sols[j] = obstacleGrid[i][j] == 1 ? 0 : sols[j] + (j == 0 ? (i == 0 ? 1 : 0) : sols[j - 1]);
            }
        }
        return sols[n - 1];
    }
}