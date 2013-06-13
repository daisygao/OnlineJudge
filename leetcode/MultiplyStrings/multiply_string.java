public class Solution {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1 = num1.length(), len2 = num2.length();
        if (len1 == 0 || len2 == 0) return "0";
        String prev = null;        
        StringBuilder sb = new StringBuilder();
        int add = 0;
        for (int i = len1 - 1; i >= 0; i--) {
            for (int k = len1 - 1; k > i; k--) sb.append("0");
            for (int j = len2 - 1; j >= 0; j--) {
                int x = num1.charAt(i) - '0';
                int y = num2.charAt(j) - '0';
                int sum = x * y + add;
                add = sum / 10;
                sb.append(sum % 10);
            }
            if (add != 0) sb.append(add);
            prev = addReverseStr(prev, sb.toString());
            add = 0;
            sb = new StringBuilder();
        }
        int idx = prev.length() - 1;
        sb = new StringBuilder(prev);
        while (idx > 0 && prev.charAt(idx) == '0') {
            sb.deleteCharAt(idx--);
        }
        return sb.reverse().toString();
    }
    private String addReverseStr(String str1, String str2) {
        if (str1 == null) return str2;
        int len1 = str1.length(), len2 = str2.length();
        int add = 0;
        StringBuilder sb = new StringBuilder();
        int i, j;
        for (i = 0, j = 0; i < len1 || j < len2; i++, j++) {
            int x = i < len1 ? (str1.charAt(i) - '0') : 0;
            int y = j < len2 ? (str2.charAt(j) - '0') : 0;
            int sum = x + y + add;
            add = sum / 10;
            sb.append(sum % 10);
        }
        if (add != 0) sb.append(add);
        return sb.toString();
    }
}