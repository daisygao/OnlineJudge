class Solution {
public:
    bool isIsomorphic(string s, string t) {
        if (s.length() != t.length()) return false;
        unordered_map<char, char> map;
        unordered_set<char> matched;
        for (int i = 0; i < s.length(); i++) {
            char ss = s[i], tt = t[i];
            if (map.find(ss) != map.end()) {
                if (map[ss] != tt) return false;
            } else if (matched.find(tt) != matched.end()) return false;
            else {
                map[ss] = tt;
                matched.insert(tt);
            }
        }
        return true;
    }
};
