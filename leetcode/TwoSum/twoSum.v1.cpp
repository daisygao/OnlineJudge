ss Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, vector<int>> dict;
        vector<int> ans;
        for (int i = 0; i < nums.size(); i++) dict[nums[i]].push_back(i);
        for (auto &v : dict) {
            if (dict.find(target - v.first) != dict.end()) {
                if (target - v.first != v.first || v.second.size() > 1) {
                    ans.push_back(v.second.back());
                    v.second.pop_back();
                    ans.push_back(dict[target - v.first].back());
                    break;
                }
            }
        }
        return ans;
    }
};
