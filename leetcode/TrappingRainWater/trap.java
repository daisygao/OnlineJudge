public class Solution {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = A.length, left[] = new int[len], ans = 0, right = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            left[i] = Math.max(A[i], i == 0 ? 0 : left[i - 1]);
        }
        for (int i = len - 1; i >= 0; i--) {
            right = Math.max(right, A[i]);
            ans += Math.min(left[i], right) - A[i];
        }
        return ans;
    }
}