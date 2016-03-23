class Solution {
public:
    int nthSuperUglyNumber(int n, vector<int>& primes) {
        int size = primes.size();
        vector<int> ans(n, INT_MAX), idx(size, 0);
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < size; j++)
                ans[i] = min(ans[i], ans[idx[j]] * primes[j]);
            for (int j = 0; j < size; j++) {
                if (ans[i] % primes[j] == 0) idx[j]++;
            }
        }
        return ans[n - 1];
    }
};
