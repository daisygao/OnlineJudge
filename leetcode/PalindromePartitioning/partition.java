public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length();
        boolean isPalin[][] = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 3 || isPalin[i + 1][j - 1])) isPalin[i][j] = true;
            }
        }
        return helper(s, 0, isPalin);
    }
    private ArrayList<ArrayList<String>> helper(String s, int start, boolean[][] isPalin) {
        ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
        for (int i = start; i < s.length(); i++) {
            if (isPalin[start][i]) {
                String front = s.substring(start, i + 1);
                if (i == s.length() - 1) {
                    ArrayList<String> list = new ArrayList<String>();
                    list.add(front);
                    ans.add(list);
                } else {
                    for (ArrayList<String> list : helper(s, i + 1, isPalin)) {
                        list.add(0, front);
                        ans.add(list);
                    }
                }
            }
        }
        return ans;
    }
}
