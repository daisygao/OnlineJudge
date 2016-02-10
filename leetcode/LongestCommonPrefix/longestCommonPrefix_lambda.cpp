class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        int minLen = INT_MAX;
        string ans = "";
        if (strs.size() == 0) return ans;
        for_each(strs.begin(), strs.end(), [&](string s) { minLen = min(minLen, int(s.length())); });
        for (int i = 0; i < minLen; i++) {
            char c = '\0';
            for (string s : strs) {
                if (c != '\0' && s[i] != c) return ans;
                c = s[i];
            }
            ans += c;
        }
        return ans;
    }
};
