public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String seq = n > 0 ? "1" : "0";
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < seq.length(); i++) {
                int j = i;
                while (j < seq.length() && seq.charAt(j) == seq.charAt(i)) j++;
                sb.append(j - i);
                sb.append(seq.charAt(i));
                i = j - 1;
            }
            seq = sb.toString();
        }
        return seq;
    }
}