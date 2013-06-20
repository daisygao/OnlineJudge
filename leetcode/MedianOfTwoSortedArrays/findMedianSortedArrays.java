public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int alen = A.length, blen = B.length, len = alen + blen, needed = (len - 1) / 2;
        int ahead = 0, atail = Math.min(alen, needed) - 1, bhead = 0, btail = Math.min(blen, needed) - 1, amid, bmid;
        while (true) {
            
            if (ahead > atail) {
                bhead = needed - ahead;
            } else if (bhead > btail) {
                ahead = needed - bhead;
            }
            
            if (ahead + bhead == needed) {
                int a0 = ahead >= alen ? Integer.MAX_VALUE : A[ahead];
                int b0 = bhead >= blen ? Integer.MAX_VALUE : B[bhead];
                int first = Math.min(a0, b0), second = Math.max(a0, b0);
                int a1 = ahead + 1 >= alen ? Integer.MAX_VALUE : A[ahead + 1];
                int b1 = bhead + 1 >= blen ? Integer.MAX_VALUE : B[bhead + 1];
                second = Math.min(second, a1);
                second = Math.min(second, b1);
                return len % 2 == 0 ? (first + second) / 2.0 : first;
            } 
            
            amid = ahead + (atail - ahead) / 2;
            bmid = bhead + (btail - bhead) / 2;
            if (amid + bmid < needed) {
                if (A[amid] <= B[bmid]) {
                    ahead = amid + 1;
                    //btail = Math.min(btail, needed - ahead);
                } else {
                    bhead = bmid + 1;
                    //atail = Math.min(atail, needed - bhead);
                }
            } else {
                if (A[amid] <= B[bmid]) {
                    btail = bmid - 1;
                } else {
                    atail = amid - 1;
                }
            }
        }
    }
}