public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int ans[] = new int[2];
        int left = bs(A, target - 1), right = bs(A, target);
        if (right != -1 && A[right] != target) right = -1;
        ans[1] = right;
        ans[0] = right == -1 ? -1 : left + 1;
        return ans;
    }
    private int bs(int[] A, int target) {
        int len = A.length, low = 0, high = len - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (A[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
}