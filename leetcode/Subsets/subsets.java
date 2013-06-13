public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = S.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        result.add(list);
        Arrays.sort(S);
        for (int x : S) {
            ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> l : result) {
                list = new ArrayList<Integer>(l);
                list.add(x);
                tmp.add(list);
            }
            result.addAll(tmp);
        }
        return result;
    }
}