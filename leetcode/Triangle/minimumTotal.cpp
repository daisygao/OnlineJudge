class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int n = triangle.size(), i = n - 2;
        while (i >= 0) {
            for (int j = 0; j < triangle[i].size(); j++) {
                triangle[i][j] += min(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
            i--;
        }
        return n ? triangle[0][0] : 0;
    }
};
