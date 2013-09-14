#include <iostream>
#include <string>
#include <map>
#include <vector>
#include <set>
using namespace std;
int main() {
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		int m;
		string x, y;
		bool ans = true;
		map<string, vector<string> > map;
		scanf("%d\n", &m);
		while (m-- > 0) {
			cin >> x >> y;
			if (map.find(x) == map.end()) {
				map[x] = vector<string>();
			}
			if (map.find(y) == map.end()) {
				map[y] = vector<string>();
			}
			map[x].push_back(y);
			map[y].push_back(x);
		}
		set<string> set1, set2;
		set1.insert(x);
		set2.insert(y);
		vector<string> seq1, seq2;
		seq1.push_back(x);
		seq2.push_back(y);
		int i1 = 0, i2 = 0;
		while (i1 < seq1.size() || i2 < seq2.size()) {
			vector<string> vec;
			if (i1 < seq1.size()) {
				vec = map[seq1[i1]];
				for (vector<string>::iterator it = vec.begin(); it != vec.end(); it++) {
					if (set1.find(*it) != set1.end()) {
						ans = false;
						break;
					} else if (set2.find(*it) == set2.end()) {
							set2.insert(*it);
							seq2.push_back(*it);						
					}
				}
				i1++;
			}
			if (i2 < seq2.size()) {
				vec = map[seq2[i2]];
				for (vector<string>::iterator it = vec.begin(); it != vec.end(); it++) {
					if (set2.find(*it) != set2.end()) {
						ans = false;
						break;
					} else if (set1.find(*it) == set1.end()) {
						seq1.push_back(*it);
						set1.insert(*it);
					}
				}
				i2++;
			}
		}
		
		printf("Case #%d: %s\n", i, ans ? "Yes" : "No");
	}
	return 0;
}
