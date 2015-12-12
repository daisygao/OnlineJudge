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
            if (i + 1 < len && (adic[s[i + 1]] == val * 5 || adic[s[i + 1]] == val * 10)) ans -= val;
            else ans += val;
        }
        return ans;
    }
};
