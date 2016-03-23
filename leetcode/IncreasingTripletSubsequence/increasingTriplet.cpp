class Solution {
public:
    bool increasingTriplet(vector<int>& nums) {
        int l1 = INT_MAX, l2 = INT_MAX;
        for (auto x : nums) {
            if (x <= l1) l1 = x;
            else if (x <= l2) l2 = x;
            else return true;
        }
        return false;
    }
};
