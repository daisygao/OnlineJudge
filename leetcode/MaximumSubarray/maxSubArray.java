public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = Integer.MIN_VALUE, cur = 0;
        for (int x : A) {
            cur += x;
            max = Math.max(max, cur);
            if (cur < 0) cur = 0;
        }
        return max;
    }
}