public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int a = m - 1, b = n - 1, c = m + n - 1;
        while (a >= 0 && b >= 0) {
            A[c--] = A[a] >= B[b] ? A[a--] : B[b--];
        }
        while (b >= 0) {
            A[c--] = B[b--];
        }
    }
}