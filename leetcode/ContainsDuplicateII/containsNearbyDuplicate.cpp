class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        unordered_map<int, int> pos;
        for (int i = 0; i < nums.size(); i++) {
            int x = nums[i];
            if (pos.find(x) != pos.end()) {
                if (i - pos[x] <= k) return true; 
            }
            pos[x] = i;
        }
        return false;
    }
};
