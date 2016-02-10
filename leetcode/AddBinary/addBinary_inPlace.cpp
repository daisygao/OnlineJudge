class Solution {
public:
    string addBinary(string a, string b) {
        int la = a.size(), lb = b.size(), ll = max(la, lb), ls = min(la, lb);
        int add = 0;
        string &ans = la > lb ? a : b, less = la > lb ? b : a;
        for (int i = 0; i < ll; i++) {
            if (!add && i >= ls) return ans;
            char &ca = ans[ll - 1 - i], cb = i < ls ? less[ls - 1 - i] : '0';
            int res = (ca - '0') + (cb - '0') + add;
            ca = '0' + (res % 2);
            add = res / 2;
        }
        if (add) {
            ans = "1" + ans;
        }
        return ans;
    }
};
