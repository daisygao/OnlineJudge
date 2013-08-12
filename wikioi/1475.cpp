/*
m进制转十进制 
*/
#include <iostream>
#include <string>
using namespace std;
int main() {
    string s;
    int m, y = 1, sum = 0;
    cin >> s;
    cin >> m;
    for (int i = s.length() - 1; i >= 0; i--) {
        int x;
        if (s[i] >= 'a' && s[i] <= 'f') x = s[i] - 'a' + 10;
        else if (s[i] >= 'A' && s[i] <= 'F') x = s[i] - 'A' + 10;
        else x = s[i] - '0';
        sum += x * y;
        y *= m;
    }
    cout << sum;
    return 0;
}

