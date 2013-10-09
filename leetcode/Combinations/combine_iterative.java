public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>(), queue = new ArrayList<ArrayList<Integer>>();
        if (k == 0 || n < k) return ans;
        queue.add(new ArrayList<Integer>());
        int idx = 0;
        while (idx < queue.size()) {
            ArrayList<Integer> list = queue.get(idx++);
            int x = 1 + (list.size() == 0 ? 0 : list.get(list.size() - 1));
            for (; x <= n; x++) {
                ArrayList<Integer> list_ans = new ArrayList<Integer>(list);
                list_ans.add(x);
                if (list_ans.size() == k) ans.add(list_ans);
                else queue.add(list_ans);
            }
        }
        return ans;
    }
}