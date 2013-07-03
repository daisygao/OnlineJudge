public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sols[] = new int[n + 1];
        sols[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                sols[i] += sols[i - j] * sols[j - 1];
            }
        }
        return sols[n];
    }
}