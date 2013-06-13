public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int height = grid.length;
        if (height == 0) return 0;
        int width = grid[0].length, sol[][] = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 && j == 0) sol[i][j] = grid[i][j];
                else 
                    sol[i][j] = grid[i][j] + Math.min(i == 0 ? Integer.MAX_VALUE : sol[i - 1][j], j == 0 ? Integer.MAX_VALUE : sol[i][j - 1]);
            }
        }
        return sol[height - 1][width - 1];
    }
}