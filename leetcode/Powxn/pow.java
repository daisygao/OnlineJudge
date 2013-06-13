public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n < 0 && n != Integer.MIN_VALUE) return 1.0 / pow(x, -n);
        double half = pow(x, n / 2);
        return half * half * pow(x, n % 2);
    }
}