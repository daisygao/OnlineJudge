public class Solution {
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int height = board.length, len = word.length();
        if (height == 0) return len == 0;
        int width = board[0].length;
        boolean visited[][] = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (helper(board, i, j, height, width, word, visited)) return true;
            }
        }
        return false;
    }
    private boolean helper(char[][] board, int x, int y, int height, int width, String word, boolean[][] visited) {
        int len = word.length(), dx[] = {0, -1, 0, 1}, dy[] = {-1, 0, 1, 0};
        if (len == 0) return true;
        if (board[x][y] != word.charAt(0) || visited[x][y]) return false;
        if (len == 1) return true;
        visited[x][y] = true;
        for (int i = 0; i < dx.length; i++) {
            int xx = x + dx[i], yy = y + dy[i];
            if (xx >= 0 && yy >= 0 && xx < height && yy < width && helper(board, xx, yy, height, width, word.substring(1), visited)) return true;
        }
        visited[x][y] = false;
        return false;
    }
}