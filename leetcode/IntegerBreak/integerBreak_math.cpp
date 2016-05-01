class Solution {
public:
    int integerBreak(int n) {
        int x = pow(3, n / 3);
        if (n == 0) return 0;
        else if (n == 1 || n == 2) return 1;
        else if (n == 3) return 2;
        else if (n % 3 == 0) return x;
        else if (n % 3 == 1) return x / 3 * 4;
        else return x * 2;
    }
};
