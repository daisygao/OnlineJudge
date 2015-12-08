class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int idx = -1, cnt = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (idx == -1 || cnt == 0) {
                idx = i;
            }
            if (nums[idx] == nums[i]) cnt++;
            else cnt--;
        }
        return nums[idx];
    }
};
