class Solution {
public:
    int helper(vector<int> &nums, int target) {
        // find the start position of number equal or larger than target
        int l = 0, r = nums.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else r = m;
        }
        return l;
    }
    vector<int> searchRange(vector<int>& nums, int target) {
        int left = helper(nums, target);
        if (left == nums.size() || nums[left] != target) return {-1, -1};
        return {left, helper(nums, target + 1) - 1};
    }
};
