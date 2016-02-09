class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        map<char, char> map({
            {'(', ')'}, 
            {'[', ']'}, 
            {'{', '}'}});
        for (char c : s) {
            if (c == '(' || c == '[' || c == '{') st.push(c);
            else {
                if (st.empty() || map[st.top()] != c) return false;
                st.pop();
            }
        }
        return st.empty();
    }
};
