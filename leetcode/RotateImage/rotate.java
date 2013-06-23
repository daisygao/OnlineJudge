public class Solution {
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = matrix.length;
        //if (n == 0) return;
        int layer = n / 2;
        for (int i = 0; i < layer; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int x = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = x;
            }
        }
    }
}