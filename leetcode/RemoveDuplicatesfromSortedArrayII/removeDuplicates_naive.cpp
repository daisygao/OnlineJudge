class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int ans = 0, cur = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (i < 1 || nums[i] == nums[i - 1]) cur++;
            else cur = 1;
            if (cur <= 2) {
                nums[ans++] = nums[i];
            }
        }
        return ans;
    }
};
