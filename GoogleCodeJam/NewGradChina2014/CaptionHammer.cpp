#include <cstdio>
#include <cmath>
#define PI 3.141592653
double min(double x,  double y) {return x - y < 1e-6 ? x : y;}
int main() {
	int n, v, d;
	double g = 9.8;
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		scanf("%d %d", &v, &d);
		double x = min(1.0, g * d / v / v);
		printf("Case #%d: %.7f\n", i, asin(x) * 180 / PI / 2);
	}
}
