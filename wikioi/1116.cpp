/*
题目描述 Description
给定N（小于等于8）个点的地图，以及地图上各点的相邻关系，请输出用4种颜色将地图涂色的所有方案数（要求相邻两点不能涂成相同的颜色）
数据中0代表不相邻，1代表相邻
输入描述 Input Description
第一行一个整数n，代表地图上有n个点
接下来n行，每行n个整数，每个整数是0或者1。第i行第j列的值代表了第i个点和第j个点之间是相邻的还是不相邻，相邻就是1，不相邻就是0.
我们保证a[i][j] = a[j][i] （a[i,j] = a[j,i]）
输出描述 Output Description
染色的方案数
*/
#include <cstdio>
#include <vector>
int sols(std::vector<std::vector<int> > matrix, int idx, int n, int color[]) {
    int ans = 0;
    for (int i = 1; i < 5; i++) {
        int j;
        for (j = 0; j < n; j++) {
            if (matrix[idx][j] == 1 && color[j] == i) break;
        }
        if (j == n) {
            color[idx] = i;
            if (idx == n - 1) ans += 1;
            else ans += sols(matrix, idx + 1, n, color);
            color[idx] = 0;
        }
    }
    return ans;
}

int main() {
    int n;
    scanf("%d", &n);
    std::vector<std::vector<int> > matrix(n, std::vector<int>(n));
    int color[n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%d", &matrix[i][j]);
        }
        color[i] = 0;
    }
    printf("%d", sols(matrix, 0, n, color));
    return 0;
}