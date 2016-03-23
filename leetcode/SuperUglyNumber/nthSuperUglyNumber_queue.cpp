class Solution {
public:
    int nthSuperUglyNumber(int n, vector<int>& primes) {
        int ans = 1, cnt = 1, size = primes.size();
        vector<queue<int>> ques(size);
        for (int i = 0; i < size; i++) ques[i].push(primes[i]);
        while (cnt < n) {
            int min = INT_MAX, minIdx = 0;
            for (int i = 0; i < size; i++) {
                if (ques[i].front() < min) {
                    min = ques[i].front();
                    minIdx = i;
                }
            }
            
            ans = min;
            ques[minIdx].pop();
            for (int i = minIdx; i < size; i++) {
                ques[i].push(primes[i] * min);
            }
            cnt++;
        }
        return ans;
    }
};
