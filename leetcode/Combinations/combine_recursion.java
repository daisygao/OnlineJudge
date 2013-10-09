public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return helper(n, k, 1);
    }
    private ArrayList<ArrayList<Integer>> helper(int n, int k, int idx) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (k <= 0 || n < k || idx > n) return ans;
        for (int i = idx; i <= n; i++) {
            if (k == 1) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                ans.add(list);
            } else {
                for (ArrayList<Integer> list : helper(n, k - 1, i + 1)) {
                    list.add(0, i);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}