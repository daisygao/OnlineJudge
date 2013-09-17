public class Solution {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l = 0, r = A.length - 1, m;
        while (l <= r) {
            m = l + (r - l >> 1);
            if (target == A[m]) return true;
            else if (A[l] == A[m]) l++;
            else if (A[l] < A[m]) {
                if (target >= A[l] && target < A[m]) r = m - 1;
                else l = m + 1;
            } else {
                if (target > A[m] && target <= A[r]) l = m + 1;
                else r = m - 1;
            }
        }
        return false;
    }
}