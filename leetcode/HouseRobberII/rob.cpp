class Solution {
public:
    int helper(vector<int> &nums, int start, int end) {
        int n1 = 0, n2 = 0, ans = 0;
        for (int i = start; i < end; i++) {
            ans = max(n2 + nums[i], n1);
            n2 = n1;
            n1 = ans;
        }
        return ans;
    }
    int rob(vector<int>& nums) {
        if (nums.size() == 1) return nums[0];
        int ans1 = helper(nums, 0, nums.size() - 1), ans2 = helper(nums, 1, nums.size());
        return max(ans1, ans2);
    }
};
