public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x < 0) return -1;
        if (x == 0 || x == 1) return x;
        double low = 0, high = x > 1 ? x : 1, mid, ret;
        while (low < high) {
            mid = low + (high - low) / 2;
            ret = mid * mid;
            if (Math.abs(ret - x) < 0.001) {
                return (int)mid;
            }
            if (ret < x) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return -1;
    }
}