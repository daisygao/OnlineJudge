public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = digits.length, idx = len - 1;
        while (idx >= 0 && digits[idx] == 9) {
            digits[idx--] = 0;
        }
        if (idx < 0) {
            int result[] = new int[len + 1];
            for (int i = 0; i <= len; i++) {
                result[i] = i == 0 ? 1 : digits[i - 1];
            }
            return result;
        } 
        digits[idx] += 1;
        return digits;
    }
}