public class Solution {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = A.length;
        if (len < 3) return 0;
        int maxArr[] = new int[len];
        for (int i = 0; i < len; i++) {
            maxArr[i] = i == 0 ? A[i] : (A[i] > maxArr[i - 1] ? A[i] : maxArr[i - 1]);
        }
        int result = 0;
        for (int i = len - 1; i >= 0; i--) {
            int tmp = i == len - 1 ? A[i] : (A[i] > maxArr[i + 1] ? A[i] : maxArr[i + 1]);
            maxArr[i] = Math.min(tmp, maxArr[i]);
            result += maxArr[i] - A[i];
        }
        return result;
    }
}