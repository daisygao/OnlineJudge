#include <iostream>
#include <set>
using namespace std;

int main() {
    int n, x;
    cin >> n;
    set<int> s;
    while (n-- > 0) {
        cin >> x;
        s.insert(x);
    }
    cout << s.size() << endl;
    for (set<int>::iterator it = s.begin(); it != s.end(); it++) {
        cout << (it == s.begin() ? "" : " ") << *it;
    }
	return 0;
}
