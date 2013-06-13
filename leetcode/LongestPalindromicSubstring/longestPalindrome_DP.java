public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length(), sol[][] = new int[len][len], max = 0;
        String res = "";
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) sol[i][j] = 1;
                else if (s.charAt(i) == s.charAt(j)) {
                    if (i + 1 == j) sol[i][j] = 2;
                    else {
                        sol[i][j] = sol[i + 1][j - 1] != 0 ? sol[i + 1][j - 1] + 2 : 0; 
                    }
                } else sol[i][j] = 0;
                if (sol[i][j] > max) {
                    max = sol[i][j];
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}