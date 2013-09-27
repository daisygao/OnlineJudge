public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper(s, 1);
    }
    private ArrayList<String> helper(String s, int cnt) {
        ArrayList<String> ans = new ArrayList<String>();
        int len = s.length();
        for (int i = 1; i <= Math.min(3, len); i++) {
            String s1 = s.substring(0, i), s2 = s.substring(i);
            int x = Integer.valueOf(s1);
            if (x >= 0 && x < 256 && (s1.charAt(0) != '0' || s1.length() == 1)) {
                if (cnt == 4 && i == len) {
                    ans.add(s);
                } else if (cnt < 4) {
                    for (String back : helper(s2, cnt + 1)) {
                        ans.add(s1 + "." + back);
                    }
                }
            }
        }
        return ans;
    }
}