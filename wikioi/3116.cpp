/*
给出两个正整数A和B，计算A+B的值。保证A和B的位数不超过500位。
0 3
1 2
1 5 
*/
#include <iostream>
#include <string>
#include <sstream>
using namespace std;
int main() {
    string as, bs;
    cin >> as >> bs;
    int alen = as.length(), blen = bs.length();
    stringstream ss;
    int ap = alen - 1, bp = blen - 1, add = 0;
    while (ap >= 0 || bp >= 0) {
        int av = ap >= 0 ? as[ap--] - '0' : 0;
        int bv = bp >= 0 ? bs[bp--] - '0' : 0;
        int sum = (av + bv + add) % 10;
        add = (av + bv + add) / 10;
        ss << sum;
    }
    if (add) ss << add; 
    string ans = ss.str();
    for (int i = ans.length() - 1; i >= 0; i--) cout << ans[i];
    return 0;
}