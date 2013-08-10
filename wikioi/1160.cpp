/*
小明玩一个数字游戏，取个n行n列数字矩阵（其中n为不超过100的奇数），数字的填补方法为：在矩阵中心从1开始以逆时针方向绕行，逐圈扩大，直到n行n列填满数字，请输出该n行n列正方形矩阵以及其的对角线数字之和.
输出描述
n+1行，n行为组成的矩阵，最后一行为对角线数字之和
*/

#include <cstdio>
int main() {
    int n;
    scanf("%d", &n);
    int matrix[n][n], num = n * n, layer = n, sum = 0;
    while (layer > 1) {
        int offset = (n - layer) / 2;
    	// right to left
        for (int i = n - offset - 1; i > offset; i--) matrix[n - offset - 1][i] = num--;
        // bot to top
        for (int i = n - offset - 1; i > offset; i--) matrix[i][offset] = num--;
        // left to right
        for (int i = offset; i < n - offset - 1; i++) matrix[offset][i] = num--;
        // top to bot
        for (int i = offset; i < n - offset - 1; i++) matrix[i][n - offset - 1] = num--;
        layer -= 2;
    }
    matrix[n / 2][n / 2] = num;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("%d%s", matrix[i][j], (j == n - 1 ? "\n" : " "));
            if (i - j == 0 || i + j == n - 1) sum += matrix[i][j];
        }
    }
    printf("%d", sum);
    return 0;
}