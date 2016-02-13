class Solution {
public:
    int countPrimes(int n) {
        int ans = 0, upperBound = sqrt(n);
        vector<bool> isPrime(n, true);
        for (int i = 2; i < n; i++) {
            if (isPrime[i - 1]) ans++;
            if (i > upperBound) {
                continue;
            }
            for (int j = i; j * i < n; j++) isPrime[i * j - 1] = false;
        }
        return ans;
    }
};
