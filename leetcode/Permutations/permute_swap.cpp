class Solution {
public:
    void helper(vector<vector<int>> &sols, vector<int> &sol, vector<int> &nums, int start) {
        if (sol.size() == nums.size()) {
            sols.push_back(sol);
            return;
        }
        for (int i = start; i < nums.size(); i++) {
            swap(nums[start], nums[i]);
            sol.push_back(nums[start]);
            helper(sols, sol, nums, start + 1);
            sol.pop_back();
            swap(nums[start], nums[i]);
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> sols;
        vector<int> sol;
        helper(sols, sol, nums, 0);
        return sols;
    }
};
