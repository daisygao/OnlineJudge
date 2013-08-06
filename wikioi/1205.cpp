#include <iostream>
#include <string>
using namespace std;
int main() {
    string s;
    getline(cin, s);
    int len = s.length(), i, j, next;
    for (i = 0; i < len / 2; i++) {
        char tmp = s[i];
        s[i] = s[len - 1 - i];
        s[len - 1 - i] = tmp;
    }
    i = j = next = 0;
    while (j < len) {
        while (j < len && s[j] != ' ') j++;
        next = j + 1;
        while (i < j) {
            char tmp = s[i];
            s[i++] = s[--j];
            s[j] = tmp;
        }
        i = j = next;
    }
    cout << s;
    return 0;
}
