#include <cstdio>
#include <vector>
int h, w;
std::vector<int> width;
void dfs(int tree[][2], int idx, int height) {
    if (h < height) h = height;
    if (height > width.size()) width.push_back(0);
    width[height - 1]++;
    if (w < width[height - 1]) w = width[height - 1];
    if (tree[idx][0] != 0) dfs(tree, tree[idx][0], height + 1);
    if (tree[idx][1] != 0) dfs(tree, tree[idx][1], height + 1);
}
int main() {
    int n, idx = 0;
    scanf("%d", &n);
    int tree[n + 1][2];
    while (++idx <= n) {
        scanf("%d %d", &tree[idx][0], &tree[idx][1]);
    }
    dfs(tree, 1, 1);
    printf("%d %d", w, h);
    return 0;    
}
