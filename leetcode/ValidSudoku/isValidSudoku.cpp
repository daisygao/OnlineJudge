class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        unordered_set<char> row[9], col[9], rect[9];
        if (board.size() != 9) return false;
        for (int i = 0; i < board.size(); i++) {
            if (board[i].size() != 9) return false;
            for (int j = 0; j < board[i].size(); j++) {
                char c = board[i][j];
                if (c == '.') continue;
                if (c - '0' <= 0 || c - '0' > 9) return false;
                if (row[i].find(c) != row[i].end()) return false;
                row[i].insert(c);
                if (col[j].find(c) != col[j].end()) return false;
                col[j].insert(c);
                int ri = (j / 3) + (i / 3) * 3;
                if (rect[ri].find(c) != rect[ri].end()) return false;
                rect[ri].insert(c);
            }
        }
        return true;
    }
};
