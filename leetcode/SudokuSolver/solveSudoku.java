public class Solution {
    public void solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int rows[] = new int[9], cols[] = new int[9], cells[] = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int mark = 1 << (board[i][j] - '0');
                    rows[i] |= mark;
                    cols[j] |= mark;
                    cells[(i / 3) * 3 + j / 3] |= mark;
                }
            }
        }
        solvable(board, 0, rows, cols, cells);
    }
   
    private boolean solvable(char[][] board, int idx, int[] rows, int[] cols, int[] cells) {
        if (idx == 81) return true;
        int row = idx / 9, col = idx % 9, cell = (row / 3) * 3 + col / 3;
        if (board[row][col] != '.') return solvable(board, idx + 1, rows, cols, cells);
        for (char c = '1'; c <= '9'; c++) {
            int mark = 1 << (c - '0');
            if ((rows[row] & mark) == 0 && (cols[col] & mark) == 0 && (cells[cell] & mark) == 0) {
                rows[row] |= mark;
                cols[col] |= mark;
                cells[cell] |= mark;
                board[row][col] = c;
                if (solvable(board, idx + 1, rows, cols, cells)) return true;
                rows[row] &= ~mark;
                cols[col] &= ~mark;
                cells[cell] &= ~mark;
                board[row][col] = '.';
            }
        }
        return false;
    }
}
