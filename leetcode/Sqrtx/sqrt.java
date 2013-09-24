public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        double ans = 1;
        while (Math.abs(ans * ans - x) > 1e-6) {
            ans = (ans + x / ans) / 2;
        }
        return (int) ans;
    }
}