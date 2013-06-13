public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length(), max = 1, palinLen;
        if (len < 2) return s;
        String result = "";
        for (int i = 0; i < len; i++) {
            palinLen = 0;
            while (i - palinLen >= 0 && i + palinLen + 1 < len && s.charAt(i - palinLen) == s.charAt(i + palinLen + 1)) palinLen++;
            if (max < palinLen * 2) {
                max = palinLen * 2;
                result = s.substring(i - palinLen + 1, i + palinLen + 1);
            }
            palinLen = 0;
            while (i - palinLen - 1 >= 0 && i + palinLen + 1 < len && s.charAt(i - palinLen - 1) == s.charAt(i + palinLen + 1)) palinLen++;
            if (max < palinLen * 2 + 1) {
                max = palinLen * 2 + 1;
                result = s.substring(i - palinLen, i + palinLen + 1);
            }            
        }
        return result;
    }
}