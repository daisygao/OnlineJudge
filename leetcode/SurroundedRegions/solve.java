
public class Solution {
    private class Point {
        public int x;
        public int y;
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
        ArrayList<Point> seeds = new ArrayList<Point>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || j == 0 || i == height - 1 || j == width - 1) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'D';
                        seeds.add(new Point(i, j));                        
                    }
                }
            }
        }
        int dx[] = {0, -1, 0, 1}, dy[] ={-1, 0, 1, 0};
        while (!seeds.isEmpty()) {
            Point p = seeds.remove(0);
            for (int k = 0; k < 4; k++) {
                int x = p.x + dx[k], y = p.y + dy[k];
                if (x >= 0 && y >= 0 && x < height && y < width && board[x][y] == 'O') {
                    board[x][y] = 'D';
                    seeds.add(new Point(x, y));
                }
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                char c = board[i][j];
                if (c != 'X') board[i][j] = c == 'O' ? 'X' : 'O';
            }
        }
    }
}
