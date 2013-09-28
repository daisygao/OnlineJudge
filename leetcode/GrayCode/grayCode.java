public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(0);
        for (int i = 0; i < n; i++) {
            for (int j = ans.size() - 1; j >= 0; j--) {
                ans.add((1 << i) | ans.get(j));
            }
        }
        return ans;
    }
}