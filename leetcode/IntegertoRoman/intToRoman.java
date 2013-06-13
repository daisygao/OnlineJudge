public class Solution {
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int nums[] = {1, 5, 10, 50, 100, 500, 1000};
        String alphs[] = {"I", "V", "X", "L", "C", "D", "M"};
        int len = nums.length, idx = 0;
        StringBuilder sb = new StringBuilder();
        while (num > 0 && idx < len) {
            int x = num % 10;
            if (x > 0) {
                if (x % 5 == 4) {
                    sb.append(alphs[idx + 1 + x / 5]);
                    sb.append(alphs[idx]);
                } else {
                    for (int i = 0; i < x % 5; i++) {
                        sb.append(alphs[idx]);
                    }
                    if (x >= 5) sb.append(alphs[idx + 1]);
                }                
            }
            num /= 10;
            idx += 2;
        }
        return sb.reverse().toString();
    }
}