public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> vq = new ArrayList<String>(dict.size());
        HashMap<String, Integer> reached = new HashMap<String, Integer>(dict.size());
        int i = 0;
        vq.add(start);
        reached.put(start, 1);
        while (i != vq.size()) {
            String v = vq.get(i);
            int d = reached.get(v);
            for (int j = 0; j < v.length(); j++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == v.charAt(j)) continue;
                    StringBuilder sb = new StringBuilder(v);
                    sb.setCharAt(j, c);
                    String u = sb.toString();
                    if (u.equals(end) && (d != 1 || dict.contains(start) || dict.contains(end))) {
                        return d + 1;
                    }
                    if (!dict.contains(u) || reached.containsKey(u)) continue;
                    vq.add(u);
                    reached.put(u, d + 1);
                }
            }
            i++;
        }
        return 0;
    }
}