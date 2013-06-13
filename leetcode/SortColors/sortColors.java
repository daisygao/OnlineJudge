public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = A.length, i = -1, j = 0, k = len, tmp;
        while (j < k) {
            if (A[j] == 0) {
                tmp = A[++i];
                A[i] = A[j];
                A[j] = tmp;
                j++;
            } else if (A[j] == 2) {
                tmp = A[--k];
                A[k] = A[j];
                A[j] = tmp;
            } else {
                j++;
            }
        }
    }
}