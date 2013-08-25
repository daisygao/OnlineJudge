/*
http://wikioi.com/problem/1154/
Solutions:
sols[i][j] maximum value from idx i to j
sols[i][j] = max(k: sols[i][k] + sols[k + 1][j] + i.start * k.end * j.end)
max(sols[0][3], sols[1][4], sols[2][5], sols[3][6])
Test:
4
5 4 3 8 5
*/
#include <cstdio>
#include <cstring>
int max(int x, int y) {return x > y ? x : y;}
int main() {
    int n;
    scanf("%d", &n);
    int arr[n];
    for (int i = 0; i < n; i++) scanf("%d", &arr[i]);
    int sols[n][n], ans = 0;
    memset(sols, 0, sizeof(sols) / sizeof(char));
    for (int len = 1; len < n; len++) {
        for (int i = 0; i < n; i++) {
            int j = i + len;
            for (int k = i; k < j; k++) {
                sols[i][j % n] = max(sols[i][j % n], arr[i] * arr[(k + 1) % n] * arr[(j + 1) % n] + sols[i][k % n] + sols[(k + 1) % n][j % n]);
            }
            //printf("i:%d j:%d sols:%d\n", i, j, sols[i][j % n]);
            if (len == n - 1) ans = max(ans, sols[i][j % n]);
        }
    }
    printf("%d", ans);
    return 0;
}
   