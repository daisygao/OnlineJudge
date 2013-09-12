public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> ans = new ArrayList<Integer>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == i) {
                    int x = i == 0 ? 1 : ans.get(ans.size() - 1);
                    ans.add(x);
                } else {
                    ans.set(j, (j == 0 ? 0 : ans.get(j - 1)) + ans.get(j));
                }
            }
        }
        return ans;
    }
}