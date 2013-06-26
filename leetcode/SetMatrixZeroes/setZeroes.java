public class Solution {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int height = matrix.length;
        if (height == 0) return;
        int width = matrix[0].length, col0 = matrix[0][0];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j == 0) col0 = 0;
                    else matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) 
                    matrix[i][j] = 0;
            }
        }
        if (matrix[0][0] == 0) {
            for (int i = 1; i < width; i++) matrix[0][i] = 0;
        }
        if (col0 == 0) {
            for (int i = 0; i < height; i++) matrix[i][0] = 0;
        }
    }
}