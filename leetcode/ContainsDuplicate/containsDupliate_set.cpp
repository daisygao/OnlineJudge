class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_set<int> set;
        pair<unordered_set<int>::iterator, bool> ret;
        for (auto n : nums) {
            ret = set.insert(n);
            if (!ret.second) return true;
        }
        return false;
    }
};
