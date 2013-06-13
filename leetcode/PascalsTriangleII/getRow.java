public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> row = new ArrayList<Integer>();
        int idx = 0;
        row.add(1);
        while (++idx <= rowIndex) {
            for (int i = idx; i >= 0; i--) {
                int x = (i - 1 >= 0 ? row.get(i - 1) : 0) 
		    + (i == idx ? 0 : row.get(i));
                if (i == idx) row.add(x);
                else row.set(i, x);
            }
        }
        return row;
    }
}