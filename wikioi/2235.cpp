#include <stdio.h>
int main() {
	int x;
	double rate;
	scanf("%d %lf", &x, &rate);
	printf("%d", int((x / 10.0 * rate + 5) / 10) * 10);
	return 0;
}
