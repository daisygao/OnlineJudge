public class Solution {
    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        long d1 = dividend, d2 = divisor, x = 1;
        int sig = 1, res = 0;
        if (d1 < 0) {
            sig = -sig;
            d1 = -d1;
        }
        if (d2 < 0) {
            sig = -sig;
            d2 = -d2;
        }
        while (d1 > d2 + d2) {
            d2 <<= 1;
            x <<= 1;
        }
        while (d1 >= d2 && x > 0) {
            d1 -= d2;
            res += x;
            while (d1 < d2 && x > 0) {
                d2 >>= 1;
                x >>= 1;
            }
        }
        return sig > 0 ? res : -res;
    }
}