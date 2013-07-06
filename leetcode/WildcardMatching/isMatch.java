public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int slen = s.length(), plen = p.length(), spos = 0, ppos = 0, i = 0, j = 0;
        if (plen == 0) return slen == plen;
        boolean star = false;
        while (j < slen) {
            char pchar = (i == plen ? '\0' : p.charAt(i)), schar = s.charAt(j);
            if (pchar == schar || pchar == '?') {
                i++;
                j++;
            } else if (pchar == '*') {
                if (i < plen && p.charAt(i) == '*') i++;
                if (i == plen) return true;
                ppos = i;
                spos = j;
                star = true;
            } else if (pchar != schar && star) {
                i = ppos;
                j = ++spos;
            } else return false;
        }
        while (i < plen) {
            if (p.charAt(i) != '*') return false;
            i++;
        }
        return true;
    }
}
