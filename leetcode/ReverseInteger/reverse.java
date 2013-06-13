public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x < 0) return -reverse(-x);
        int ret = 0;
        while (x != 0) {
            ret *= 10;
            ret += x % 10;
            x /= 10;
        }
        return ret;
    }
}