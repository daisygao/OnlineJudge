public class Solution {
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = matrix.length;
        if (n < 2) return;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer, last = n - layer - 1;
            for (int idx = layer; idx < last; idx++) {
                int offset = idx - layer;
                int top = matrix[layer][idx];
                matrix[layer][idx] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[first + offset][last];
                matrix[first + offset][last] = top;
            }
        }
    }
}