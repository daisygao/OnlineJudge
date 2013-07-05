public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int LEN = 9, rows[] = new int[LEN], cols[] = new int[LEN], cells[] = new int[LEN];
        for (int i = 0; i < LEN; i++) {
            for (int j = 0; j < LEN; j++) {
                if (board[i][j] != '.') {
                    int mark = 1 << (board[i][j] - '0');
                    int row = i, col = j, cell = (i / 3) * 3 + j / 3;
                    if ((rows[row] & mark) != 0 || (cols[col] & mark) != 0 || (cells[cell] & mark) != 0) return false;
                    rows[row] |= mark;
                    cols[col] |= mark;
                    cells[cell] |= mark;
                }
            }
        }
        return true;
    }
}