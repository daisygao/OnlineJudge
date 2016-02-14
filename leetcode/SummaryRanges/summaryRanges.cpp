class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        vector<string> ans;
        for (int i = 0, j = 0; j < nums.size(); j++) {
            if (j == nums.size() - 1 || nums[j] + 1 != nums[j + 1]) {
                ans.push_back(to_string(nums[i]));
                if (nums[i] != nums[j]) ans.back() += "->" + to_string(nums[j]);
                i = j + 1; 
            }
        }
        return ans;
    }
};
