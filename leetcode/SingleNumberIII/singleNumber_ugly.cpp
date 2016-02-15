class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        vector<int> ans;
        if (nums.size() < 2) return ans; 
        int AxorB = nums[0], flag = 1, i = 1;
        for (; i < nums.size(); i++)  AxorB ^= nums[i];
        while ((AxorB & 1) == 0) {
            flag <<= 1;
            AxorB >>= 1;
        }
        int A = nums[0], Aflag = (A & flag), B = 0, Binit = 0;
        for (i = 1; i < nums.size(); i++) {
            if ((nums[i] & flag) == Aflag) A ^= nums[i];
            else if (!Binit) {
                B = nums[i];
                Binit = 1;
            } else B ^= nums[i];
        }
        ans.push_back(A);
        ans.push_back(B);
        return ans;
    }
};
