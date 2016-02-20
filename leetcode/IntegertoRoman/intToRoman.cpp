class Solution {
public:
    string intToRoman(int num) {
        int numbers[] = {1, 5, 10, 50, 100, 500, 1000};
        string romans[] = {"I", "V", "X", "L", "C", "D", "M"};
        int size = sizeof(numbers) / sizeof(int);
        string ans;
        
        for (int i = size - 1; i >= 0; i -= 2) {
            if (num < numbers[i]) continue;
            int ret = num / numbers[i];
            num -= ret * numbers[i];
            if (ret % 5 == 4) {
                ans += romans[i];
                ans += romans[i + (ret + 1) / 5];
                ret = 0;
            } else if (ret >= 5) {
                ans += romans[i + 1];
                ret -= 5;
            }
            while (ret > 0) {
                ans += romans[i];
                ret--;
            }
        }
        return ans;
    }
};
