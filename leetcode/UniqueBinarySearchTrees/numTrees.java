public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sols[] = new int[n + 1];
        sols[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                sols[i] += 2 * sols[j - 1] * sols[i - j];
            }
            if (i % 2 != 0) sols[i] += sols[i / 2] * sols[i / 2];
        }
        return sols[n];
    }
}