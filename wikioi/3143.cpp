#include <cstdio>
void preorder(int tree[][2], int root) {
    printf("%d%s", root, " ");
    if (tree[root][0] != 0) preorder(tree, tree[root][0]);
    if (tree[root][1] != 0) preorder(tree, tree[root][1]);
}
void inorder(int tree[][2], int root) {
    if (tree[root][0] != 0) inorder(tree, tree[root][0]);
    printf("%d%s", root, " ");
    if (tree[root][1] != 0) inorder(tree, tree[root][1]);
}
void postorder(int tree[][2], int root) {
    if (tree[root][0] != 0) postorder(tree, tree[root][0]);
    if (tree[root][1] != 0) postorder(tree, tree[root][1]);
    printf("%d%s", root, " ");
}
int main() {
    int n;
    scanf("%d", &n);
    int tree[n + 1][2], idx = 0;
    while (++idx <= n) {
        scanf("%d %d", &tree[idx][0], &tree[idx][1]);
    }
    preorder(tree, 1);
    printf("\n");
    inorder(tree, 1);
    printf("\n");
    postorder(tree, 1);
    return 0;
}
