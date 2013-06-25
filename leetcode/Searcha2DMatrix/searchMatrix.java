public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int height = matrix.length;
        if (height == 0) return false;
        int width = matrix[0].length, head = 0, tail = height - 1, mid;
        if (width == 0) return false;
        while (head <= tail) {
            mid = head + (tail - head) / 2;
            if (matrix[mid][0] == target) return true;
            else if (matrix[mid][0] > target) tail = mid - 1;
            else head = mid + 1;
        }
        int row = tail;
        if (row < 0) return false;
        head = 0;
        tail = width - 1;
        while (head <= tail) {
            mid = head + (tail - head) / 2;
            if (matrix[row][mid] == target) return true;
            else if (matrix[row][mid] > target) tail = mid - 1;
            else head = mid + 1;
        }
        return false;
    }
}