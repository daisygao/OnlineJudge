class Solution {
public:
    int maxProduct(vector<string>& words) {
        int ans = 0;
        sort(words.begin(), words.end(), [](const string &a, const string &b) -> bool {
            return a.size() > b.size();
        });
        
        vector<int> masks(words.size(), 0);
        for (int i = 0; i < words.size(); i++) {
            for (char c : words[i]) {
                masks[i] |= (1 << (c - 'a'));
            }
        }
        for (int i = 0; i < int(words.size()) - 1; i++) {
            for (int j = 1; j < words.size(); j++) {
                int product = words[i].size() * words[j].size();
                if (product < ans) break;
                if ((masks[i] & masks[j]) == 0) {
                    ans = max(ans, product);
                    break;
                }
            }
        }
        return ans;
    }
};
