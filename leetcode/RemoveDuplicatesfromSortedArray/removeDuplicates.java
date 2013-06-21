public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = A.length, last = -1, cur = 0;
        while (cur < len) {
            while (cur + 1 < len && A[cur + 1] == A[cur]) cur++;
            A[++last] = A[cur++];
        }
        return last + 1;
    }
}