class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        int m = board.size(), n = board[0].size();
        int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1}, dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int k = max(0, i - 1); k <= min(m - 1, i + 1); k++) {
                    for (int l = max(0, j - 1); l <= min(n - 1, j + 1); l++) {
                        sum += (board[k][l] & 1);
                    }
                }
                if (sum == 3 || sum - board[i][j] == 3) board[i][j] |= 2;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }
};
