class Solution {
public:
    vector<vector<int>> helper(int cur, int k, int n) {
        vector<vector<int>> ans;
        for (int i = cur; i >= 1; i--) {
            if (i == n && k == 1) {
                ans.push_back(vector<int>(1, i));
            } else if (i < n && k) {
                for (auto v : helper(i - 1, k - 1, n - i)) {
                    v.push_back(i);
                    ans.push_back(v);
                }
            }
        }
        return ans;
    }
    vector<vector<int>> combinationSum3(int k, int n) {
        return helper(9, k, n);
    }
};
