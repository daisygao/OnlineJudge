public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper(s, 0); 
    }
    private ArrayList<String> helper(String s, int cnt) {
        int slen = s.length();
        ArrayList<String> result = new ArrayList<String>();
        for (int len = Math.min(slen, 3); len > 0; len--) {
            String num = s.substring(0, len);
            int val = Integer.parseInt(num);
            if ((num.charAt(0) != '0' || len == 1) && (val >= 0 && val < 256)) {
                if (cnt == 3 && len == slen) {
                    result.add(num);
                } else if (cnt < 3) {
                    for (String back : helper(s.substring(len), cnt + 1)) {
                        result.add(num + "." + back);
                    }
                }
            }
        }
        return result;
    }
}