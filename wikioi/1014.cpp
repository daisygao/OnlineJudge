/*
有一个箱子容量为V（正整数，0＜＝V＜＝20000），同时有n个物品（0＜n＜＝30），每个物品有一个体积（正整数）。
要求n个物品中，任取若干个装入箱内，使箱子的剩余空间为最小。
输入描述 Input Description
一个整数v，表示箱子容量
一个整数n，表示有n个物品
接下来n个整数，分别表示这n 个物品的各自体积
输出描述 Output Description
一个整数，表示箱子剩余空间。
*/
#include <cstdio>
int min(int x, int y) {return x < y ? x : y;}
int main() {
    int n, m;
    scanf("%d %d", &n, &m);
    int V[m], sols[n + 1];
    for (int i = 0; i < m; i++) {
        scanf("%d", &V[i]);
        for (int j = n; j >= 0; j--) {
            if (i == 0) sols[j] = j >= V[i] ? j - V[i] : j;
            else sols[j] = j >= V[i] ? min(sols[j - V[i]], sols[j]) : sols[j];
        }
    }
    printf("%d", sols[n]);
    return 0;
}

	