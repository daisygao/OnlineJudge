public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int len = s.length(), max = 0, start = -1, end = 0;
        while (end < len) {
            String key = String.valueOf(s.charAt(end));
            if (map.containsKey(key)) {
                int prev = start;
                start = map.get(key);
                for (int i = prev + 1; i < start; i++) {
                    map.remove(String.valueOf(s.charAt(i)));
                }
            } 
            map.put(key, end);
            max = Math.max(max, end - start);
            end++;
        }
        return max;
    }
}