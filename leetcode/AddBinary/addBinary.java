public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int alen = a.length(), blen = b.length(), len = Math.max(alen, blen);
        StringBuilder sb = new StringBuilder();
        int cur = 0, next = 0;
        for (int i = 0; i < len; i++) {
            int abit = i < alen ? a.charAt(alen - 1 - i) - '0' : 0;
            int bbit = i < blen ? b.charAt(blen - 1 - i) - '0' : 0;
            cur = abit + bbit + next;
            next = cur / 2;
            sb.append(cur % 2);
        }
        if (next > 0) sb.append(1);
        return sb.reverse().toString();
    }
}