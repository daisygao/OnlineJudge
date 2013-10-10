public class Solution {
    public void sortColors(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int len = A.length, i0 = -1, i1 = 0, i2 = len;
        while (i1 < i2) {
            if (A[i1] == 2) {
                A[i1] = A[--i2];
                A[i2] = 2;
            } else {
                if (A[i1] == 0) {
                    A[i1] = A[++i0];
                    A[i0] = 0;
                }
                i1++;
            }
        }
    }
}