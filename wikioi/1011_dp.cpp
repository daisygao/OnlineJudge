/*
我们要求找出具有下列性质数的个数(包含输入的自然数n):
先输入一个自然数n(n<=1000),然后对此自然数按照如下方法进行处理:
1.          不作任何处理;
2.          在它的左边加上一个自然数,但该自然数不能超过原数的一半;
3.          加上数后,继续按此规则进行处理,直到不能再加自然数为止.
*/
#include <cstdio>
int main() {
int n;
    scanf("%d", &n);
    int ans[n / 2 + 1], sum = 1;
    for (int i = 1; i <= n / 2; i++) ans[i] = 1;
    for (int i = 1; i <= n / 2; i++) {
        for (int j = 1; j <= i / 2; j++) {
        	ans[i] += ans[j];
        }
        sum += ans[i];
    }
    printf("%d", sum);
    return 0;
}