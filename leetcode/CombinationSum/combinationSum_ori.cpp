class Solution {
public:
    void helper(vector<vector<int>> &ans, vector<int> &ins, vector<int>& candidates, int idx, int target) {
        if (idx == candidates.size()) return;
        for (int i = idx; i < candidates.size(); i++) {
            if (candidates[i] == target) {
                ins.push_back(candidates[i]);
                ans.push_back(ins);
                ins.pop_back();
            } else if (candidates[i] < target) {
                ins.push_back(candidates[i]);
                helper(ans, ins, candidates, i, target - candidates[i]);
                ins.pop_back();
            } else break;
        }
    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<vector<int>> ans;
        vector<int> ins;
        helper(ans, ins, candidates, 0, target);
        return ans;
    }
};
