class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size(), n2 = 0, n1 = 0;
        for (int i = 0; i < n; i++) {
            int ans = max(n2 + nums[i], n1);
            n2 = n1;
            n1 = ans;
        }
        return n1;
    }
};
