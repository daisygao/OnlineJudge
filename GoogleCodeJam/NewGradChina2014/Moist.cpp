#include <iostream>
#include <string>
#include <cctype>
using namespace std;
int isAhead(string x, string y) {
	for (int i = 0; i < x.length() && i < y.length(); i++) {
		if (x[i] == y[i]) continue;
		if ((islower(x[i]) && islower(y[i])) || (isupper(x[i]) && isupper(y[i]))) return y[i] - x[i];
		else return isupper(x[i]) ? 1 : -1;
	}
	return x.length() == y.length() ? 0 : (x.length() < y.length() ? 1 : -1);
}
int main() {
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		int m, prev = -1, cur = 0, ans = 0;
		string prevName, curName;
		cin >> m;
		cin.ignore();
		while (m-- > 0 && getline(cin, curName)) {
			if (prev != -1 && isAhead(curName, prevName) > 0) {
				ans++;
			} else {
				prev = cur;
				prevName = curName;
			}
			cur++;
		}
		printf("Case #%d: %d\n", i, ans);
	}
}
