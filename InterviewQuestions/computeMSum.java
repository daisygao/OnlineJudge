/*
输入两个整数n 和m，从数列1，2，3.......n 中随意取几个数,
使其和等于m ,要求将其中所有的可能组合列出来.
*/


public ArrayList<ArrayList<Integer>> computeMSum(int n, int m) {
	return helper(1, n, m);
}

private ArrayList<ArrayList<Integer>> helper(int start, int end, int sum) {
	ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
	for (int i = start; i <= end; i++) {
		if (i > sum) break;
		if (i == sum) {
			ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(i);
			ans.add(list);
			break;
		}
		for (ArrayList<Integer> list : helper(i + 1, end, sum - i)) {
			list.add(0, i);
			ans.add(list);
		}
	}
	return ans;
}