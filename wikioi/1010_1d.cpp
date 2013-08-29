#include <cstdio>
int main() {
    int n, m, x, y;
    scanf("%d %d %d %d", &n, &m, &x, &y);
    int sols[m + 1], dx[] = {0, -1, -2, -2, -1, 1, 2, 2, 1}, dy[] = {0, -2, -1, 1, 2, 2, 1, -1, -2}, step = sizeof(dx) / sizeof(int);
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= m; j++) {
            bool inRange = false;
            for (int k = 0; k < step; k++) {
                if (i == x + dx[k] && j == y + dy[k]) {
                    inRange = true;
                    sols[j] = 0;
                    break;
                }
            }
            if (!inRange) {
                if (i == 0 && j == 0) sols[j] = 1;
                else sols[j] = (i == 0 ? 0 : sols[j]) + (j == 0 ? 0 : sols[j - 1]);
            }
        }
    }
    printf("%d", sols[m]);
    return 0;
}