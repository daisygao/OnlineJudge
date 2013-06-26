public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int ans[] = new int[2], len = A.length, low = 0, high = len - 1, mid;
        ans[0] = -1;
        ans[1] = -1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (A[mid] == target) {
                int left[] = searchRange(Arrays.copyOfRange(A, low, mid), target);
                int right[] = searchRange(Arrays.copyOfRange(A, mid + 1, high + 1), target);
                ans[0] = left[0] == -1 ? mid : low + left[0];
                ans[1] = right[1] == -1 ? mid : mid + 1 + right[1];
                break;
            } else if (A[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}