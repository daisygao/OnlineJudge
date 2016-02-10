class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (!strs.size()) return "";
        int idx = 0;
        while (1) {
            char c = '\0';
            for (auto s : strs) {
                if (s.size() < idx + 1) return s.substr(0, idx);
                if (c != '\0' && s[idx] != c) return s.substr(0, idx);
                else c = s[idx];
            }
            idx++;
        } 
    }
};
