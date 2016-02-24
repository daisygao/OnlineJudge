class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        if (nums.size() < 1) return 0;
        int ans = nums[0], cur = 0;
        for (auto x : nums) {
            cur += x;
            ans = max(ans, cur);
            if (cur < 0) cur = 0;
        }
        return ans;
    }
};
