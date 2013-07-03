public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = triangle.size(), ans = 0, sols[] = new int[n];
        for (ArrayList<Integer> list : triangle) {
            ans = Integer.MAX_VALUE;
            for (int i = list.size() - 1; i >= 0; i--) {
                int prev = 0;
                if (i == list.size() -1 && i == 0) prev = 0;
                else if (i == list.size() - 1) prev = sols[i - 1];
                else if (i == 0) prev = sols[i];
                else prev = Math.min(sols[i - 1], sols[i]);
                sols[i] = list.get(i) + prev;
                ans = Math.min(sols[i], ans);
            }
        }
        return ans;
    }
}