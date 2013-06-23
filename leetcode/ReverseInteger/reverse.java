public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        long y = x, ans = 0;
        int sig = 1;
        if (y < 0) {
            sig = -1;
            y = -y;
        } 
        while (y > 0) {
            ans *= 10;
            ans += y % 10;
            y /= 10;
        }
        ans *= sig;
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) 
            return sig == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        return (int) ans;
    }
}