class Solution {
public:
    int titleToNumber(string s) {
        int num = 0;
        for (auto c : s) {
            num *= 'Z' - 'A' + 1;
            num += c - 'A' + 1;
        }
        return num;       
    }
};
