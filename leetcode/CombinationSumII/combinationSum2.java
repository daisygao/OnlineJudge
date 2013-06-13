public class Solution {
    ArrayList<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(num, target, list, 0);
        return result;
    }
    private void helper(int[] num, int target, ArrayList<Integer> list, int idx) {
        for (int i = idx; i < num.length; i++) {
            int x = num[i];
            if (target >= x) {
                target -= x;
                list.add(x);
                if (target == 0) {
                    result.add(new ArrayList<Integer>(list));
                } else {
                    helper(num, target, list, i + 1);
                }
                target += x;
                list.remove(list.size() - 1);
            } else break;
            while (i + 1 < num.length && num[i + 1] == x) i++;
        }
    }
}