#include <iostream>
#include <string>
#include <vector>
#include <map>
using namespace std;
struct Node {
	string val;
	vector<int> neighbors;
	int depth;
	int color;
	Node(string v): depth(0), color(-1) {
		val = v;
	}
};
int dfs(int idx, vector<Node> &nodes) {
	Node &root = nodes[idx];
	if (root.color == 0) return 0;
	root.color = 1;
	//printf("entering root %s color is %d size %d\n", root.val.c_str(), root.color, root.neighbors.size());
	for (int i = 0; i < root.neighbors.size(); i++) {
		int vi = root.neighbors[i];
		Node &v = nodes[vi];
		//printf("%s neighbor i %d is %s color is %d\n", root.val.c_str(), i, v.val.c_str(), v.color);
		if (v.color == 1) {
			// circle
			if ((root.depth + 1 - v.depth) % 2) return -1;
		} else if (v.color == -1) {
			v.depth = root.depth + 1;
			if (dfs(vi, nodes) < 0) return -1;
		}
	}
	root.color = 0;
	return 0;
}
int main() {
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		int m;
		string x, y;
		map<string, int> map;
		vector<Node> nodes;
		int nidx = 0, xi = 0, yi;
		bool ans = true;
		scanf("%d\n", &m);
		while (m-- > 0) {
			cin >> x >> y;
			if (map.find(x) == map.end()) {
				nodes.push_back(Node(x));
				map[x] = nidx++;
			}
			if (map.find(y) == map.end()) {
				nodes.push_back(Node(y));
				map[y] = nidx++;
			}
			xi = map[x];
			yi = map[y];
			nodes[xi].neighbors.push_back(yi);
			nodes[yi].neighbors.push_back(xi);
			//printf("xi %d yi %d, x %s y %s\n", xi, yi, nodes[xi].val.c_str(), nodes[yi].val.c_str());
		}
		// dfs
		nidx = 0;
		while (nidx != nodes.size()) {
			//printf("node %d is %s color is %d\n", nidx, nodes[nidx].val.c_str(), nodes[nidx].color);
			if (dfs(nidx, nodes) < 0) {
				ans = false;
				break;
			}
			nidx++;
		}
		printf("Case #%d: %s\n", i, ans ? "Yes" : "No");
	}
	return 0;
}
