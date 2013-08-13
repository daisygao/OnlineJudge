#include <cstdio>
int func(int n, int time) {\if (n == 1) return time;
    else if (n % 2) return func(3 * n + 1, time + 1);
    else return func(n / 2, time + 1);
}
int main() {
    int n;
    scanf("%d", &n);
    while (n-- > 0) {
        int x;
        scanf("%d", &x);
    	printf("%d\n", func(x, 0));
    }
    return 0;
}
