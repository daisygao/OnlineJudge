public class Solution {
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (word.length() == 0) return true;
        if (board.length == 0) return false;
        boolean mark[][] = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    mark[i][j] = true;
                    if (helper(board, i, j, word.substring(1), mark)) return true;
                    mark[i][j] = false;
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board, int x, int y, String word, boolean[][] mark) {
        if (word.length() == 0) return true;
        int dx[] = {0, -1, 0, 1}, dy[] = {-1, 0, 1, 0};
        for (int i = 0; i < dx.length; i++) {
            int xx = x + dx[i], yy = y + dy[i];
            if (xx >= 0 && yy >= 0 && xx < board.length && yy < board[0].length &&
            board[xx][yy] == word.charAt(0) && !mark[xx][yy]) {
                mark[xx][yy] = true;
                if (helper(board, xx, yy, word.substring(1), mark)) return true;
                mark[xx][yy] = false;
            }
        }
        return false;
    }
}