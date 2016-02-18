class Solution {
public:
    int maxProduct(vector<string>& words) {
        int ans = 0;
        sort(words.begin(), words.end(), [](const string &a, const string &b) -> bool {
            return a.size() > b.size();
        });
        
        unordered_set<int> set;
        for (int i = 0; i < int(words.size()) - 1; i++) {
            set.clear();
            for (char c : words[i]) set.insert(c - 'a');
            for (int j = 1; j < words.size(); j++) {
                bool valid = true;
                for (char c : words[j]) {
                    if (set.find(c - 'a') != set.end()) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    int newLen = int(words[i].size() * words[j].size());
                    ans = max(ans, newLen);
                    break;
                }
            }
        }
        return ans;
    }
};
