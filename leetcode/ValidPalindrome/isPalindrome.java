public class Solution {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) sb.append(Character.toLowerCase(c));
        }
        String newStr = sb.toString();
        int newLen = newStr.length();
        for (int i = 0; i < newLen / 2; i++) {
            if (newStr.charAt(i) != newStr.charAt(newLen - 1 - i)) return false;
        }
        return true;
    }
}