class Solution {
public:
    string helper(string str) {
        string ans = "";
        int cnt = 0, idx = 0, size = str.size();
        while (idx < size) {
            while (idx + 1 < size && str[idx + 1] == str[idx]) {
                cnt++;
                idx++;
            }
            ans += to_string(cnt + 1) + str[idx];
            cnt = 0;
            idx++;
        }
        return ans;
    }
    string countAndSay(int n) {
        string str = "1";
        while (--n > 0) str = helper(str);
        return str;
    }
};
