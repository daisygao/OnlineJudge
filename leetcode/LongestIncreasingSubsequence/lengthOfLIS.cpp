class Solution {
public:
    int search(vector<int>& nums, int val) {
        int left = 0, right = nums.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < val) left = mid + 1;
            else right = mid;
        }
        return left;
    }
    int lengthOfLIS(vector<int>& nums) {
        vector<int> activeLists;
        for (int x : nums) {
            int idx = search(activeLists, x);
            if (idx == activeLists.size()) activeLists.push_back(x);
            else activeLists[idx] = x;
        }
        return activeLists.size();
    }
};
