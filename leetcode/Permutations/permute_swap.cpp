class Solution {
public:
    void helper(vector<vector<int>> &sols, vector<int> &nums, int start) {
        if (start >= nums.size()) {
            sols.push_back(nums);
            return;
        }
        for (int i = start; i < nums.size(); i++) {
            swap(nums[start], nums[i]);
            helper(sols, nums, start + 1);
            swap(nums[start], nums[i]);
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> sols;
        helper(sols, nums, 0);
        return sols;
    }
};
