public class Solution {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int layer = 0, num = 0, matrix[][] = new int[n][n];
        for (; layer < n / 2; layer++) {
            for (int i = layer; i < n - layer - 1; i++) matrix[layer][i] = ++num;
            for (int i = layer; i < n - layer - 1; i++) matrix[i][n - layer - 1] = ++num;
            for (int i = n - layer - 1; i > layer; i--) matrix[n - layer - 1][i] = ++num;
            for (int i = n - layer - 1; i > layer; i--) matrix[i][layer] = ++num;
        }
        if (n % 2 == 1) {
            matrix[layer][layer] = ++num;
        }
        return matrix;
    }
}