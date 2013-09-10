public class Solution {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            } else {
                if (Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) return false;
            }
        }
        return true;
    }
}