class Solution {
public:
    bool isAnagram(string s, string t) {
        vector<int> cnts(26, 0);
        if (s.length() != t.length()) return false;
        for (auto c : s) {
            cnts[c - 'a']++;
        }
        for (auto c : t) {
            cnts[c - 'a']--;
        }
        for (int n : cnts) {
            if (n) return false;
        }
        return true;
    }
};
