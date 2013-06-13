public class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = num.length;
        if (len == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 1;
        for (int x : num) {
            if (map.containsKey(x)) continue;
            map.put(x, 1);
            if (map.containsKey(x - 1)) {
                max = Math.max(max, merge(map, x - 1, x));
            } 
            if (map.containsKey(x + 1)) {
                max = Math.max(max, merge(map, x, x + 1));
            }
        }
        return max;
    }
    public int merge(HashMap<Integer, Integer> map, int left, int right) {
        int upper = right + map.get(right) - 1;
        int lower = left - map.get(left) + 1;
        int len = upper - lower + 1;
        map.put(upper, len);
        map.put(lower, len);
        return len;
    }
}