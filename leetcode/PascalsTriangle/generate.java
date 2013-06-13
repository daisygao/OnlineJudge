public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0) return result;
        ArrayList<Integer> list = new ArrayList<Integer>(numRows);
        list.add(1);
        result.add(new ArrayList<Integer>(list));
        int cnt = 0;
        while (++cnt < numRows) {
            for (int i = cnt; i >= 0; i--) {
                int x = (i - 1 >= 0 ? list.get(i - 1) : 0) + 
		    (i == cnt ? 0 : list.get(i));
                if (i == cnt) list.add(x);
                else list.set(i, x);
            }
            result.add(new ArrayList<Integer>(list));
        }
        return result;        
    }
}