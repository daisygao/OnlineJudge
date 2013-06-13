public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = num.length;
        boolean used[] = new boolean[len];
        return helper(num, used, 0, len);
    }
    private ArrayList<ArrayList<Integer>> helper(int[] num, boolean[] used, int idx, int len) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                used[i] = true;
                if (idx == len - 1) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    result.add(list);
                } else {
                    for (ArrayList<Integer> list : helper(num, used, idx + 1, len)) {
                        list.add(0, num[i]);
                        result.add(list);
                    }
                }
                used[i] = false;
            }
        }
        return result;
    }
}