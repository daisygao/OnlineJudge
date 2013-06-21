public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int slen = s.length(), plen = p.length();
        boolean star = plen > 1 && p.charAt(1) == '*' ? true : false;
        if (plen == 0) return plen == slen;
        char schar = (slen == 0 ? '\0' : s.charAt(0));
        if (schar == p.charAt(0) || p.charAt(0) == '.') {
            if (star) return (slen > 0 && isMatch(s.substring(1), p)) || isMatch(s, p.substring(2));
            else return slen > 0 && isMatch(s.substring(1), p.substring(1));
        } else if (star) {
            return isMatch(s, p.substring(2));
        }
        return false;
    }
}