public class Solution {
    
    int LEN = 9;
    int TOTAL = LEN * LEN;
    
    public void solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int rows[] = new int[LEN];
        int cols[] = new int[LEN];
        int squares[] = new int[LEN];
        for (int i = 0; i < TOTAL; i++) {
            int x = i / LEN, y = i % LEN, sqrIdx = (x / 3) * 3 + y / 3, mask = 1 << (board[x][y] - '0');
            rows[x] |= mask;
            cols[y] |= mask;
            squares[sqrIdx] |= mask;
        }
        helper(board, 0, rows, cols, squares);
    }
    
    private boolean helper(char[][] board, int nth, int[] rows, int[] cols, int[] squares) {
        int x = nth / LEN, y = nth % LEN, sqrIdx = (x / 3) * 3 + y / 3;
        if (nth >= TOTAL ||(nth == TOTAL - 1 && board[x][y] != '.')) return true;
        else if (board[x][y] != '.') return helper(board, nth + 1, rows, cols, squares);
        else {
            for (int num = 1; num <= LEN; num++) {
                int mask = 1 << num;
                if ((rows[x] & mask) == 0 && (cols[y] & mask) == 0 && (squares[sqrIdx] & mask) == 0) {
                    board[x][y] = (char)('0' + num);
                    rows[x] |= mask;
                    cols[y] |= mask;
                    squares[sqrIdx] |= mask;
                    if ((x == y && x == LEN - 1) || helper(board, nth + 1, rows, cols, squares)) return true;
                    board[x][y] = '.';
                    rows[x] &= ~mask;
                    cols[y] &= ~mask;
                    squares[sqrIdx] &= ~mask;
                }
            }
            return false;
        }
    }
}