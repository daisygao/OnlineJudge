/*
输入二个正整数x0,y0(2<=x0<100000,2<=y0<=1000000),求出满足下列条件的P,Q的个数
条件:  1.P,Q是正整数
2.要求P,Q以x0为最大公约数,以y0为最小公倍数.
试求:满足条件的所有可能的两个正整数的个数.
*/
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