public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = A.length, i = -1, j = len, k = 0, x;
        while (k < j) {
            if (A[k] == 2) {
                x = A[k];
                A[k] = A[--j];
                A[j] = x;
            } else {
                if (A[k] == 0) {
                    x = A[k];
                    A[k] = A[++i];
                    A[i] = x;
                }
                k++;
            }
        }
    }
}