public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length();
        if (len == 0) return 0;
        int sol[] = new int[len];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != '0') sol[i] += i - 1 >= 0 ? sol[i - 1] : 1;
            if (i - 1 >= 0 && s.charAt(i - 1) != '0' 
		&& Integer.parseInt(s.substring(i - 1, i + 1)) < 27) {
                sol[i] += i - 2 >= 0 ? sol[i - 2] : 1;
            }
        }
        return sol[len - 1];
    }
}