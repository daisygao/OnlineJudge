class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> ans(1);
        for (auto x : nums) {
           int size = ans.size();
            while (size--) {
                vector<int> v = ans.front();
                ans.erase(ans.begin());
                for (int i = 0; i <= v.size(); i++) {
                    vector<int> vv(v);
                    vv.insert(vv.begin() + i, x);
                    ans.push_back(vv);
                }
            }
            
        }
        return ans;
    }
};
