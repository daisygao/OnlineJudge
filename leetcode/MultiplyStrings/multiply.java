public class Solution {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1 = num1.length(), len2 = num2.length(), len = len1 + len2;
        int sol[] = new int[len];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int x = num1.charAt(i) - '0';
                int y = num2.charAt(j) - '0';
                int offset = len - i - j - 2;
                int res = x * y + sol[offset];
                sol[offset + 1] += res / 10;
                sol[offset] = res % 10;
            }
        }
        int idx = len - 1;
        StringBuilder sb = new StringBuilder();
        while (idx > 0 && sol[idx] == 0) idx--;
        while (idx >= 0) sb.append(sol[idx--]);
        return sb.toString();
    }
}