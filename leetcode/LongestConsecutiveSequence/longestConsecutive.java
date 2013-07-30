public class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Integer> range = new HashMap<Integer, Integer>();
        int max = 1;
        for (int x : num) {
            if (!range.containsKey(x)) {
                range.put(x, 1);
                if (range.containsKey(x - 1)) max = Math.max(max, merge(x - 1, x, range));
                if (range.containsKey(x + 1)) max = Math.max(max, merge(x, x + 1, range));
            }
        }
        return max;
    }
    private int merge(int x, int y, HashMap<Integer, Integer> range) {
        int left = x - range.get(x) + 1, right = y + range.get(y) - 1, len = right - left + 1;
        range.put(left, len);
        range.put(right, len);
        return len;
    }
}