public class Solution {
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int slen = S.length(), tlen = T.length();
        if (tlen == 0 || slen < tlen) return 0;
        int sol[][] = new int[tlen][slen];
        for (int i = 0; i < tlen; i++) {
            for (int j = i; j < slen; j++) {
                sol[i][j] = (j == 0 ? 0 : sol[i][j - 1])
		    + (T.charAt(i) == S.charAt(j) ?
		       (i == 0 || j == 0 ? 1 : sol[i - 1][j - 1]) : 0);
            }
        }
        return sol[tlen - 1][slen - 1];
    }
}