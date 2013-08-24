/*
题目描述 Description
小明过生日的时候，爸爸送给他一副乌龟棋当作礼物。 乌龟棋的棋盘是一行N个格子，每个格子上一个分数（非负整数）。棋盘第1格是唯一 的起点，第N格是终点，游戏要求玩家控制一个乌龟棋子从起点出发走到终点。
…… 1 2 3 4 5 ……N 乌龟棋中M张爬行卡片，分成4种不同的类型（M张卡片中不一定包含所有4种类型 的卡片，见样例），每种类型的卡片上分别标有1、2、3、4四个数字之一，表示使用这种卡 片后，乌龟棋子将向前爬行相应的格子数。游戏中，玩家每次需要从所有的爬行卡片中选择 一张之前没有使用过的爬行卡片，控制乌龟棋子前进相应的格子数，每张卡片只能使用一次。 游戏中，乌龟棋子自动获得起点格子的分数，并且在后续的爬行中每到达一个格子，就得到 该格子相应的分数。玩家最终游戏得分就是乌龟棋子从起点到终点过程中到过的所有格子的 分数总和。 很明显，用不同的爬行卡片使用顺序会使得最终游戏的得分不同，小明想要找到一种卡 片使用顺序使得最终游戏得分最多。 现在，告诉你棋盘上每个格子的分数和所有的爬行卡片，你能告诉小明，他最多能得到 多少分吗？

输入描述 Input Description
输入的每行中两个数之间用一个空格隔开。 第1行2个正整数N和M，分别表示棋盘格子数和爬行卡片数。 第2行N个非负整数，a1a2……aN
，其中ai表示棋盘第i个格子上的分数。 第3行M个整数，b1b2……bM
，表示M张爬行卡片上的数字。 输入数据保证到达终点时刚好用光M张爬行卡片，即N - 1=∑(1->M) bi

输出描述 Output Description
输出一行一个整数
S
olution:
sols[i, j, k, l] = max(sols[i - 1, j, k, l], sols...) + score[i + j * 2 + k * 3 + l * 4]

Test:
card 6 1 0 1
4
59
14

*/
#include <cstdio>
#include <cstring>
int max(int i, int j) {return i > j ? i : j;}
int max4(int i, int j, int k, int l) {
    return max(max(i, j), max(k, l));
}
int main() {
    int n, m;
    scanf("%d %d", &n, &m);
    int score[n], card[4];
    for (int i = 0; i < n; i++) scanf("%d", &score[i]);
    memset(card, 0, sizeof(card) / sizeof(char));
    for (int i = 0; i < m; i++) {
        int x;
        scanf("%d", &x);
        card[x - 1]++;
    }
    int sols[card[0] + 1][card[1] + 1][card[2] + 1][card[3] + 1];
    memset(sols, 0, sizeof(sols) / sizeof(char));
    for (int i = 0; i <= card[0]; i++) {
        for (int j = 0; j <= card[1]; j++) {
            for (int k = 0; k <= card[2]; k++) {
                for (int l = 0; l <=card[3]; l++) {
                    sols[i][j][k][l] = max4(i == 0 ? 0 : sols[i - 1][j][k][l],
                                            j == 0 ? 0 : sols[i][j - 1][k][l], 
                                            k == 0 ? 0 : sols[i][j][k - 1][l],
                                            l == 0 ? 0 : sols[i][j][k][l - 1]) + 
                        score[i + j * 2 + k * 3 + l * 4];
                }
            }
        }
    }
    printf("%d", sols[card[0]][card[1]][card[2]][card[3]]);
    return 0;
}
