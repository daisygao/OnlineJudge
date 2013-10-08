public class Solution {
    public int removeDuplicates(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int len = A.length, start = 0, end = start, idx = 0;
        while (start < len) {
            while (end + 1 < len && A[end + 1] == A[end]) end++;
            A[idx++] = A[end];
            if (end > start) A[idx++] = A[end];
            end = start = end + 1;
        }
        return idx;
    }
}