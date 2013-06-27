public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        double ans = x;
        while (Math.abs(ans * ans - x) > 0.000001) {
            ans = (x / ans + ans) / 2;
        }
        return (int) ans;
    }
}