public class Solution {
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = S.length(), m = T.length();
        if (n < m) return 0;
        int sols[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                sols[i][j] = (j == 0 ? 0 : sols[i][j - 1]) + (S.charAt(j) == T.charAt(i) ? (i == 0 ? 1 : sols[i - 1][j - 1]) : 0);
            }
        }
        return sols[m - 1][n - 1];
    }
}