class Solution {
public:
  vector<int> twoSum(vector<int>& nums, int target) {
    unordered_map<int, vector<int>> dict;
    vector<int> ans;
    for (int i = 0; i < nums.size(); i++) dict[nums[i]].push_back(i);
    for (auto v : dict) {
      if (dict.find(target - v.first) != dict.end()) {
        if (target - v.first != v.first) {
          ans.push_back(v.second[0]);
          ans.push_back(dict[target - v.first][0]);
          break;
        } else if (v.second.size() > 1) {
          ans.push_back(v.second[0]);
          ans.push_back(v.second[1]);
          break;
        }
      }
    }
    return ans;
  }
};
