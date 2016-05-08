class Solution {
public:
    int minPatches(vector<int>& nums, int n) {
        long sum = 0, patch = 0, i = 0;
        while (sum < n) {
            if (i == nums.size() || nums[i] > sum + 1) {
                patch++;
                sum += (sum + 1);
            } else {
                sum += nums[i++];
            }
        }
        return patch;
    }
};
