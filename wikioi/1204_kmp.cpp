#include<iostream>
#include<string>
using namespace std;
void calcPos(string pat, int* arr) {
    int match = 0, idx = 1, len = pat.length();
    arr[0] = 0;
    while (idx != len) {        
        if (pat[match] == pat[idx]) {
            arr[idx++] = ++match;
        } else if (match == 0) {
            arr[idx++] = 0;
        } else {
            match = arr[match - 1];
        }        
    }
}
int main() {
    string s, pat;
    cin >> s >> pat;
    int slen = s.length(), plen = pat.length(), *pos = new int[plen], sidx = 0, pidx = 0;
    calcPos(pat, pos);
    while (sidx < slen) {
        if (s[sidx] == pat[pidx]) {
            sidx++;
            pidx++;
        } else if (pidx == 0) {
            sidx++;
        } else {
            pidx = pos[pidx - 1];
        }
        if (pidx == plen) cout << sidx - plen + 1;
    }
    delete [] pos;
    return 0;
}