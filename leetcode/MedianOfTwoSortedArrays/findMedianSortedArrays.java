public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sum = A.length + B.length;
        return sum % 2 == 0 ? (helper(A, B, sum / 2 - 1) + helper(A, B, sum / 2)) / 2.0 : helper(A, B, sum / 2);
    }
    private double helper(int A[], int B[], int k) {
        int alen = A.length, blen = B.length, al = 0, bl = 0, ar = alen - 1, br = blen - 1, am, bm;
        while (al <= ar || bl <= br) {
            if (al <= ar && bl <= br) {
                am = al + (ar - al >> 1);
                bm = bl + (br - bl >> 1);
                if (A[am] >= B[bm]) {
                    if (k > bm && am + bm + 1 <= k) return helper(A, Arrays.copyOfRange(B, bm + 1, blen), k - bm - 1);
                    else return helper(Arrays.copyOfRange(A, 0, am), B, k);
                } else {
                    if (k > am && am + bm + 1 <= k) return helper(Arrays.copyOfRange(A, am + 1, alen), B, k - am - 1);
                    else return helper(A, Arrays.copyOfRange(B, 0, bm), k);
                } 
            } else if (al <= ar) {
                if (k < alen) return A[k];
            } else {
                if (k < blen) return B[k];
            }
        }
        return 0;
    }
}