public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = matrix.length;
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (m == 0) return list;
        int n = matrix[0].length, len = Math.min(m, n), layer = len / 2;
        for (int i = 0; i < layer; i++) {
            // left -> right
            for (int j = i; j < n - 1 - i; j++) list.add(matrix[i][j]);
            // top -> bottom
            for (int j = i; j < m - 1 - i; j++) list.add(matrix[j][n - 1 - i]);
            // right -> left
            for (int j = n - 1 - i; j > i; j--) list.add(matrix[m - 1 - i][j]);
            // bottom -> top
            for (int j = m - 1 - i; j > i; j--) list.add(matrix[j][i]);
        }
        if (len % 2 != 0) {
            if (m > n) {
                for (int i = layer; i < m - layer; i++) list.add(matrix[i][layer]);
            } else {
                for (int i = layer; i < n - layer; i++) list.add(matrix[layer][i]);
            }
        }
        return list;
    }
}