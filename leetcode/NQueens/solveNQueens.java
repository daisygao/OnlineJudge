public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sol[] = new int[n];
        boolean col[] = new boolean[n], diag1[] = new boolean[n + n], diag2[] = new boolean[n + n];
        ArrayList<String[]> result = new ArrayList<String[]>();
        helper(0, n, sol, col, diag1, diag2, result);
        return result;
    }
    private void helper(int row, int n, int sol[], boolean col[], boolean diag1[], boolean diag2[], ArrayList<String[]> result) {
        for (int i = 0; i < n; i++) {
            if (!col[i] && !diag1[i + row] && !diag2[i - row + n]) {
                sol[row] = i;
                col[i] = diag1[i + row] = diag2[i - row + n] = true;
                if (row == n - 1) {
                    String ans[] = new String[n];
                    char line[] = new char[n];
                    for (int j = 0; j < n; j++) {
                        int k = -1;
                        while (++k < n) {
                            line[k] = sol[j] == k ? 'Q' : '.';
                        }
                        ans[j] = new String(line);
                    }
                    result.add(ans);
                } else {
                    helper(row + 1, n, sol, col, diag1, diag2, result);
                }
                col[i] = diag1[i + row] = diag2[i - row + n] = false;
            }
        }
    }
}