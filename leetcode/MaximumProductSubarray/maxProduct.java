public class Solution {
    public int maxProduct(int[] A) {
        int len = A.length;
        if (len == 0) return 0;
        int max[] = new int[len], min[] = new int[len], ans = A[0];
        max[0] = min[0] = A[0];
        for (int i = 1; i < len; i++) {
            max[i] = Math.max(max[i - 1] * A[i], Math.max(A[i], min[i - 1] * A[i]));
            min[i] = Math.min(min[i - 1] * A[i], Math.min(A[i], max[i - 1] * A[i]));
            ans = Math.max(ans, max[i]);
        }
        return ans;
    }
}