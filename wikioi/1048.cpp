/*
题目描述 Description
有n堆石子排成一列，每堆石子有一个重量w[i], 每次合并可以合并相邻的两堆石子，一次合并的代价为两堆石子的重量和w[i]+w[i+1]。问安排怎样的合并顺序，能够使得总合并代价达到最小。
输入描述 Input Description
第一行一个整数n（n<=100）
第二行n个整数w1,w2...wn  (wi <= 100)
输出描述 Output Description
一个整数表示最小合并代价

Solutions:
sols[i][j] min cost from idx i to j
sols[i][j] = min(k: sols[i][k] + sols[k + 1][j]) + costs[i][j]
costs[i][j] = costs[i][j - 1] + costs[j][j]
Test:
4
4 1 1 4
costs
4 5 6 10
  1 2 6
    1 5
      4
sols
0 5 8 18
  0 2 8
    0 5
*/
#include <cstdio>
#include <cstring>
#include <climits>
int min(int x, int y) {return x < y ? x : y;}
int main() {
    int n;
    scanf("%d", &n);
    int costs[n][n], sols[n][n], size = sizeof(costs) / sizeof(char);
    memset(costs, 0, size);
    memset(sols, 0, size);
    for (int i = 0; i < n; i++) scanf("%d", &costs[i][i]);
    for (int len = 1; len < n; len++) {
        for (int i = 0; i < n - len; i++) {
            int j = i + len;
            costs[i][j] = costs[i][j - 1] + costs[j][j];
            sols[i][j] = INT_MAX;
            for (int k = i; k < j; k++) {
                sols[i][j] = min(sols[i][k] + sols[k + 1][j] + costs[i][j], sols[i][j]);
            }
        }
    }
    printf("%d", sols[0][n - 1]);
    return 0;
}