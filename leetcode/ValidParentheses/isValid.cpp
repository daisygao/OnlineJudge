class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        for (char c : s) {
            if (c == '(' || c == '[' || c == '{') st.push(c);
            else {
                if (st.empty()) return false;
                char top = st.top();
                switch(c) {
                    case ')': if (top != '(') return false; break;
                    case ']': if (top != '[') return false; break;
                    case '}': if (top != '{') return false; break;
                    default: return false;
                }
                st.pop();
            }
        }
        return st.empty();
    }
};
