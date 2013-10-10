public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int height = matrix.length;
        if (height == 0) return false;
        int width = matrix[0].length, l = 0, r = height - 1, m;
        while (l <= r) {
            m = l + (r - l >> 1);
            if (matrix[m][0] == target) return true;
            if (matrix[m][0] > target) r = m - 1;
            else l = m + 1;
        }
        if (r < 0) return false;
        int row = r;
        l = 0;
        r = width - 1;
        while (l <= r) {
            m = l + (r - l >> 1);
            if (matrix[row][m] == target) return true;
            if (matrix[row][m] > target) r = m - 1;
            else l = m + 1;
        }
        return false;
    }
}