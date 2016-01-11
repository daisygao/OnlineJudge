public class Solution {
    public boolean isPowerOfThree(int n) {
        double pow = Math.log10(n) / Math.log10(3);
        return n > 0 && (pow - Math.floor(pow) < 1e-12);
    }
}
