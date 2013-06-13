public class Solution {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int matrix[][] = new int[n][n];
        int layer = n / 2, cnt = 0;
        for (int i = 0; i < layer; i++) {
            for (int j = i; j < n - 1 - i; j++) matrix[i][j] = ++cnt;
            for (int j = i; j < n - 1 - i; j++) matrix[j][n - 1 - i] = ++cnt;
            for (int j = n - 1 - i; j > i; j--) matrix[n - 1 - i][j] = ++cnt;
            for (int j = n - 1 - i; j > i; j--) matrix[j][i] = ++cnt;
        }
        if (n % 2 != 0) matrix[layer][layer] = ++cnt;
        return matrix;
    }
}