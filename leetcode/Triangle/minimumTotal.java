public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = triangle.size(), sols[] = new int[len], ans = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                sols[j] = triangle.get(i).get(j) + (i == 0 ? 0 : Math.min(
                    j == 0 ? Integer.MAX_VALUE : sols[j - 1],
                    j == i ? Integer.MAX_VALUE : sols[j]));
                if (i == len - 1 && sols[j] < ans) ans = sols[j];
            }
        }
        return ans;
    }
}