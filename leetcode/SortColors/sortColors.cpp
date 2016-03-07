class Solution {
public:
    void sortColors(vector<int>& nums) {
        int i0 = -1, i2 = nums.size(), i = 0;
        while (i < i2) {
            if (nums[i] == 2) {
                nums[i] = nums[--i2];
                nums[i2] = 2;
            }
            if (nums[i] == 0) {
                nums[i++] = nums[++i0];
                nums[i0] = 0;
            }
            if (nums[i] == 1) i++;
        }
    }
};
