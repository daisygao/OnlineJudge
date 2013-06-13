public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if (l1 + l2 != l3) return false;
        boolean sol[][] = new boolean[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                int k = i + j - 1;
                if (i > 0 && s3.charAt(k) == s1.charAt(i - 1)) {
                    sol[i][j] |= sol[i - 1][j];
                }
                if (j > 0 && s3.charAt(k) == s2.charAt(j - 1)) {
                    sol[i][j] |= sol[i][j - 1];
                }
                if (i == 0 && j == 0) sol[i][j] = true;
            }
        }
        return sol[l1][l2];
    }
}