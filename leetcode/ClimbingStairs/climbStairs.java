public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sol[] = new int[n + 1];
        sol[0] = 1;
        sol[1] = 1;
        for (int i = 2; i <= n; i++) {
            sol[i] = sol[i - 1] + sol[i - 2];
        }
        return sol[n];
    }
}
