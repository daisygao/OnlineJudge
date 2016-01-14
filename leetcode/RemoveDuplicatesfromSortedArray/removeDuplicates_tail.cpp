class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int tail = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (tail < 0 || nums[i] != nums[tail]) nums[++tail] = nums[i]; 
        }
        return tail + 1;
    }
};
