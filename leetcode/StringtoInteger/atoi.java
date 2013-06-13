
public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = str.length(), i = 0, sign = 1;
        while (i < len && str.charAt(i) == ' ') i++;
        if (i >= len) return 0;
        char c = str.charAt(i);
        if (c == '-' || c == '+') {
            sign = c == '-' ? -1 : 1;
            i++;
        }
        long val = 0;
        for (; i < len; i++) {
            c = str.charAt(i);
            if (c > '9' || c < '0') break;
            val *= 10;
            val += c - '0';
        }
        val *= sign;
        if (val > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if (val < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)val;
    }
}
