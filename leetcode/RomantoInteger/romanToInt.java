public class Solution {
    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int nums[] = {1, 5, 10, 50, 100, 500, 1000};
        String alphs[] = {"I", "V", "X", "L", "C", "D", "M"};
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < nums.length; i++) map.put(alphs[i], nums[i]);
        int len = s.length(), ans = 0, start = 0, end = 0;
        while (end < len) {
            while (end + 1 < len && s.charAt(end + 1) == s.charAt(start)) end++;
            int cur = map.get(String.valueOf(s.charAt(start))), val = (end - start + 1) * cur;
            ans += val;
            if (end + 1 < len) {
                int next = map.get(String.valueOf(s.charAt(end + 1)));
                if (next > cur) {
                    ans -= val * 2;
                }
            }
            start = end = end + 1;
        }
        return ans;
    }
}