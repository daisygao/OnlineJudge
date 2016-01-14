class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int tail = nums.size();
        int i = 0;
        while (i < tail) {
            if (nums[i] == val) nums[i] = nums[--tail];
            else i++;
        }
        return tail;
    }
};
