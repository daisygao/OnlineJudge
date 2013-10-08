
10.8.2013
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ans.add(new ArrayList<Integer>());
        Arrays.sort(S);
        for (int x : S) {
            for (int i = ans.size() - 1; i >= 0; i--) {
                ArrayList<Integer> list = new ArrayList<Integer>(ans.get(i));
                list.add(x);
                ans.add(list);
            }
        }
        return ans;
    }
}
