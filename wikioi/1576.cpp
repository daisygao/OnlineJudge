
/*
题目描述 Description
非常经典的问题，拿来给大家练手了。 
序列 { 1,2,...,n } 的一个子序列是指序列 { i1, i2, ……, ik },其中 1<=i1 < i2 < …… < ik<=n, 序列 { a1, a2, ……, an } 的一个子序列是指序列 { ai1, ai2, ……, aik },其中 { i1, i2, ……, ik } 是 { 1, 2, ……, n } 的一个子序列.同时,称 k 为此子序列的长度. 
如果 { ai1, ai2, ……, aik } 满足 ai1 ≤ ai2 ≤ …… ≤ aik,则称之为上升子序列.如果不等号都是严格成立的,则称之为严格上升子序列.同理,如果前面不等关系全部取相反方向,则称之为下降子序列和严格下降子序列. 
长度最长的上升子序列称为最长上升子序列.本问题对于给定的整数序列,请求出其最长严格上升子序列的长度
输入描述 Input Description
第一行，一个整数N。
第二行 ，N个整数（N < = 5000）
输出描述 Output Description
输出K的极大值，即最长严格上升子序列的长度

Solution:
sols[n] maximum length of increasing seq until index n
Test:
2 3 4 1 4 5 20 49 2 4 52 1 2 4
*/
#include <cstdio>
#include <cstring>
int max(int x, int y) {return x > y ? x : y;}
int main() {
    int n;
    scanf("%d", &n);
    int arr[n], sols[n], ans = 0;
    memset(sols, 0, sizeof(sols) / sizeof(char));
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
        for (int j = i - 1; j >= 0; j--) {
            if (arr[j] > arr[i]) break;
            sols[i] = max(sols[i], sols[j]);
        }
        sols[i] += 1;
        ans = max(sols[i], ans);
    }
    printf("%d", ans);
    return 0;
}
