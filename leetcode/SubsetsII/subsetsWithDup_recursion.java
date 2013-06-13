public class Solution {
    ArrayList<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        ArrayList<Integer> list = new ArrayList<Integer>();
        result.add(list);
        helper(num, list, 0);
        return result;
    }
    private void helper(int[] num, ArrayList<Integer> list, int idx) {
        for (int i = idx; i < num.length; i++) {
            list.add(num[i]);
            result.add(new ArrayList<Integer>(list));
            helper(num, list, i + 1);
            list.remove(list.size() - 1);
            while (i + 1 < num.length && num[i + 1] == num[i]) i++;
        }
    }
}