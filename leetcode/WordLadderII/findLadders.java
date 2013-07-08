public class Solution {
      public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> queue = new ArrayList<String>();
        HashMap<String, Integer> dist = new HashMap<String, Integer>();
        HashMap<String, ArrayList<String>> parent = new HashMap<String, ArrayList<String>>();
        queue.add(start);
        dist.put(start, 1);
        int idx = 0, min = Integer.MAX_VALUE;
        while (idx < queue.size()) {
            String u = queue.get(idx);
            if (dist.get(u) >= min) break;
            for (int i = 0; i < u.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == u.charAt(i)) continue;
                    StringBuilder sb = new StringBuilder(u);
                    sb.setCharAt(i, c);
                    String v = sb.toString();
                    if (dict.contains(v) && (!dist.containsKey(v) || dist.get(v) == dist.get(u) + 1)) {
                        ArrayList<String> list = dist.containsKey(v) ? parent.get(v) : new ArrayList<String>();
                        list.add(u);
                        parent.put(v, list);
                        if (!dist.containsKey(v)) {
                            dist.put(v, dist.get(u) + 1);
                            queue.add(v);
                        }
                    }
                    if (v.equals(end)) {
                        min = dist.get(u) + 1;
                    }
                }
            }
            idx++;
        }
        return genPaths(end, parent, start);
    }
    private ArrayList<ArrayList<String>> genPaths(String u, HashMap<String, ArrayList<String>> parent, String start) {
        ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
        if (parent.containsKey(u)) {
            for (String v : parent.get(u)) {
                for (ArrayList<String> list : genPaths(v, parent, start)) {
                    list.add(u);
                    ans.add(list);
                }
            }
        } else if (u.equals(start)) {
            ArrayList<String> list = new ArrayList<String>();
            list.add(start);
            ans.add(list);
        }
        return ans;
    }
}