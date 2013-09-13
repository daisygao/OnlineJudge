public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>(numRows);
        ArrayList<Integer> row = new ArrayList<Integer>(numRows);
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == i) {
                    int x = i == 0 ? 1 : row.get(i - 1);
                    row.add(x);
                } else {
                    row.set(j, (j == 0 ? 0 : row.get(j - 1)) + row.get(j));
                }
            }
            ans.add(new ArrayList<Integer>(row));
        }
        return ans;
    }
}