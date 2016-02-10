class Solution {
public:
    string addBinary(string a, string b) {
        int la = a.size(), lb = b.size();
        int res = 0;
        string ans = "";
        for (int i = 0; i < max(la, lb) || res; i++) {
            res += i < la ? a[la - 1 - i] - '0' : 0;
            res += i < lb ? b[lb - 1 - i] - '0' : 0;
            ans = to_string(res % 2) + ans;
            res /= 2;
        }
        return ans;
    }
};
