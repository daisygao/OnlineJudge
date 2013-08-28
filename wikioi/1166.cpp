/*
题目描述 Description
【问题描述】
帅帅经常跟同学玩一个矩阵取数游戏：对于一个给定的n*m 的矩阵，矩阵中的每个元素aij均
为非负整数。游戏规则如下：
1. 每次取数时须从每行各取走一个元素，共n个。m次后取完矩阵所有元素；
2. 每次取走的各个元素只能是该元素所在行的行首或行尾；
3. 每次取数都有一个得分值，为每行取数的得分之和，每行取数的得分= 被取走的元素值*2i，
其中i 表示第i 次取数（从1 开始编号）；
4. 游戏结束总得分为m次取数得分之和。
帅帅想请你帮忙写一个程序，对于任意矩阵，可以求出取数后的最大得分。
输入描述 Input Description
第1行为两个用空格隔开的整数n和m。
第2~n+1 行为n*m矩阵，其中每行有m个用单个空格隔开的非负整数。
输出描述 Output Description
输出 仅包含1 行，为一个整数，即输入矩阵取数后的最大得分。
Solutions:
a1...am
b1...bm
c1...cm
n1...nm
min{a1/am + b1/bm + ... + n1/nm}
m
(1, m)
m - 1
(1, m - 1) (2, m)
m - 1
(1, m - 2) (2, m - 1) (3, m)
==> each line independent
sols(i, j) maximum score from index i to j for each line
sols(i, j) = 2 * max(arr(i) + sols(i + 1, j), arr(j) + sols(i, j - 1));
*/

#include <vector>
#include <iostream>
#include <string>
using namespace std;
vector<int> vmax(vector<int> x, vector<int> y) {
    int xl = x.size(), yl = y.size();
    if (xl == yl) {
        for (int i = 0; i < xl; i++) {
            if (x[i] == y[i]) continue;
            return x[i] > y[i] ? x : y;
        }
    }
    return xl > yl ? x : y;
}
vector<int> vdouble(vector<int> x) {
    int carry = 0;
    for (int i = x.size() - 1; i >= 0; i--) {
        int res = x[i] * 2 + carry;
        x[i] = res % 10;
        carry = res / 10;
    }
    if (carry) x.insert(x.begin(), carry);
    return x;
}
vector<int> vadd(vector<int> x, vector<int> y) {
    int carry = 0, xi = x.size() - 1, yi = y.size() - 1;
    vector<int> ans;
    while (xi >= 0 || yi >= 0) {
        int sum = (xi >= 0 ? x[xi--] : 0) + (yi >= 0 ? y[yi--] : 0) + carry;
        ans.insert(ans.begin(), sum % 10);
        carry = sum / 10;
    }
    if (carry) ans.insert(ans.begin(), carry);
    return ans;
}
int main() {
    int n, m;
    cin >> n >> m;
    vector<int> matrix[n][m], sols[m][m], ans, vnull;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            string s;
            cin >> s;
            for (int k = 0; k < s.size(); k++) {
                matrix[i][j].push_back(s[k] - '0');
            }
        }
    }
    for (int i = 0; i < n; i++) {
        for (int len = 0; len < m; len++) {
            for (int s = 0; s < m - len; s++) {
                int e = s + len;
                sols[s][e] = vdouble(vmax(vadd(matrix[i][s], (s == e ? vnull : sols[s + 1][e])), vadd(matrix[i][e], (s == e ? vnull : sols[s][e - 1]))));
            }
        }
        ans = vadd(ans, sols[0][m - 1]);
    }
    for (int i = 0; i < ans.size(); i++) cout << ans[i];
    return 0;
}