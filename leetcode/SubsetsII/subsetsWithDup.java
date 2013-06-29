public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> idx = new ArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        result.add(list);
        idx.add(-1);
        Arrays.sort(num);
        int cur = 0, start, len = num.length;
        while (cur < result.size()) {
            start = idx.get(cur) + 1;
            for (; start < len; start++) {
                list = new ArrayList<Integer>(result.get(cur));
                list.add(num[start]);
                result.add(list);
                idx.add(start);
                while (start + 1 < len && num[start + 1] == num[start]) start++;
            }
            cur++;
        }
        return result;
    }
}