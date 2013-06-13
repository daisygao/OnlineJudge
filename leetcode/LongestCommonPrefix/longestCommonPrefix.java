public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = strs.length, idx = 0;
        if (len == 0) return "";
        while (true) {
            char c = '\0';
            for (String s : strs) {
                int slen = s.length();
                if (idx >= slen) return s.substring(0, idx);
                if (c == '\0') c = s.charAt(idx);
                else if (s.charAt(idx) != c) 
                    return s.substring(0, idx);
            }
            idx++;
        }
    }
}