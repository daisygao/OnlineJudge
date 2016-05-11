class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        int maxDiff = INT_MAX, ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            int j = i + 1, k = nums.size() - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k], absDiff = abs(sum - target);
                if (absDiff < maxDiff) {
                    maxDiff = absDiff;
                    ans = sum;
                    
                }
                if (sum < target) j++;
                else if (sum > target) k--;
                else return target;
                
            }
        }
        return ans;
    }
};
