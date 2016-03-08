class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size(), n = m ? matrix[0].size() : 0, i = 0, j = m * n - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2, row = mid / n, col = mid % n;
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) i = mid + 1;
            else j = mid - 1;
        }
        return false;
    }
};
