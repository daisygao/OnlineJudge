public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int m = matrix.length;
        if (m == 0) return ans;
        int n = matrix[0].length, layer = 0;
        for (layer = 0; layer < Math.min(m, n) / 2; layer++) {
            // left to right
            for (int i = layer; i < n - layer - 1; i++) ans.add(matrix[layer][i]);
            // top to bottom
            for (int i = layer; i < m - layer - 1; i++) ans.add(matrix[i][n - layer - 1]);
            // right to left
            for (int i = n - layer - 1; i > layer; i--) ans.add(matrix[m - layer - 1][i]);
            // bottom to top
            for (int i = m - layer - 1; i > layer; i--) ans.add(matrix[i][layer]);
        }
        if (Math.min(m, n) % 2 == 1) {
            if (m > n) {
                for (int i = layer; i < m - layer; i++) ans.add(matrix[i][layer]);
            } else {
                for (int i = layer; i < n - layer; i++) ans.add(matrix[layer][i]);
            }
        }
        return ans;
    }
}