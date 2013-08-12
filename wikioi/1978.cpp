/*
Fibonacci
*/
#include <cstdio>
int main() {
int n;
    scanf("%d", &n);
    int x = 1, y = 1, i = 3;
    while (i++ <= n) {
    int t = x + y;
        y = x;
        x = t;
    }
    printf("%d", x);
    return 0;
}
