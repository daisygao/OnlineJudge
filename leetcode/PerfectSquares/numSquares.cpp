class Solution {
public:
    int numSquares(int n) {
        vector<int> map(n + 1, INT_MAX);
        map[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                map[i] = min(map[i], 1 + map[i - j * j]);
            }
        }
        return map[n];
    }
};
