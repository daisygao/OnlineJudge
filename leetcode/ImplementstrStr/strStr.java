public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1 = haystack.length(), len2 = needle.length();
        for (int i = 0; i <= len1 - len2; i++) {
            boolean found = true;
            for (int j = 0; j < len2; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) return haystack.substring(i, len1);
        }
        return null;
    }
}