class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        int diff = 0;
        for (auto x : nums) diff ^= x;
        diff &= (-diff);
        vector<int> ans = {0, 0};
        for (auto x : nums) {
            if (x & diff) ans[0] ^= x;
            else ans[1] ^= x;
        }
        return ans;
    }
};
