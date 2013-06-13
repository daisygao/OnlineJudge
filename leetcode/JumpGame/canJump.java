public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = 0, len = A.length;
        for (int i = 0; i <= Math.min(len - 1, max); i++) {                
            max = Math.max(max, A[i] + i);
            if (max >= len - 1) return true;
        }
        return false;
    }
}