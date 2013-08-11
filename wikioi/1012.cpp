#include <cstdio>
int gcd(int x, int y) {
    while (y) {
         int t = x;
        x = y;
        y = t % y;
    }
    return x;
}
int main() {
    int x0, y0;
    scanf("%d %d", &x0, &y0);
    int prod = x0 * y0, ans = 0;
    for (int x = x0; x <= prod; x += x0) {
         if (prod % x) continue;
        int y = prod / x;
        if (gcd(x, y) == x0) ans++;
    }
    printf("%d", ans);
    return 0;
}