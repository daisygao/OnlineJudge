class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        deque<vector<int>> q(1);
        for (auto x : nums) {
           int size = q.size();
            while (size--) {
                vector<int> v = q.front();
                q.pop_front();
                for (int i = 0; i <= v.size(); i++) {
                    vector<int> vv(v);
                    vv.insert(vv.begin() + i, x);
                    q.push_back(vv);
                }
            }
            
        }
        vector<vector<int>> ans(q.begin(), q.end());
        return ans;
    }
};
