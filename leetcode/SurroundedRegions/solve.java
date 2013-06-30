public class Solution {
    private class Point {
        public int x, y;
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
        int dx[] = {0, -1, 0, 1}, dy[] = {-1, 0, 1, 0};
        ArrayList<Point> list = new ArrayList<Point>(100000);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 'O' && (i == 0 || j == 0 || i == height - 1 || j == width - 1)) {
                    board[i][j] = 'D';
                    list.add(new Point(i, j));
                }
            }
        }
        int idx = 0;
        while (idx < list.size()) {
            Point cur = list.get(idx);
            for (int i = 0; i < dx.length; i++) {
                int xx = cur.x + dx[i], yy = cur.y + dy[i];
                if (xx >= 0 && yy >= 0 && xx < height && yy < width && board[xx][yy] == 'O') {
                    board[xx][yy] = 'D';
                    list.add(new Point(xx, yy));
                }
            }
            idx++;
        }
    
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = (board[i][j] == 'D' ? 'O' : 'X');
            }
        }
    }
}