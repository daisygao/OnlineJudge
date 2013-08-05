public class Solution {
    private ArrayList<ArrayList<String>> output(String u, HashMap<String, ArrayList<String>> parents, String start) {
        ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
        if (parents.containsKey(u)) {
            for (String s : parents.get(u)) {
                for (ArrayList<String> list : output(s, parents, start)) {
                    list.add(u);
                    ans.add(list);
                }
            }
        } else if (u.equals(start)) {
            ArrayList<String> list = new ArrayList<String>();
            list.add(u);
            ans.add(list);
        }
        return ans;
    }
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> queue = new ArrayList<String>();
        HashMap<String, ArrayList<String>> parents = new HashMap<String, ArrayList<String>>();
        HashMap<String, Integer> dist = new HashMap<String, Integer>();
        queue.add(start);
        dist.put(start, 0);
        int idx = 0, min = Integer.MAX_VALUE;
        while (idx < queue.size()) {
            String u = queue.get(idx);
            int d = dist.get(u);
            if (d == min) break;
            for (int i = 0; i < u.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == u.charAt(i)) continue;
                    StringBuilder sb = new StringBuilder(u);
                    sb.setCharAt(i, c);
                    String v = sb.toString();
                    // update parent
                    if (dict.contains(v) || (v.equals(end) && (!u.equals(start) || dict.contains(start)))) {
                        if (!dist.containsKey(v)) {
                            dist.put(v, d + 1);
                            ArrayList<String> list = new ArrayList<String>();
                            list.add(u);
                            parents.put(v, list);
                            queue.add(v);
                        } else if (dist.get(v) == d + 1) {
                            parents.get(v).add(u);
                        }
                        if (v.equals(end)) min = Math.min(min, d + 1);
                    }
                }
            }
            idx++;
        }
        return output(end, parents, start);
    }
}