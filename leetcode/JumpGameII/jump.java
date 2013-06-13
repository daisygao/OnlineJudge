public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = A.length, max = 1;
        int sol[] = new int[len];
        for (int i = 0; i < Math.min(max, len); i++) {
            int jump = Math.min(i + A[i] + 1, len);
            for (int j = max; j < jump; j++) {
                sol[j] = sol[i] + 1;
            }
            if (jump == len) return sol[len - 1];
            max = Math.max(max, jump);
        }
        return 0;
    }
}