public class Solution {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l1 = word1.length(), l2 = word2.length();
        int sol[][] = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i == 0 || j == 0) sol[i][j] = Math.max(i, j);
                else {
                    sol[i][j] = Math.min(sol[i - 1][j], sol[i][j - 1]) + 1;
                    sol[i][j] = Math.min(sol[i][j], sol[i - 1][j - 1]
					 + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1));
                }
            }
        }
        return sol[l1][l2];
    }
}