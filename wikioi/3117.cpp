#include <iostream>
#include <cstring>
using namespace std;
int main() {
    string a, b;
    cin >> a >> b;
    int alen = a.length(), blen = b.length(), len = alen + blen, ans[len], add = 0, p = 0;
    memset(ans, 0, sizeof(ans) / sizeof(char));
    for (int i = 0; i < alen; i++) {
        p = len - 1 - i;
        for (int j = 0; j < blen; j++) {
            int sum = (a[alen - 1 - i] - '0') * (b [blen - 1 - j] - '0') + ans[p] + add;
            ans[p] = sum % 10;
            add = sum / 10;
            p--;
        }
        if (add) {
            ans[p] = add;
            add = 0;
        }
    }
    p = 0;
    while (p < len - 1 && ans[p] == 0) p++;
    while (p < len) cout << ans[p++];
    return 0;
}
	