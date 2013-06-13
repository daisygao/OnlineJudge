public class Solution {
    ArrayList<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(n, k, 1, list);
        return result;
    }
    private void helper(int n, int k, int m, ArrayList<Integer> list) {
        for (int i = m; i <= n; i++) {
            if (k > 0) {
                k -= 1;
                list.add(i);
                if (k == 0) {
                    result.add(new ArrayList<Integer>(list));
                } else {
                    helper(n, k, i + 1, list); 
                }
                k += 1;
                list.remove(list.size() - 1);
            }
        }
    }
}