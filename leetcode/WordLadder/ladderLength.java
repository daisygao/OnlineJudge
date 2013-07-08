public class Solution {

    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int idx = 0;
        ArrayList<String> queue = new ArrayList<String>(dict.size());
        HashMap<String, Integer> path = new HashMap<String, Integer>();
        queue.add(start);
        path.put(start, 1);
        while (idx < queue.size()) {
            String u = queue.get(idx);
            for (int i = 0; i < u.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == u.charAt(i)) continue;
                    StringBuilder sb = new StringBuilder(u);
                    sb.setCharAt(i, c);
                    String v = sb.toString();
                    if (dict.contains(v) && !path.containsKey(v)) {
                        path.put(v, path.get(u) + 1);
                        queue.add(v);
                    }
                    if (v.equals(end) && (!u.equals(start) || dict.contains(start) || dict.contains(end))) {
                        return path.get(u) + 1;
                    }
                }
            }           
            idx++;
        }
        return 0;
    }
}