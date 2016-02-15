class Solution {
public:
    int myAtoi(string str) {
        int ans = 0, sign = 1, i = 0;
        while (i < str.size() && str[i] == ' ') i++;
        if (i < str.size()) {
            // sign
            if (str[i] == '+' || str[i] == '-') {
                sign = str[i++] == '-' ? -1 : 1;
            }
            while (i < str.size() && isdigit(str[i])) {
                int cur = (str[i] - '0');
                if (ans > INT_MAX / 10 || ans == INT_MAX / 10 && cur > INT_MAX % 10) return sign > 0 ? INT_MAX : INT_MIN;
                ans = ans * 10 + cur;
                i++;
            }
            return ans * sign;
        }
    }
};
