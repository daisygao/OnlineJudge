class Solution {
public:
    int climbStairs(int n) {
        if (n ==  0) return 0;
        int s1 = 1, s2 = 1;
        int ans = s1;
        for (int i = 2; i <= n; i++) {
            ans = s1 + s2;
            s1 = s2;
            s2 = ans;
        }
        return ans;
    }
};
