#include <iostream>
#include <sstream>
using namespace std;
long long str2long(string s) {
    long long x;
    stringstream ss;
    ss << s;
    ss >> x;
    return x;
}
long long max(long long x, long long y) {return x > y ? x : y;}
int main() {
    int n, k;
    cin >> n >> k;
    string num;
    cin >> num;
    long long sols[n], val[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            val[i][j] = str2long(num.substr(i, j - i + 1));
        }
        sols[i] = val[i][n - 1];
    }
    for (int cut = 1; cut <= k; cut++) {
        for (int i = 0; i < n - cut; i++) {
            long long ans = 0;
            for (int j = i; j < n - cut; j++) {
                ans = max(ans, val[i][j] * sols[j + 1]);
            }
            sols[i] = ans;
            if (i == 0 && cut == k) break;
        }
    }            
    cout << sols[0];
    return 0;
}
	