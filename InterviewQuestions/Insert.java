public char getInsertPos(char objs[], char x) {
	int l = 0, r = objs.length - 1, m;
	while (l <= r) {
		m = l + (r - l >> 1);
		if (objs[m] <= x) l = m + 1;
		else r = m - 1;
	}
	return objs[l % objs.length];
}