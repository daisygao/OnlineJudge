class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int n = digits.size();
        if (!n) return digits;
        int add = 1;
        for (int i = n - 1; i >= 0; i--) {
            int x = digits[i] + add;
            digits[i] = x % 10;
            add = x / 10;
            if (!add) return digits;
        }
        digits.insert(digits.begin(), 1);
        return digits;
    }
};
