public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length(), sols[] = new int[len + 1];
        boolean isPalin[][] = new boolean[len][len];
        for (int i = 0; i <= len; i++) sols[i] = len - 1 - i;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 3 || isPalin[i + 1][j - 1])) {
                    isPalin[i][j] = true;
                    sols[i] = Math.min(sols[i], 1 + sols[j + 1]);
                }
            }
        }
        return sols[0];
    }
}