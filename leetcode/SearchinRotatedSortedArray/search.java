public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = A.length, low = 0, high = len - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (A[mid] == target) return mid;
            else if (A[mid] > target) {
                if (A[high] < A[mid] && A[low] > target) low = mid + 1;
                else high = mid - 1;
            } else {
                if (A[low] > A[mid] && A[high] < target) high = mid - 1;
                else low = mid + 1;
            }
        }
        return -1;
    }
}