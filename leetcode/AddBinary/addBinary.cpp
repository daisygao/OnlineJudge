class Solution {
public:
    string addBinary(string a, string b) {
        int la = a.size(), lb = b.size();
        int add = 0;
        string ans = "";
        for (int i = 0; i < max(la, lb); i++) {
            int ca = i < la ? a[la - 1 - i] - '0' : 0;
            int cb = i < lb ? b[lb - 1 - i] - '0' : 0;
            int res = ca + cb + add;
            ans = to_string(res % 2) + ans;
            add = res / 2;
        }
        if (add) {
            ans = "1" + ans;
        }
        return ans;
    }
};
