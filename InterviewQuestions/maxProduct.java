/*
一个正整数N，拆分成若干个数之和，这若干个数的乘积最大，怎么拆。
Solutions:
sols[n] max product by splitting n
sols[n] = k: k * Math.max(n - k, sols[n - k])
*/
public int maxProduct(int N) {
	int sols[] = new int[N + 1];
	for (int i = 1; i <= N; i++) {
		if (i == 1) sols[i] = 1;
		for (int j = i - 1; j >= 1; j--) {
			sols[i] = Math.max(sols[i], j * Math.max(i - j, sols[i - j]));
		}
	}
	return sols[N];
}