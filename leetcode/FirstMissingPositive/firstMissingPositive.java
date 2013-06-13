public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = A.length;
        for (int i = 0; i < len; i++) {
            int x = A[i];
            while (x <= len && x > 0 && A[x - 1] != x) {
                int tmp = A[x - 1];
                A[x - 1] = x;
                x = tmp;
            }
        }
        for (int i = 0; i < len; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }
}