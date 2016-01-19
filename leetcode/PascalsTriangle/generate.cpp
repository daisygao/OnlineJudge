class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> ans;
        vector<int> row;
        for (int i = 0; i < numRows; i++) {
            row.insert(row.begin(), 1);
            for (int j = 1; j < i; j++) {
                row[j] = row[j] + row[j + 1];
            }
            ans.push_back(row);
        }
        return ans;
    }
};
