class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int len = nums.size(), i = 0, j = 0;
        if (!len) return;
        while (i < len && j < len) {
            while (nums[i]) i++;
            j = i + 1;
            while (j < len && !nums[j]) j++;
            if (j < len) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
            }
        }
    }
};
