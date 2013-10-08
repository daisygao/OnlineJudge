public class Solution {
    public int search(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int l = 0, r = A.length - 1, m;
        while (l <= r) {
            m = l + (r - l >> 1);
            if (A[m] == target) return m;
            if (A[l] <= A[m]) {
                if (A[l] <= target && target < A[m]) r = m - 1;
                else l = m + 1;
            } else {
                if (A[m] < target && target <= A[r]) l = m + 1;
                else r = m - 1;
            }
        }
        return -1;
    }
}