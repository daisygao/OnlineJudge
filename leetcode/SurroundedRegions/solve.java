public class Solution {
    private class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int height = board.length;
        if (height == 0) return;
        int width = board[0].length;
        ArrayList<Point> queue = new ArrayList<Point>(height * width);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i == 0 || j == 0 || i == height -1 || j == width - 1) 
                && board[i][j] == 'O') {
                    board[i][j] = 'D';
                    queue.add(new Point(i, j));
                }
            }
        }
        int idx = 0, dx[] = {0, -1, 0, 1}, dy[] = {-1, 0, 1, 0};
        while (idx < queue.size()) {
            int x = queue.get(idx).x, y = queue.get(idx).y;
            for (int i = 0; i < dx.length; i++) {
                int xx = x + dx[i], yy = y + dy[i];
                if (xx >= 0 && yy >= 0 && xx < height && yy < width && board[xx][yy] == 'O') {
                    board[xx][yy] = 'D';
                    queue.add(new Point(xx, yy));
                }
            }
            idx++;
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = board[i][j] == 'D' ? 'O' : 'X';
            }
        }
    }
}