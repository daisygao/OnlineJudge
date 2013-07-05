public class Solution {
    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length(), i = 0, end = len - 1;
        while (i < len && s.charAt(i) == ' ') i++;
        while (end > i && s.charAt(end) == ' ') end--;
        if (i > end) return false;
        boolean dot = false, e = false, sig = false, hasNumber = false;
        while (i <= end) {
            char c = s.charAt(i);
            if (c == '.') {
                if (!dot && !e) dot = true;
                else return false;
            } else if (c == 'e') {
                if (!e && hasNumber) {
                    e = true;
                    dot = hasNumber = sig = false;
                }
                else return false;
            } else if (c == '+' || c == '-') {
                if (!sig && !hasNumber && !dot) sig = true;
                else return false;
            }else if (Character.isDigit(c)) {
                hasNumber = true;
            }
            else return false;
            i++;
        }
        return hasNumber;
    }
}