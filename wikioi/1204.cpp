#include <iostream>
#include <string>
using namespace std;
int main() {
    string s1, s2;
    cin >> s1 >> s2;
    int i, j;
    for (i = 0; i < s1.length(); i++) {
        for (j = 0; j < s2.length(); j++) {
            if (s1[i + j] != s2[j]) break;
        }
        if (j == s2.length()) cout << i + 1;
    }
    return 0;
}
	