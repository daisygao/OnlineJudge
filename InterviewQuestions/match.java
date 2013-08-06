/*
n 支队伍比赛，分别编号为0，1，2。。。。n-1，已知它们之间的实力对比关系，
存储在一个二维数组w[n][n]中，w[i][j] 的值代表编号为i，j 的队伍中更强的一支。
所以w[i][j]=i 或者j，现在给出它们的出场顺序，并存储在数组order[n]中，
比如order[n] = {4,3,5,8,1......}，那么第一轮比赛就是4 对3， 5 对8。.......
胜者晋级，败者淘汰，同一轮淘汰的所有队伍排名不再细分，即可以随便排，
下一轮由上一轮的胜者按照顺序，再依次两两比，比如可能是4 对5,直至出现第一名
编程实现，给出二维数组w，一维数组order 和用于输出比赛名次的数组result[n]，
求出result。

Solutions:
loser teams fill in last half in remainding result
winner teams fill in first half in order inplace
*/

public int[] match(int[][] w, int[] order) {
	int len = order.length, result[] = new int[len], dxOrder, idxResult;
	while (len >= 2) {
		idxOrder = 0 ;
		idxResult = len / 2;
		for (int i = 0; i < len; i = i + 2) {
			int winner = w[order[i]][order[i + 1]], loser = order[i] == winner ? order[i + 1] : order[i];
			order[idxOrder++] = winner;
			result[idxResult++] = loser;
		}	
		len /= 2;
	}
	result[0] = order[0];
	return result;
}