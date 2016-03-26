class Solution {
public:
    vector<string> split(string str, char sep = ',') {
        stringstream ss(str);
        string s;
        vector<string> ans;
        while (getline(ss, s, sep)) {
            ans.push_back(s);
        }
        return ans;
    }
    
    bool isValidSerialization(string preorder) {
        stack<int> st;
        if (preorder == "#") return true;
        vector<string> nodes = split(preorder, ',');
        for (int i = 0; i < nodes.size(); i++) {
            string s = nodes[i];
            if (s == "#") {
                if (st.empty()) return false;
                st.top()++;
            } else {
                st.push(0);
            }
            while (!st.empty() && st.top() == 2) {
                st.pop();
                if (!st.empty()) st.top()++;
            }
            if (st.empty()) return i == nodes.size() - 1;
        }
        return false;
    }
};
