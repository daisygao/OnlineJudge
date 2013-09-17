class Solution {
public:
    vector<int> twoSum(vector<int> &numbers, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        typedef unordered_map<int, vector<int>> hashmap;
        hashmap inv;
        vector<int> ans;
        for (int i = 0; i < numbers.size(); i++) {
            inv[numbers[i]].push_back(i + 1);
        }
        for (hashmap::iterator it = inv.begin(); it != inv.end(); it++) {
            if (inv.find(target - it->first) != inv.end() && (it->first * 2 != target || it->second.size() > 1)) {
                int x = it->second.back();
                it->second.pop_back();
                int y = inv[target - it->first].back();
                ans.push_back(min(x, y));
                ans.push_back(max(x, y));
                break;
            }
        }
        return ans;
    }
};