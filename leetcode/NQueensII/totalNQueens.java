public class Solution {
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean col[] = new boolean[n], diag1[] = new boolean[n + n], diag2[] = new boolean[n + n];
        return helper(0, n, col, diag1, diag2);
    }
    private int helper(int row, int n, boolean col[], boolean diag1[], boolean diag2[]) {
        int sol = 0;
        for (int i = 0; i < n; i++) {
            if (!col[i] && !diag1[i + row] && !diag2[i - row + n]) {
                col[i] = diag1[i + row] = diag2[i - row + n] = true;
                if (row == n - 1) {
                    sol++;
                } else {
                    sol += helper(row + 1, n, col, diag1, diag2);
                }
                col[i] = diag1[i + row] = diag2[i - row + n] = false;
            }
        }
        return sol;
    }
}