class Solution {
public:
    void helper(int left, int right, string str, vector<string> &ans) {
        if (!left && !right) ans.push_back(str);
        if (left) {
            helper(left - 1, right, str + '(', ans);    
        } 
        if (right > left) {
            helper(left, right - 1, str + ')', ans);
        }
    }
    vector<string> generateParenthesis(int n) {
        vector<string> ans;
        helper(n, n, "", ans);
        return ans;
    }
};
