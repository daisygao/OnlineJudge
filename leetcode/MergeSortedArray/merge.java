public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int a = m - 1, b = n - 1, i = m + n - 1;
        while (b >= 0) {
            A[i--] = a >= 0 && A[a] > B[b] ? A[a--] : B[b--];
        }
    }
}