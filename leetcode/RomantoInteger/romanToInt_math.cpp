class Solution {
public:
    int romanToInt(string s) {
        int vals[] = {1, 5, 10, 50, 100, 500, 1000};
        char abets[] = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        map<char, int> adic;
        int N = sizeof(vals) / sizeof(int);
        for (int i = 0; i < N; i++) {
            adic[abets[i]] = vals[i];
        }
        int ans = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            int val = adic[s[i]];
            ans += val - 2 * (ans % val);
        }
        return ans;
    }
};
