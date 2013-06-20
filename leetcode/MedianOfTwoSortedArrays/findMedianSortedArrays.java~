public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int alen = A.length, blen = B.length, len = alen + blen, k = len / 2;
        int alow = 0, ahigh = Math.min(alen, k) - 1, blow = 0, bhigh = Math.min(blen, k) - 1, amid, bmid;
        int Am, Bm, Am_1, Bm_1;
        boolean isEven = len % 2 == 0;
        while (true) {
            if (k == 0) {
                Am_1 = (alow == 0 ? Integer.MIN_VALUE : A[alow - 1]);
                Bm_1 = (blow == 0 ? Integer.MIN_VALUE : B[blow - 1]);
                Am = (alow == A.length ? Integer.MAX_VALUE : A[alow]);
                Bm = (blow == B.length ? Integer.MAX_VALUE : B[blow]);
                return isEven ? (1.0 * Math.min(Am, Bm) + Math.max(Am_1, Bm_1)) / 2 : Math.min(Am, Bm);
            } else if (ahigh - alow == -1) {
                blow += k;
                k = 0;
            } else if (bhigh - blow == -1) {
                alow += k;
                k = 0;
            } else {   
                amid = (alow + ahigh) / 2;
                bmid = (blow + bhigh) / 2;
                Am = A[amid];
                Bm = B[bmid];                
                if (Am == Bm) {
                    k -= (amid - alow + 1);
                    alow = amid + 1;
                    blow += k;
                    k = 0;
                } else if (Am > Bm) {
                    k -= (bmid - blow + 1);
                    blow = bmid + 1;
                    bhigh = Math.min(blen, blow + k) - 1;
                    ahigh = Math.min(amid, alow + k - 1);                
                } else {
                    k -= (amid - alow + 1);
                    alow = amid + 1;
                    ahigh = Math.min(alen, alow + k) - 1;
                    bhigh = Math.min(bmid, blow + k - 1);
                }
            }
        }
    }
}