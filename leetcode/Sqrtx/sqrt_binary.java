public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x == 0 || x == 1) return x;
        if (x < 0) return -1;
        int l = 1, r = x, m;
        while (l <= r) {
            m = l + (r - l >> 1);
            int y = x / m;
            if (y == m) return m;
            if (y > m) l = m + 1;
            else r = m - 1;
        }
        return r;
    }
}