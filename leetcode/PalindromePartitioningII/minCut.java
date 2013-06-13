public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length();
        boolean isPalin[][] = new boolean[len][len];
        int sol[] = new int [len + 1];
        for (int i = len; i >= 0; i--) {
            sol[i] = len - 1 - i;
            if (i == len) continue;
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPalin[i + 1][j - 1])) {
                    isPalin[i][j] = true;
                    sol[i] = Math.min(sol[i], 1 + sol[j + 1]);
                }
            }
        }
        return sol[0];
    }
}