public class Solution {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int bits = 32, cnt[] = new int[bits], ans = 0;
        for (int x : A) {
            for (int i = 0; i < bits; i++) {
                cnt[i] += (x & 1) > 0 ? 1 : 0;
                x >>= 1;
            }
        }
        for (int i = bits - 1; i >= 0; i--) {
            ans |= (cnt[i] % 3 == 0 ? 0 : 1);
            if (i != 0) ans <<= 1;
        }
        return ans;
    }
}