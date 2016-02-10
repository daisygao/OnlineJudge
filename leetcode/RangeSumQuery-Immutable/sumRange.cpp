class NumArray {
public:
    vector<int> sums;
    NumArray(vector<int> &nums) {
        sums.resize(nums.size());
        for (int i = 0; i < nums.size(); i++) {
            sums[i] = nums[i] + (i == 0 ? 0 : sums[i - 1]);
        }
    }

    int sumRange(int i, int j) {
        return sums[j] - (i == 0 ? 0 : sums[i - 1]);
    }
};


// Your NumArray object will be instantiated and called as such:
// NumArray numArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
