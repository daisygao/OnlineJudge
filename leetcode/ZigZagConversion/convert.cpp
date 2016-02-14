class Solution {
public:
    string convert(string s, int numRows) {
        if (numRows < 2) return s;
        vector<string> rows(numRows, "");
        int size = numRows * 2 - 2;
        for (int j = 0; j < s.size(); j++) {
            int row = j % size;
            if (row >= numRows) {
                row = size - row; 
            }
            rows[row] += s[j];
        }
        string ans = "";
        for (string r : rows) ans += r;
        return ans;
    }
};
