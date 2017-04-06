class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<pair<int, int>> nums_idx;
        vector<int> ans;
        for (int i = 0; i < nums.size(); i++) nums_idx.push_back(make_pair(nums[i], i));
        // leetcode doesn't support auto in lambda, so using pair<int, int>
        sort(nums_idx.begin(), nums_idx.end(), [](pair<int, int> &left, pair<int, int> &right) {
           return left.first < right.first; 
        });
        
        for (int i = 0, j = nums_idx.size() - 1; i < j; ) {
            int sum = nums_idx[i].first + nums_idx[j].first;
            if (sum == target) {
                ans.push_back(nums_idx[i].second);
                ans.push_back(nums_idx[j].second);
                break;
            } else if (sum < target) i++;
            else j--;
        }
        return ans;
    }
};
