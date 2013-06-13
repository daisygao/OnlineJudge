public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        int len = num.length, idx = 0;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>(), cur;
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> prevPos = new ArrayList<Integer>(), pos;
        prev.add(list);
        result.addAll(prev);
        prevPos.add(-1);
        while (prev.size() != 0) {
            cur = new ArrayList<ArrayList<Integer>>();
            pos = new ArrayList<Integer>();
            for (int i = 0; i < prev.size(); i++) {
                int lastIdx = prevPos.get(i);
                list = prev.get(i);
                for (int j = lastIdx + 1; j < len; j++) {
                    ArrayList<Integer> newList = new ArrayList<Integer>(list);
                    newList.add(num[j]);
                    pos.add(j);
                    cur.add(newList);
                    while (j + 1 < len && num[j + 1] == num[j]) j++; 
                }
            }
            result.addAll(cur);
            prev = cur;
            prevPos = pos;
        }
        return result;       
    }
}