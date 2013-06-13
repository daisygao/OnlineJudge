public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add((1 << i) + res.get(j));
            }
        }
        return res;
    }
}