class Solution {
public:
    void reverse(vector<int>& nums, int i, int j) {
        if (i >= j) return;
        for (int k = 0; k < (j - i) / 2; k++) {
            int tmp = nums[k + i];
            nums[k + i] = nums[j - 1 - k];
            nums[j - 1 - k] = tmp;
        }
    }
    void rotate(vector<int>& nums, int k) {
        k %= nums.size();
        reverse(nums, 0, nums.size() - k);
        reverse(nums, nums.size() - k, nums.size());
        reverse(nums, 0, nums.size());
    }
};
