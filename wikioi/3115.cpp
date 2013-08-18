#include <iostream>
#include <string>
#include <sstream>
using namespace std;

int main() {
    string a, b;
    cin >> a >> b;
    int ap = a.length() - 1, bp = b.length() - 1, borrow = 0;
    stringstream ss;
    while (ap >= 0 || bp >= 0) {
        int av = ap >= 0 ? a[ap--] - '0' : 0;
        int bv = bp >= 0 ? b[bp--] - '0' : 0;
        int ret = av - bv - borrow;
        if (ret < 0) {
            ret += 10;
            borrow = 1;
        } else borrow = 0;
        ss << ret;
    }
    string ans = ss.str();
    if (borrow) {
        for (int i = 0; i < ans.length(); i++) {
            int v = ans[i] - '0';
            ans[i] = '0' + ((i == 0 ? 10 : 9) - v);
        }
    }
    int p = ans.length() - 1;
    while (p > 0 && ans[p] == '0') p--;
    if (borrow && ans[p] != '0') cout << '-';
    while (p >= 0) cout << ans[p--];
    return 0;
}