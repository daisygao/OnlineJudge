public class Solution {
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuilder rows[] = new StringBuilder[nRows];
        for (int i = 0; i < nRows; i++) rows[i] = new StringBuilder();
        int len = s.length(), idx = 0, row = 0;
        while (idx < len) {
            while (idx < len && row < nRows) rows[row++].append(s.charAt(idx++));
            row = Math.max(0, nRows - 2);
            while (idx < len && row > 0) rows[row--].append(s.charAt(idx++));
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb : rows) ans.append(sb.toString());
        return ans.toString();
    }
}