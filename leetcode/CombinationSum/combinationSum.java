public class Solution {
    ArrayList<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(candidates);
        result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(candidates, target, list, 0);
        return result;
    }
    private void helper(int[] candidates, int target, ArrayList<Integer> list, int index) {
        for (int i = index; i < candidates.length; i++) {
            int x = candidates[i];
            if (x <= target) {
                target -= x;
                list.add(x);
                if (target == 0) {
                    result.add(new ArrayList<Integer>(list));
                } else {
                    helper(candidates, target, list, i);
                }
                target += x;
                list.remove(list.size() - 1);
            }
            while (i + 1 < candidates.length && candidates[i + 1] == x) i++;
        }
    }
}