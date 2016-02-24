class Solution {
public:
    vector<string> generateParenthesis(int n) {
        queue<string> strq;
        queue<int> leftq;
        vector<string> ans;
        if (n > 0) {
            strq.push("(");
            leftq.push(1);
        }
        while (!strq.empty()) {
            int size = strq.size();
            while (size-- > 0) {
                string s = strq.front();
                int left = leftq.front();
                int right = s.size() - left;
                if (left < n) {
                    strq.push(s + "(");
                    leftq.push(left + 1);
                }
                if (right < left) {
                    strq.push(s + ")");
                    leftq.push(left);
                }
                if (left == n && right == n) ans.push_back(s);
                strq.pop();
                leftq.pop();
            }
        }
        return ans;
    }
};
