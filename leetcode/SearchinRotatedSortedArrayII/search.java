public class Solution {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = A.length, low = 0, high = len - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (A[mid] == target) return true;
            if (A[low] < A[mid]) {
                if (A[low] <= target && target < A[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (A[low] > A[mid]) {
                if (A[mid] < target && target <= A[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                low++;
            }
        }
        return false;
    }
}