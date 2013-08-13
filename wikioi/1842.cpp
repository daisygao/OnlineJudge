#include <cstdio>
int func(int n) {
	if (n >= 0) return 5;
    return func(n + 1) + func(n + 2) + 1;
}
int main() {
	int n;
    scanf("%d", &n);
    printf("%d", func(n));
    return 0;
}

