/*
素数判定 
*/
#include <cstdio>
int main() {
    int n;
    scanf("%d", &n);
    bool isPrime = n < 2 ? false : true;
    for (int x = 2; x * x <= n; x++) {
        if (n % x == 0) {
            isPrime = false;
            break;
        }
    }
    printf("%s", isPrime ? "\\t" : "\\n");
    return 0;
}

