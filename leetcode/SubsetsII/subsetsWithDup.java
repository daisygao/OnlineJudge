public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>(), pos = new ArrayList<Integer>();
        ans.add(list);
        pos.add(0);
        Arrays.sort(num);
        int idx = 0, len = num.length;
        while (idx < ans.size()) {
            list = ans.get(idx);
            for (int s = pos.get(idx); s < len; s++) {
                ArrayList<Integer> newList = new ArrayList<Integer>(list);
                newList.add(num[s]);
                ans.add(newList);
                pos.add(s + 1);
                while (s + 1 < len && num[s + 1] == num[s]) s++;
            }
            idx++;
        }
        return ans;
    }
}