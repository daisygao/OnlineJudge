public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = A.length, last = -1, start = 0, end = 0;
        while (start < len) {
            while (end + 1 < len && A[end + 1] == A[start]) end++;
            A[++last] = A[start];
            if (start != end) A[++last] = A[start];
            end++;
            start = end;
        }
        return last + 1;
    }
}