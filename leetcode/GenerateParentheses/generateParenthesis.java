public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper(n, n);
    }
    private ArrayList<String> helper(int left, int right) {
        ArrayList<String> res = new ArrayList<String>();
        if (left != 0 && left <= right) {
            for (String s : helper(left - 1, right)) {
                res.add("(" + s);
            }
        }
        if (right != 0 && left < right) {
            if (right == 1) res.add(")");
            else {
                for (String s : helper(left, right - 1)) {
                    res.add(")" + s);
                }
            }
        }
        return res;
    }
}