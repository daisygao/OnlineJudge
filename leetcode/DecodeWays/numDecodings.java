public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length(), sols[] = new int[len];
        if (len == 0) return 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != '0') sols[i] += (i == 0 ? 1 : sols[i - 1]);
            if (i > 0 && s.charAt(i - 1) != '0' && Integer.valueOf(s.substring(i - 1, i + 1)) < 27) {
                sols[i] += (i == 1 ? 1 : sols[i - 2]);
            }
        }
        return sols[len - 1];
    }
}