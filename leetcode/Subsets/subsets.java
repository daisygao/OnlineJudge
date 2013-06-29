public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(10000);
        ArrayList<Integer> list = new ArrayList<Integer>();
        result.add(list);
        for (int x : S) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                list = new ArrayList<Integer>(result.get(i));
                list.add(x);
                result.add(list);
            }
        }
        return result;
    }
}