#include <cstdio>
int main() {
     int x, y;
    scanf("%d %d", &x, &y);
    while (y) {
        int t = x;
        x = y;
        y = t % y;
    }
    printf("%d", x);
    return 0;
}