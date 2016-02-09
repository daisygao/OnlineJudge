class Solution {
public:
    vector<string> strsplit(string str, char sep = ' ') {
        vector<string> ans;
        stringstream ss(str);
        string word;
        while (getline(ss, word, sep)) {
            ans.push_back(word);
        }
        return ans;
    }
    bool wordPattern(string pattern, string str) {
        vector<string> words = strsplit(str);
        if (pattern.size() != words.size()) return false;
        unordered_map<char, int> ppos;
        unordered_map<string, int> wpos;
        for (int i = 0; i < pattern.size(); i++) {
            if (ppos[pattern[i]] != wpos[words[i]]) return false;
            ppos[pattern[i]] = wpos[words[i]] = i + 1;
        }
        return true;
    }
};
