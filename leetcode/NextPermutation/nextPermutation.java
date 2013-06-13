public class Solution {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = num.length, i = len - 1;
        while (--i >= 0 && num[i] >= num[i + 1]);
        int idx = i + 1;
        if (i >= 0) {
            int val = num[i];
            while (i + 1 < len && num[i + 1] > val) i++;
            num[idx - 1] = num[i];
            num[i] = val;
        }
        // reverse idx, len
        for (i = 0; i < (len - idx) / 2; i++) {
            int val = num[idx + i];
            num[idx + i] = num[len - 1 - i];
            num[len - 1 - i] = val;
        }
    }
}