public class Solution {
    public int minDistance(String word1, String word2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int len1 = word1.length(), len2 = word2.length(), sols[][] = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) sols[i][j] = Math.max(i, j);
                else sols[i][j] = Math.min(sols[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1), Math.min(sols[i - 1][j], sols[i][j - 1]) + 1);
            }
        }
        return sols[len1][len2];
    }
}