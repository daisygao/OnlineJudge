class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int ans = 0;
        for (int x : nums) {
            if (ans < 2 || x != nums[ans - 2]) nums[ans++] = x;
        }
        return ans;
    }
};
