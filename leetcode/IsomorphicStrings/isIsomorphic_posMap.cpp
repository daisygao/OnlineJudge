class Solution {
public:
    bool isIsomorphic(string s, string t) {
        if (s.length() != t.length()) return false;
        unordered_map<char, char> spos, tpos;
        for (int i = 0; i < s.length(); i++) {
            if (spos[s[i]] != tpos[t[i]]) return false;
            spos[s[i]] = tpos[t[i]] = i + 1;
        }
        return true;
    }
};
